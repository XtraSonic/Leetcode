package dailies.uniqueBinarySearchTreesII;

import commonUtilities.TreeNode;
import org.junit.jupiter.api.Test;
import utilities.TestUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class UniqueBinarySearchTreesIITest {
    UniqueBinarySearchTreesII uniqueBinarySearchTreesII;

    @Test
    void testExample1() {
        evaluateUniqueBinarySearchTrees(Arrays.asList(
                TreeNode.createFromArray(1, null, 2, null, 3),
                TreeNode.createFromArray(1, null, 3, 2),
                TreeNode.createFromArray(2, 1, 3),
                TreeNode.createFromArray(3, 1, null, null, 2),
                TreeNode.createFromArray(3, 2, null, 1)
                ),
                3
        );
    }

    @Test
    void testExample2() {
        evaluateUniqueBinarySearchTrees(Arrays.asList(TreeNode.createFromArray(1)), 1);
    }

    private void evaluateUniqueBinarySearchTrees(List<TreeNode> expected, int n) {
        List<TreeNode> actual = uniqueBinarySearchTreesII.generateTrees(n);
        if (!TestUtils.areTheSameOutOfOrder(expected, actual)) {
            fail("\nExpected:\n" + expected + "\nActual:\n" + actual);
        }
    }


}
