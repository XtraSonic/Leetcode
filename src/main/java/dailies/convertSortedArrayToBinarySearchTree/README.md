### [Convert Sorted Array to Binary Search Tree](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3827/)

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary
search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by
more than one.

Example 1:

```
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
```

Example 2:

```
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
```

Constraints:

* 1 <= nums.length <= 104
* -104 <= nums[i] <= 104
* nums is sorted in a strictly increasing order.

### Thought process

#### Approach number 1 (accepted solution):

Since the input array is sorted, we know for certain that if we take any element, everything to the left of it will be
less than it and everything to the right of it will be grater than it. This helps us a lot when constructing the Binary
Search Tree (BST)
because we can take any element as root and recursively make a BST with the elements from the left(right) for the root
to make the left(right) branch.

The height balancing can be done by simply selecting the correct element as root when creating the BST. If we pick the
element in the middle of the list as the root, we have 2 cases:

* the number of elements to the left and right is the same => the resulting subtrees will have the same structure
* one side has 1 more element => the depth of the2 subtrees can not vary more than one so the BST will be balanced 

