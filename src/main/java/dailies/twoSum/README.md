### [TwoSum](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3836/)

Given an array of numbers and a target, return the indexes of the two numbers which add up to the target

### Thought process

#### Approach number 1:

This was the first leetcode problem that I solved. My very first attempt was using a for in for where the second for
started from the previous one +1. This worked, but it was slow. I noticed that when considering a new number, since I
know what target i'm trying to reach, I can store the expected result together with the index of this number and if i
ever see the expected result, a solution can be formed with the stored index and the current index.
