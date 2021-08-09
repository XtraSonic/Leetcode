### [AddStrings](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3875/)

Given two strings representing non-negative integers, add them without converting to int or using any built in library
that solves this problem.

### Thought process

#### Approach number 1 (accepted solution):

The first approach was using a recursion on a function which added the last digits of the string together with a carry.
Because the recursion was building a new shorter string for both inputs on each level of the recursion, this solution
was slower than it could have been.

#### Approach number 2 (accepted solution):

The second approach unwinds the first approach. The idea is: we start with an index at the end of both strings, add
together the last digit of each string and then add the previous carry value, get the new carry value and correct the
last digit if it is over 9, decrement both indexes.

