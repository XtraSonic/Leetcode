### [MakingALargeIsland](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/)

Given a square matrix with 1s representing land and 0s representing water, return the size of the largest island which
would be created by changing at most one 0 to a 1.

### Thought process

#### Approach number 1 (Accepted solution):

My first thought was to first identify all the islands and then try to connect them. Identifying the islands was easy:
When finding a 1 in the grid, we can just expand in the 4 directions to find all the ones.

The real problem was evaluating the sizes of the islands after changing a 0 to a 1. My first idea was to store the
border of the islands as well and for each 0 check which islands had that 0 and get the number of 1s of those islands.
This solution resulted in the time limit exceeded, but I was sure i was onto something. I realised that i could "label"
each island with a number. This would make it a lot easier to know what islands are the neighbours of a 0. Also since I
just need the sizes of the islands, I could store them in a map with the label of the island as a key. This solution was
accepted, but it was kind of slow when compared with other solutions. I was not sure if my algorithm was unnecessarily
slow or if it was just the overhead of creating new classes and how I was handling the MatrixIndex.

#### Approach number 2 (Accepted solution):

In order to see if my algorithm was the problem, I checked what other people did, but accidentally looked at the best
memory solution instead of the time solution. This was a happy accident because I noticed that I could potentially make
that solution better. The of that solution was to change each 0 to a 1 and check the size of the island starting from
that 0. To find the size of the island they used a different approach to what I did. I used a BFS and they used 2 DFSs:
one which set the label to 2 and another which set the label back to 1. I realised that I might get away with only using
1 DFS if saving the original gris is not necessary (which I assumed was not). The idea was to use labels. This way we
can treat as an unexplored cell as something that does not have the current label.

This solution was twice as fast as the solution i have seen, and it used the same or less amount of memory, but it was
slower than my original solution

#### Approach number 3 (Accepted solution):

After looking at the fastest solution, I was glad to see they did more or less the same thing as me. The only
differences were: they used DFS instead of BFS and a lot of what i was doing in short for loops they unwound the logic
to multiple ifs. I decided to try test if unwinding my logic would yield the same results. Sure enough it did. The DFS
is slightly faster because there is no Queue involved (with the add and poll calls), and the neighbours check
(both in dfs and when looking at the neighbours of a 0) is faster by just checking i and j instead of using the custom
MatrixIndex class which seems to introduce a significant overhead (even if it is much easier to use).
