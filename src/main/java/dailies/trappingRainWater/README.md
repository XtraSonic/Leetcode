### [TrappingRainWater](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3833/)

Calculate the amount of squares of rainwater that could accumulate between the elevations given in an array

### Thought process

#### Approach number 1 (time limit exceeded):

Since we get a 1d representation of a 2d world, my first thought was to try to solve this in 2d first. To do this I "
traversed" the array and "erode" it with each pass. To get the final result, I added the elements with 0 height between
2 non-zero height elements.

As expected, this approach was too slow, but it gave me an idea on how to proceed.

#### Approach number 2 (accepted solution):

I noticed that if I split the 2d world by rows, each row will have one starting element, one ending element and between
them either water or other elements. By going top to bottom, we know exactly how many elements we will have on each row:
the number of elements on the previous row + the number of elements that have the height equal to the row number. This
means that we can also calculate the amount of water on each row.

Knowing all this, we first need to construct a map which will have as keys the heights of the elements and as values we
save the indexes of the elements in the order we encounter them. In reality, we only need the indexes of the first and
last elements with that height, and the number of elements with that height.

This algorithm has a O(n+m) complexity where n is the length of the input array and m is the max height of an element.

#### Approach number 3 (accepted solution):

I have seen that my previous approach was slower than the others, so I scanned through what others did, and I realized
that instead of rows, I could turn the problem by its side and tackle the columns.

By starting with 2 indexes on both sides of the array and moving the lower one towards the center, we are guaranteed to
always have one of the indexes at the highest point reached so far. This also means that when an index moves the element
on the new index will:

* be higher that the previous maximum seen on its side of the array => it is the new maximum for that side
* be lower than the previous maximum seen on its side of the array => it is also lower than the peak on the other side (
  which is larger than the peak on this side)=>
  it can accumulate water equal to the peak on this side - the height of the current element

This algorithm has a complexity of O(n) and because it does not use any other secondary map, it has a space complexity
of O(1)

