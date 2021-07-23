### [Binary Tree Pruning](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3824/)

Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has
been removed.

A subtree of a node `node` is `node` plus every node that is a descendant of `node`.

Example 1:

```
Input: root = [1,null,0,0,1]
Output: [1,null,0,null,1]
Explanation:
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.
```

Example 2:

```
Input: root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]
```

Example 3:

```
Input: root = [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]
```

Constraints:

* The number of nodes in the tree is in the range [1, 200].
* Node.val is either 0 or 1.

### Thought process

#### Approach number 1 (accepted solution):

It took me longer to make my setup than to solve this problem. The idea is simple, for a node to be kept, it needs to
either have:

* the value 1
* have a child with value 1

To check if any of the children have the value 1, we simply prune them as well and if the result is not null, it means
that the parent must pe kept as well. 
