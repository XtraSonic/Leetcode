### [Group Anagrams](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3887/)

Given a list of strings, group anagrams together.

### Thought process

#### Approach number 1 (accepted solution):

For two strings to be anagrams, they only need to have the same amount of letters so all we need to do is to calculate
the character frequency of each string, and then we can group together strings which have the same character frequency
vector.


