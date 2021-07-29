### [01 Matrix](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3831/)

Given a matrix with 0s and 1s, return a matrix where each cell represents the manhattan distance to the nearest 0 in the
original matrix

### Thought process

#### Approach number 1:

In order to get the shortest distance between a 0 and a cell, we can start in the cell with 0 and do a breath first
search for the other cell. This also has the benefit of "solving" all the other cells along the path.

The only issue with this is how do you solve a "conflict". If you start from one end and in the opposite end you find
another 0, that zero should influence the cells as well so changes will propagate a long way back again reducing the
efficiency.

We can solve the issue by having multiple starting points. By first finding all the 0s and making all of them starting
points, since they all search at the same time, their searches will "collide" at the exact point where their influence
over a cell stops so no overlap will occur. This means that the algorithm is O(n^2) 
