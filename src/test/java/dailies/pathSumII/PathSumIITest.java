package dailies.pathSumII;

import commonUtilities.TreeNode;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static utilities.TestUtils.compareListsWithInOrderElements;

public abstract class PathSumIITest {
    PathSumII pathSumII;

    @Test
    void testExample1() {
        compareListsWithInOrderElements(asList(
                asList(5, 4, 11, 2),
                asList(5, 8, 4, 5)
        ), pathSumII.pathSum(TreeNode.createFromArray(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
    }

    @Test
    void testExample2() {
        compareListsWithInOrderElements(asList(
        ), pathSumII.pathSum(TreeNode.createFromArray(1, 2, 3), 5));
    }

    @Test
    void testExample3() {
        compareListsWithInOrderElements(asList(
        ), pathSumII.pathSum(TreeNode.createFromArray(1, 2), 0));
    }

    @Test
    void testSumExistsButNotRootToFullNode() {
        compareListsWithInOrderElements(asList(
        ), pathSumII.pathSum(TreeNode.createFromArray(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 13));
    }

    @Test
    void testSumExistsButNotRootToPartialNode() {
        compareListsWithInOrderElements(asList(
        ), pathSumII.pathSum(TreeNode.createFromArray(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 9));
    }

    @Test
    void testTwoSolutionsOnTheSameBranch() {
        compareListsWithInOrderElements(asList(
                asList(5, 4, 11, 6),
                asList(5, 8, 13),
                asList(5, 8, 4, 9)
        ), pathSumII.pathSum(TreeNode.createFromArray(5, 4, 8, 11, null, 13, 4, 6, 2, null, null, 5, 9), 26));
    }


    @Test
    void testNegativeNumbers() {
        compareListsWithInOrderElements(asList(
                asList(-2, -3)
        ), pathSumII.pathSum(TreeNode.createFromArray(-2, null, -3), -5));
    }

    @Test
    void testBothPositiveAndNegativeNumbers() {

        compareListsWithInOrderElements(asList(
                asList(5, 4, -4, 2)
        ), pathSumII.pathSum(TreeNode.createFromArray(5, 4, 8, -4, null, 13, 4, 6, 2, null, null, 5, 9), 7));
    }

    @Test
    void testWringAnswer() {
        compareListsWithInOrderElements(asList(
                asList(1, -2, 3)
        ), pathSumII.pathSum(TreeNode.createFromArray(1, -2, -3, 1, 3, -2, null, -1), 2));
    }
}
