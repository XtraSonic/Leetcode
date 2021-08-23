package dailies.twoSumIV_InputIsABST;

import commonUtilities.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class TwoSumIV_InputIsABSTTest {
    TwoSumIV_InputIsABST twoSumIV_InputIsABST;

    @Test
    void testExample1() {
        assertTrue(twoSumIV_InputIsABST.findTarget(TreeNode.createFromArray(5, 3, 6, 2, 4, null, 7), 9));
    }

    @Test
    void testResOnDifBranches() {
        assertTrue(twoSumIV_InputIsABST.findTarget(TreeNode.createFromArray(5, 3, 6, 2, 4, null, 7), 6));
    }

    @Test
    void testResOnDifBranchesFromRoot() {
        assertTrue(twoSumIV_InputIsABST.findTarget(TreeNode.createFromArray(5, 3, 6, 2, 4, null, 100), 102));
    }

    @Test
    void testExample2() {
        assertFalse(twoSumIV_InputIsABST.findTarget(TreeNode.createFromArray(5, 3, 6, 2, 4, null, 7), 28));
    }

    @Test
    void testExample3() {
        assertTrue(twoSumIV_InputIsABST.findTarget(TreeNode.createFromArray(2, 1, 3), 4));
    }

    @Test
    void testExample4() {
        assertFalse(twoSumIV_InputIsABST.findTarget(TreeNode.createFromArray(2, 1, 3), 1));
    }

    @Test
    void testExample5() {
        assertTrue(twoSumIV_InputIsABST.findTarget(TreeNode.createFromArray(2, 1, 3), 3));
    }
}
