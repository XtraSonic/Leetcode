package dailies.stoneGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class StoneGameTest {
    StoneGame stoneGame;

    @Test
    void testExample1() {
        assertTrue(stoneGame.stoneGame(new int[]{5, 3, 4, 5}));
    }

    @Test
    void testLeeWin() {
//       there is no way for Lee to win
    }
}
