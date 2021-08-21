package dailies.paintHouseII;

public class PaintHouseIIApproach1 implements PaintHouseII {

    @Override
    public int minCostII(int[][] costs) {
        // minCosts[0] contains the lowest two costs so far with minCosts[0][0] being the lowest
        // minCosts[1] contains the index used last to achieve the price form minCosts[0]
        int[][] minCosts = new int[][]{{0, -1}, {0, -1}};

        for (int houseIndex = 0; houseIndex < costs.length; houseIndex++) {
            int[][] minCostsForThisHouse = new int[][]{{Integer.MAX_VALUE, -1}, {Integer.MAX_VALUE, -1}};

            for (int paintIndex = 0; paintIndex < costs[houseIndex].length; paintIndex++) {
                int possibleNewMin;
                if (minCosts[0][1] != paintIndex) {
                    // since a different paint was used previously for the lowest cost,
                    // we can use that cost together with the cost for the current paint
                    possibleNewMin = minCosts[0][0] + costs[houseIndex][paintIndex];
                } else {
                    // since the same paint was used previously for the lowest cost,
                    // we need to use the second lowest previous cost together with the cost for the current paint
                    possibleNewMin = minCosts[1][0] + costs[houseIndex][paintIndex];
                }

                if (minCostsForThisHouse[0][0] > possibleNewMin) {
                    minCostsForThisHouse[1][0] = minCostsForThisHouse[0][0];
                    minCostsForThisHouse[1][1] = minCostsForThisHouse[0][1];
                    minCostsForThisHouse[0][0] = possibleNewMin;
                    minCostsForThisHouse[0][1] = paintIndex;
                } else {
                    if (minCostsForThisHouse[1][0] > possibleNewMin) {
                        minCostsForThisHouse[1][0] = possibleNewMin;
                        minCostsForThisHouse[1][1] = paintIndex;
                    }
                }
            }
            minCosts = minCostsForThisHouse;
        }

        return minCosts[0][0];
    }
}
