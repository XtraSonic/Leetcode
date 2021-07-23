### [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```

Example 2:

```
Input: l1 = [0], l2 = [0]
Output: [0]
```

Example 3:

```
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

### Thought process

#### Approach number 1 (accepted solution):

This seems like a pretty straight forward problem. When adding 2 numbers together, you will have the result digit and a
carry digit so when adding the next digits, we have to add the carry as well. The only tricky part is handling numbers
which do not have the same number of digits. This can be solved by simply adding the carry (if it is not 0) to the rest
of the list.

