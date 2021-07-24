package dailies.binaryTreePruning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeNodeTest {

    TreeNode root = new TreeNode(1);

    @Test
    void testToList() {
        compareTreeNodeToIntegerArray(root, 1);
    }

    @Nested
    @DisplayName("Given left of root is not null")
    class LeftOfRootIsNotNull {
        TreeNode left1 = new TreeNode(2);

        @BeforeEach
        void setup() {
            root.setLeft(left1);
        }

        @Test
        void testToList() {
            compareTreeNodeToIntegerArray(root, 1, 2);
        }

        @Nested
        @DisplayName("Given left of left is not null")
        class LeftOfLeftIsNotNull {
            TreeNode left2 = new TreeNode(4);

            @BeforeEach
            void setup() {
                left1.setLeft(left2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, null, 4);
            }
        }


        @Nested
        @DisplayName("Given right of left is not null")
        class RightOfLeftIsNotNull {
            TreeNode right2 = new TreeNode(5);

            @BeforeEach
            void setup() {
                left1.setRight(right2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, null, null, 5);
            }
        }

        @Nested
        @DisplayName("Given both children of left are not null")
        class BothChildrenOfLeftAreNotNull {
            TreeNode left2 = new TreeNode(4);
            TreeNode right2 = new TreeNode(5);

            @BeforeEach
            void setup() {
                left1.setLeft(left2);
                left1.setRight(right2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, null, 4, 5);
            }
        }

    }

    @Nested
    @DisplayName("Given right of root is not null")
    class RightOfRootIsNotNull {
        TreeNode right1 = new TreeNode(3);

        @BeforeEach
        void setup() {
            root.setRight(right1);
        }

        @Test
        void testToList() {
            compareTreeNodeToIntegerArray(root, 1, null, 3);
        }


        @Nested
        @DisplayName("Given left of right is not null")
        class LeftOfRightIsNotNull {
            TreeNode left2 = new TreeNode(6);

            @BeforeEach
            void setup() {
                right1.setLeft(left2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, null, 3, 6);
            }
        }


        @Nested
        @DisplayName("Given right of right is not null")
        class RightOfRightIsNotNull {
            TreeNode right2 = new TreeNode(7);

            @BeforeEach
            void setup() {
                right1.setRight(right2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, null, 3, null, 7);
            }
        }

        @Nested
        @DisplayName("Given both children of right are not null")
        class BothChildrenOfRightAreNotNull {
            TreeNode left2 = new TreeNode(6);
            TreeNode right2 = new TreeNode(7);

            @BeforeEach
            void setup() {
                right1.setLeft(left2);
                right1.setRight(right2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, null, 3, 6, 7);
            }
        }

    }

    @Nested
    @DisplayName("Given both children of root are not null")
    class BothChildrenOfRootAreNotNull {
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        @BeforeEach
        void setup() {
            root.setLeft(left1);
            root.setRight(right1);
        }

        @Test
        void testToList() {
            compareTreeNodeToIntegerArray(root, 1, 2, 3);
        }

        @Nested
        @DisplayName("Given left of left is not null")
        class LeftOfLeftIsNotNull {
            TreeNode left2 = new TreeNode(4);

            @BeforeEach
            void setup() {
                left1.setLeft(left2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, 3, 4);
            }

            @Nested
            @DisplayName("Given left of right is not null")
            class LeftOfRightIsNotNull {
                TreeNode left22 = new TreeNode(6);

                @BeforeEach
                void setup() {
                    right1.setLeft(left22);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, 4, null, 6);
                }
            }


            @Nested
            @DisplayName("Given right of right is not null")
            class RightOfRightIsNotNull {
                TreeNode right22 = new TreeNode(7);

                @BeforeEach
                void setup() {
                    right1.setRight(right22);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, 4, null, null, 7);
                }
            }
        }


        @Nested
        @DisplayName("Given right of left is not null")
        class RightOfLeftIsNotNull {
            TreeNode right2 = new TreeNode(5);

            @BeforeEach
            void setup() {
                left1.setRight(right2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, 3, null, 5);
            }

            @Nested
            @DisplayName("Given left of right is not null")
            class LeftOfRightIsNotNull {
                TreeNode left2 = new TreeNode(6);

                @BeforeEach
                void setup() {
                    right1.setLeft(left2);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, null, 5, 6);
                }
            }

            @Nested
            @DisplayName("Given right of right is not null")
            class RightOfRightIsNotNull {
                TreeNode right2 = new TreeNode(7);

                @BeforeEach
                void setup() {
                    right1.setRight(right2);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, null, 5, null, 7);
                }
            }
        }

        @Nested
        @DisplayName("Given both children of left are not null")
        class BothChildrenOfLeftAreNotNull {
            TreeNode left2 = new TreeNode(4);
            TreeNode right2 = new TreeNode(5);

            @BeforeEach
            void setup() {
                left1.setLeft(left2);
                left1.setRight(right2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, 3, 4, 5);
            }

            @Nested
            @DisplayName("Given left of right is not null")
            class LeftOfRightIsNotNull {
                TreeNode left21 = new TreeNode(6);

                @BeforeEach
                void setup() {
                    right1.setLeft(left21);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, 4, 5, 6);
                }
            }

            @Nested
            @DisplayName("Given right of right is not null")
            class RightOfRightIsNotNull {
                TreeNode right21 = new TreeNode(7);

                @BeforeEach
                void setup() {
                    right1.setRight(right21);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, 4, 5, null, 7);
                }
            }

        }

        @Nested
        @DisplayName("Given left of right is not null")
        class LeftOfRightIsNotNull {
            TreeNode left2 = new TreeNode(6);

            @BeforeEach
            void setup() {
                right1.setLeft(left2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, 3, null, null, 6);
            }
        }


        @Nested
        @DisplayName("Given right of right is not null")
        class RightOfRightIsNotNull {
            TreeNode right2 = new TreeNode(7);

            @BeforeEach
            void setup() {
                right1.setRight(right2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, 3, null, null, null, 7);
            }
        }

        @Nested
        @DisplayName("Given both children of right are not null")
        class BothChildrenOfRightAreNotNull {
            TreeNode left2 = new TreeNode(6);
            TreeNode right2 = new TreeNode(7);

            @BeforeEach
            void setup() {
                right1.setLeft(left2);
                right1.setRight(right2);
            }

            @Test
            void testToList() {
                compareTreeNodeToIntegerArray(root, 1, 2, 3, null, null, 6, 7);
            }

            @Nested
            @DisplayName("Given left of left is not null")
            class LeftOfLeftIsNotNull {
                TreeNode left21 = new TreeNode(4);

                @BeforeEach
                void setup() {
                    left1.setLeft(left21);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, 4, null, 6, 7);
                }
            }

            @Nested
            @DisplayName("Given right of left is not null")
            class RightOfLeftIsNotNull {
                TreeNode right21 = new TreeNode(5);

                @BeforeEach
                void setup() {
                    left1.setRight(right21);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, null, 5, 6, 7);
                }
            }

            @Nested
            @DisplayName("Given both children of left are not null")
            class BothChildrenOfLeftAreNotNull {
                TreeNode left21 = new TreeNode(4);
                TreeNode right21 = new TreeNode(5);

                @BeforeEach
                void setup() {
                    left1.setLeft(left21);
                    left1.setRight(right21);
                }

                @Test
                void testToList() {
                    compareTreeNodeToIntegerArray(root, 1, 2, 3, 4, 5, 6, 7);
                }
            }
        }
    }

    @Test
    void testCreateFromArray() {
        evaluateCreateFromArray(new Integer[]{1});
        evaluateCreateFromArray(new Integer[]{1, 2});
        evaluateCreateFromArray(new Integer[]{1, 2, 3});
        evaluateCreateFromArray(new Integer[]{1, null, 3});
        evaluateCreateFromArray(new Integer[]{1, 2, null, 4});
        evaluateCreateFromArray(new Integer[]{1, 2, null, 4, 5});
        evaluateCreateFromArray(new Integer[]{1, null, 3, 6});
        evaluateCreateFromArray(new Integer[]{1, null, 3, null, 7});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, 4});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, null, 5});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, null, null, 6});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, null, null, null, 7});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, 4, 5});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, 4, null, 6});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, 4, null, null, 7});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, null, 5, 6});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, null, 5, null, 7});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, null, null, 6, 7});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, 4, 5, null, 7});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, 4, null, 6, 7});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, null, 5, 6, 7});
        evaluateCreateFromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    }

    private void evaluateCreateFromArray(Integer[] integers) {
        compareTreeNodeToIntegerArray(TreeNode.createFromArray(integers), integers);
    }

    public static void compareTreeNodeToIntegerArray(TreeNode root, Integer... expectedArray) {
        List<Integer> expectedList = Arrays.stream(expectedArray).collect(Collectors.toList());
        assertEquals(expectedList, root.toList());
    }
}
