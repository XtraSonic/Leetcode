### [Beautiful Array](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3829/)

Given `n`, return an array which has no element that is the double of an element from the left of it + an element from
the right of it

### Thought process

#### Approach number 1:

My first thought was that there must be a pattern that lets me create the array in one go and involves something with
multiplying or dividing by 2 or the binary representation of numbers, but I could not see anything, so I decided to make
a backtracking solution and see how the results look like. As expected, the algorithm is slow for larger values, but
once I saw the results (up to n=64), some patterns started to emerge:

* all the solutions started with a 1
* all the results ended with a power of 2 and not just any power, the highest power less(or equal) than the number `n`
* there was a clear divide between even and odd numbers
* the number 2 was always in the middle
* the first odd number after 1 was a power of 2 + 1
* there seemed to be some sort of pattern if you looked at the binary values. For example, the result for n=33 starts
  with 1,33,17,9,5 which, in binary, looks like: 1, 10 0001, 1 0001, 1001, 101

#### Approach number 2 (incomplete):

Since the number 2 always was in the middle, I thought i can divide and conquer the "left" side and the "right" side of
a number, and i would start with 2. Unfortunately I could not find a connection that is applicable on both sides. My
biggest issue was that on the number of evens and odds on both sides of 2 was about equal and that was not what I
observed with my previous approach . I tried a few ways of assigning values, but it was mostly me throwing stuff at the
problem and seeing what sticks so I decided to give up on this approach (at least for now)

#### Approach number 3 (accepted solution):

Looking for some inspiration for the approach number 2, I happened to see "reverse binary" and then it clicked. The
binary pattern I've been trying to figure out was the "0" front-padded reverse of a number. If we sort this
representations of the numbers, we get a valid solution.

I did not prove to myself yet why this solution works, but i've already spent too much time on this not so fun (and
despite it's name, ugly) math problem...

