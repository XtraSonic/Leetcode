### [Subsets II](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3837/)

Get all the possible subsets of an array

### Thought process

#### Approach number 1:

Since it's a problem related to sets, I thought I could use the java sets. The solution might be a bit slower, but I
wanted to see the difference. Since each individual subset is not necessarily a set (e.g. for [1,2,2] has [2,2] as one
of its subsets)
the end result needs to be a set of lists. The problem is that both the [1,2] and the [2,1] would be included in the
result set, so the lists need to be ordered. To achieve this we can order the array at the beginning (since sorting is
faster than the complexity of the algorithm). Now all we need to do is start with the empty set and foreach number, we
add it to all the lists already in the result and insert the new lists in the result.

I was expecting this solution to be a lot slower than the optimal solution because if we have equal numbers, it tries to
insert many lists that we already know are in the result set. Surprisingly, the solution was not that far from the
optimal solution. Because of that, for the moment, I will not try to improve my approach. 
