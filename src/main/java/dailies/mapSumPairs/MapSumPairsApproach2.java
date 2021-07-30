package dailies.mapSumPairs;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairsApproach2 implements MapSumPairs {

    PartialKey root = new PartialKey();


    @Override
    public void insert(String key, int val) {
        root.insert(key, val);
    }

    @Override
    public int sum(String prefix) {
        return root.sum(prefix);
    }

    class PartialKey {
        Map<Character, PartialKey> nextElements;
        int val;

        public PartialKey() {
            nextElements = new HashMap<>();
        }

        public void insert(String key, int val) {
            if (key.isEmpty()) {
                this.val = val;
                return;
            }
            char charKey = key.charAt(0);
            PartialKey next;
            if (nextElements.containsKey(charKey)) {
                next = nextElements.get(charKey);
            } else {
                next = new PartialKey();
            }
            nextElements.put(charKey, next);
            next.insert(key.substring(1), val);
        }

        public int sum(String prefix) {
            if (prefix.isEmpty()) {
                return sum();
            }
            char charKey = prefix.charAt(0);
            if (nextElements.containsKey(charKey)) {
                return nextElements.get(charKey).sum(prefix.substring(1));
            } else {
                return 0;
            }
        }

        public int sum() {
            int result = val;
            for (PartialKey next : nextElements.values()) {
                result += next.sum();
            }
            return result;
        }
    }
}
