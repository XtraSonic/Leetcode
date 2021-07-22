### [3Sum](https://leetcode.com/problems/3sum/)

Given an integer array nums, return all the triplet `[nums[i], nums[j], nums[k]]`
such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplet.

### Thought process

#### Approach number 1:

My first solution was a simple for-in-for-in-for loop. Each for loop started from the previous index +1 ensuring
the `i != j`, `i != k`, and `j != k` condition, and the results were stored in a set.

As expected, this solution was slow and it timed out on the test with 3000 numbers given as input.

#### Approach number 2:

On my second attempt, I tried deconstructing the process in 3 layers:

* layer 1: single values
* layer 2: pairs of values
* layer 3: solutions

For something from layer 2 to become a solution we need a single number and we know in advance what number we are
looking for, so we store the pair in a map with the expected number as a key. Since multiple pairs can have the same
key, the value field of the map will be a set of pairs

When considering a new number there are 3 steps:

1. We first check if the map contains that number as a key. If it does, it means that all the pairs there are a
   solution.
2. We look at the set of already processed numbers and make "layer 2" pairs with the new number and add them to the map
3. Add the number to the set of processed numbers

This approach is considerably faster, but it is still too slow and it exceedes the time limit even if the 3000 elements
test runs in under 4 seconds (the previous attempt did not finish running at the 10 min mark).

I tried saving the "solved" pairs in a set in order to not create that pair in the following passes, but it did not seem
to help the execution time.

#### Approach number 3 (Accepted submission):

From attempt 2 I learned that having a pair and knowing what the 3rd number should be, is a huge boost, but saving all
the possible pairs is not ideal. I then realised that when making a pair instead of saving it and waiting for the "
expected number" to come, I can just look at what numbers already were seen in order to determine if that pair is a
solution or not.

This introduced a new problem: the a+a+b = 0 case. If the current number is b and its pair is a which is equal to the
expected number, it is not enough to simply look if the expected number was seen before because we know it has been seen
before. The problem is that for it to be a valid solution, we need to have seen it twice.

To solve this problem, instead of a hash set to keep the seen numbers, I kept the seen numbers in a frequency hash map 



