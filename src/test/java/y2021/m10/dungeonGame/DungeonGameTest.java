package y2021.m10.dungeonGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class DungeonGameTest {
    DungeonGame dungeonGame;

    @Test
    void testExample1() {
        assertEquals(7, dungeonGame.calculateMinimumHP(new int[][]{
                new int[]{-2, -3, 3},
                new int[]{-5, -10, 1},
                new int[]{10, 30, -5},
        }));
    }

    @Test
    void testExample2() {
        assertEquals(1, dungeonGame.calculateMinimumHP(new int[][]{
                new int[]{0},
        }));

    }

    @Test
    void testAntiGreedy() {
        assertEquals(101, dungeonGame.calculateMinimumHP(new int[][]{
                new int[]{0, -1, -1},
                new int[]{-100, -100, -1000},
                new int[]{0, 0, 0},
        }));
    }

    @Test
    void testBestPathIsNotTheMaxEndHpPath() {
        assertEquals(101, dungeonGame.calculateMinimumHP(new int[][]{
                new int[]{0, 0, -1000},
                new int[]{-100, -1000, 10000},
                new int[]{0, 0, 0},
        }));
    }


    @Test
    void test() {
        assertEquals(1001, dungeonGame.calculateMinimumHP(new int[][]{
                new int[]{0, -1000, 2000, -1000000},
                new int[]{1, 0, 0, -1500},
                new int[]{-100000, -10000, -1501, 0},
        }));
    }

}
