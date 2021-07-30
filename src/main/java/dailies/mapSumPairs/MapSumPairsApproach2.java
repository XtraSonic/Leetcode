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

    static class PartialKey {
        Map<Character, PartialKey> nextElements;
        int val;

        public PartialKey() {
            nextElements = new HashMap<>();
        }

        public void insert(String key, int val) {
            PartialKey current = this;
            for (char c : key.toCharArray()) {
                PartialKey next = current.nextElements.get(c);
                if (next == null) {
                    next = new PartialKey();
                    current.nextElements.put(c, next);
                }
                current = next;
            }
            current.val = val;
        }

        public int sum(String prefix) {
            PartialKey current = this;
            for (char c : prefix.toCharArray()) {
                PartialKey next = current.nextElements.get(c);
                if (next == null) {
                    return 0;
                }
                current = next;
            }
            return current.sum();
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
