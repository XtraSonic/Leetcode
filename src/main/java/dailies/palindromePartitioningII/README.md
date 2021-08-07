### [PalindromePartitioningII](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3872/)

Given a string s, return the minimum number of cuts needed to divide the string into palindromes

### Thought process

#### Approach number 1 (accepted solution):

This really was a hard problem. I realized right away that it will use dynamic programming, but I was not sure how After
some thinking, and some inspiration, I realized how I could build something that finds the palindromes in a string, but
calculating the number of minimum cuts was too difficult for me to solve in a limited amount of time so I searched for
some answers. I found [this](https://youtu.be/ot5Q9dD5rWM) video and at around 4 I got my answer. Even tho my solution
is a little different, the idea is that I can assume the problem was solved for the shorter strings. When adding a new
character to the string and if it forms a palindrome, I need to update the min cuts for this new string with the minimum
between the current value of the min cuts for this string and 1+ the min cuts for the string which is between 0 and the
start of the palindrome.

