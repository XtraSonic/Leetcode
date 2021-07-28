package dailies.beautifulArray;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrayApproach1 implements BeautifulArray {

    @Override
    public int[] beautifulArray(int n) {
        List<Integer> integersLeft = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            integersLeft.add(i);
        }

        return insertValue(new ArrayList<>(), integersLeft).stream().mapToInt(e -> e).toArray();
    }

    public List<Integer> insertValue(List<Integer> listSoFar, List<Integer> integersLeft) {
        if (integersLeft.isEmpty())
            return listSoFar;
        for (Integer currentValue : integersLeft) {
            List<Integer> newIntegersLeft = new ArrayList<>(integersLeft);
            newIntegersLeft.remove(currentValue);
            if (isValidValue(listSoFar, currentValue, newIntegersLeft)) {
                listSoFar.add(currentValue);
                List<Integer> result = insertValue(listSoFar, newIntegersLeft);
                if (result != null) {
                    return result;
                } else {
                    listSoFar.remove(currentValue);
                }
            }
        }
        return null;
    }

    public boolean isValidValue(List<Integer> listSoFar, int numsK, List<Integer> integersLeft) {
        for (Integer integer : listSoFar) {
            if (!isValidValue(integer, numsK, integersLeft))
                return false;
        }
        return true;
    }

    public boolean isValidValue(int numsI, int numsK, List<Integer> integersLeft) {
        return !(integersLeft.contains(numsK * 2 - numsI));
    }
}
