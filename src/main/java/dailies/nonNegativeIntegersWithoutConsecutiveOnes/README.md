### [Non-negative Integers without Consecutive Ones](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3826/)

Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not
contain consecutive ones.

Example 1:

```
Input: n = 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.

```

Example 2:

```
Input: n = 1
Output: 2
```

Example 3:

```
Input: n = 2
Output: 3
```

Constraints:

1 <= n <= 109

### Thought process

#### Approach number 1 (Accepted answer):

My first thought was that there must be some sort of mathematical formula that would reduce the amount of numbers that
need to be checked. My first impulse was to find how many numbers less than n have 1s next to eachother.   
Then I noticed that it was pretty easy to calculate that for inputs with the (2^x)-1 form because there are only 3
cases:

* numbers that start with 0 => recursion without the first element
* numbers that start with 10 => recursion without the first two elements
* numbers that start with 11 => all the numbers that start with 11 which is simply 2^[length of the remaining digits]

I first constructed that function, and it worked as expected. Now I needed a way of calculating the number of integers
which have 1s next to each other for something that is between (2^x)-1 and n

I realized that I have 2 cases:

* numbers that start with 10 => we can strip the 1 and all the leading 0s and ask the original question for this new
  number
* numbers that start with 11 => we can calculate the amount of numbers that start with 11 + now we have another 2^(x-2)
  -1 question which we already know how to solve

Both these steps (calculating for 0 to 2^x-1 and 2^x to n) seem pretty similar, and I'm sure they can be merged for a
more efficient solution, but for the moment, I will call them good enough.

A couple of quick time improvements:

* changed Math.pow to bit shifting => it reduced the time from ~2500 ms to ~500 ms
* introduced a map to store recursion results it reduced the time from ~500 ms to ~9ms, but at some memory cost
