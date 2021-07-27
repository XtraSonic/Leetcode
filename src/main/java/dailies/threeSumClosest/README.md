### [3Sum Closest](https://leetcode.com/submissions/detail/529112855/?from=explore&item_id=3828)

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to
target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:

```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

Constraints:

* 3 <= nums.length <= 10^3
* -10^3 <= nums[i] <= 10^3
* -10^4 <= target <= 10^4

### Thought process

#### Approach number 1 (Accepted Solution):

I wanted to check if the triple for solution was good enough and apparently it (no timeout). Each for started from the
index of the previous for +1. I also had a variable that kept the minimum difference between the target, and the current
best result.

#### Approach number 2 (Accepted Solution):

The first approach was a naive one. This one uses something I learned after solving the
normal [3Sum](https://github.com/XtraSonic/Leetcode/tree/master/src/main/java/threeSum#3sum) problem. In some of the
3Sum solutions, I saw that people were sorting the array first. This made me realize that in a sorted array, by having
an index for the smaller number, and an index for the larger number, you can with only 1 iteration of the list calculate
all the sums that are guaranteed to be the closest to a target.

If the **array is sorted**, and:

* `nums[indexLow] + nums[indexHigh] < target`: there is no reason to ever try adding `nums[indexHigh]` to any other
  number `num[i]` where `i` is in between `indexLow` and `indexHigh`
  because all `num[i]`s are less than `nums[indexHigh]`. If we did, all the results would be even lower than the current
  sum, so the target is even further away => we simply decrement `indexHigh`
* `nums[indexLow] + nums[indexHigh] > target`: there is no reason to ever try adding `nums[indexLow]` to any other
  number `num[i]` where `i` is in between `indexLow` and `indexHigh`
  because all `num[i]`s are greater than `nums[indexLow]`. If we did, all the results would be even greater than the
  current sum, so the target is even further away => we simply increment `indexLow`

As for the third number, we just iterate through the whole array and pick the third number as the number on the current
location, and we use the algorithm above to get the other 2 numbers. For each 3 numbers we calculate the difference to
the target and if it's less than the current minimum, we save the sum.

We can afford to sort the array first because the sort complexity is O(n log(n)) [or O(n^2) for quicksort] which is less
than the O(n^3) of the previous solution and since having a sorted array helps us solve the problem in O(n^2), sorting
leads to a better solution first. 
