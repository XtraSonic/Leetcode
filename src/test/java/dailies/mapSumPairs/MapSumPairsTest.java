package dailies.mapSumPairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MapSumPairsTest {
    MapSumPairs mapSumPairs;
    String nonexistentPrefix = "nonexistentPrefix";

    @Test
    void testNonexistentPrefix() {
        assertEquals(0, mapSumPairs.sum(nonexistentPrefix));
    }

    @Nested
    @DisplayName("Given apple was inserted")
    class AppleWasInserted {

        String apple = "apple";
        String shorterPrefix = "ap";

        @BeforeEach
        void setup() {
            mapSumPairs.insert(apple, 3);
        }

        @Test
        void testNonexistentPrefix() {
            assertEquals(0, mapSumPairs.sum(nonexistentPrefix));
        }

        @Test
        void testShorterPrefix() {
            assertEquals(3, mapSumPairs.sum(shorterPrefix));
        }

        @Test
        void testFullPrefix() {
            assertEquals(3, mapSumPairs.sum(apple));
        }

        @Nested
        @DisplayName("Given appo was inserted")
        class AppoWasInserted {

            String appo = "appo";

            @BeforeEach
            void setup() {
                mapSumPairs.insert(appo, 5);
            }

            @Test
            void testNonexistentPrefix() {
                assertEquals(0, mapSumPairs.sum(nonexistentPrefix));
            }

            @Test
            void testShorterPrefix() {
                assertEquals(8, mapSumPairs.sum(shorterPrefix));
            }

            @Test
            void testFullPrefix() {
                assertEquals(3, mapSumPairs.sum(apple));
                assertEquals(5, mapSumPairs.sum(appo));
            }

            @Nested
            @DisplayName("Given apple is overwritten")
            class AppleIsOverwritten {
                @BeforeEach
                void setup() {
                    mapSumPairs.insert(apple, 1);
                }

                @Test
                void testNonexistentPrefix() {
                    assertEquals(0, mapSumPairs.sum(nonexistentPrefix));
                }

                @Test
                void testShorterPrefix() {
                    assertEquals(6, mapSumPairs.sum(shorterPrefix));
                }

                @Test
                void testFullPrefix() {
                    assertEquals(1, mapSumPairs.sum(apple));
                    assertEquals(5, mapSumPairs.sum(appo));
                }
            }
        }


    }
}
