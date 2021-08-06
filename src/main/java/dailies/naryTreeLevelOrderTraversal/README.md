### [N-ary Tree Level Order Traversal](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3871/)

Given an N-ary Tree, return the values of the tree grouped by the level they are in.

### Thought process

#### Approach number 1 (accepted solution):

By starting with a BFS, we will first finish one level before going to the next. This means that when we finish a level,
the queue will contain all the elements of the next level and only those elements. This also means that by counting how
many elements of the current level we have processed, we will know exactly when the current level will end.
