### [PathSumII](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3838/)

Given a binary tree, find all the root to leaf paths that add up to a target

### Thought process

#### Approach number 1 (accepted solution):

Since the sum must be made from the root to the leaf, an easy way of calculating these sums is by doing a Depth First
Search (DFS) on the tree. There were 2 tricky bits with this problem. First, the tree can contain negative numbers, and
the target can be negative this means that we cannot stop early in the DFS, and we need to go all the way to the leaf.
The second issue was that I was using a list to keep the current path and when removing an element from that list, it
removed the first occurrence of that element. What I really needed was a stack or a linked list from which i remove the
last element.

Because we are visiting every node of the tree, the time complexity is O(n).
