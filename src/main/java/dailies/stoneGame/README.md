### [Stone Game](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3870/)

Alex and Lee play the stone game. The stone game is a game where an odd number of stones are placed in piles. The
players take turns, and they can take either the first or the last pile. The goal is to have the largest amount of
stones at the end.

Alex and Lee both play optimally. Alex always goes first and there are an even amount of piles.

### Thought process

#### Approach number 1 (accepted solution):

So... This was an odd one...

Before starting to think how to solve the problem, I wanted to have an example of Lee winning. It is obvious that if
there are only 2 piles, Alex will take the bigger pile and win. I could not come up with any combination of 4 piles in
which Lee wins. I proved that there is no way for Lee to win when there are 4 piles. I thought about trying to go for a
larger amount of piles, but at this point I spent quite some time trying to prove that Lee can win. I did it because I
would not consider this be a medium problem if it just had a trivial answer, but I decided that enough is enough. I just
wanted to have an example where Lee wins, so I submitted "return true" expecting to get an input for which the result is
wrong. To my surprise, the solution was accepted... I was both happy and annoyed... Reading more about it I found out
that the challenge is when the number of piles is not even because when it is, Alex can always pick ether odd or even
indexes (depending on which hs the higher sum) and win.

Maybe in the future I will come back to this problem and solve it for when the number of piles does not need to be even.
