package dailies.beautifulArray;

import java.util.stream.IntStream;

public class BeautifulArrayApproach3 implements BeautifulArray {
    @Override
    public int[] beautifulArray(int n) {
        int lengthInBits = Integer.bitCount(n);
        return IntStream
                .range(1, n + 1)
                .boxed()
                .map(Integer::toBinaryString)
                .map((String s) -> {
                    while (s.length() < lengthInBits) {
                        s = "0" + s;
                    }
                    return s;
                })
                .map((String s) -> new StringBuilder(s).reverse().toString())
                .sorted()
                .map((String s) -> new StringBuilder(s).reverse().toString())
                .map(s1 -> Integer.valueOf(s1, 2))
                .mapToInt(e -> e).toArray();
    }
}
