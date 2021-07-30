package dailies.mapSumPairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapSumPairsApproach1 implements MapSumPairs {
    private Map<String, Integer> map;
    private Map<String, Set<String>> prefixes;

    public MapSumPairsApproach1() {
        this.map = new HashMap<>();
        this.prefixes = new HashMap<>();
    }

    @Override
    public void insert(String key, int val) {
        map.put(key, val);
        char[] chars = key.toCharArray();
        String prefix = "";
        for (char c : chars) {
            prefix += c;
            if (prefixes.containsKey(prefix)) {
                prefixes.get(prefix).add(key);
            } else {
                HashSet<String> to = new HashSet<>();
                to.add(key);
                prefixes.put(prefix, to);
            }
        }
    }

    @Override
    public int sum(String prefix) {
        int result = 0;
        Set<String> keys = prefixes.get(prefix);
        if (keys == null)
            return 0;
        for (String key : keys) {
            if (map.containsKey(key))
                result += map.get(key);
        }
        return result;
    }
}
