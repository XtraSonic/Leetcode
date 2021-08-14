package dailies.paintFence;

public class PaintFenceApproach1 implements PaintFence {

    @Override
    public int numWays(int n, int k) {
        return numWays2(n, k);
    }

    private int numWays2(int n, int k) {
        if (n == 1)
            return k;
        if (n == 2)
            return k * k;

        return (k - 1) * (numWays(n - 1, k) + numWays(n - 2, k));
    }
}
