### [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

Example 2:

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

Example 3:

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

Example 4:

```
Input: s = ""
Output: 0
```

Constraints:

* 0 <= s.length <= 5 * 104
* s consists of English letters, digits, symbols and spaces.

### Thought process

#### Approach number 1 (accepted solution):

I realized right away that simply counting again from 0 when encountering a duplicate letter is not going to work. That
is because we will "lose"
the unique characters that are in between the 2 identical letters. To solve this, i decided to traverse the string with
2 indexes:

* start of the substring
* current location

This way, we can save the last seen index of each character and if the current character has a last seen index that is
grater than the start of the string, it means that that character is a duplicate in our substring. When encountering a
duplicate, we first need to check the length of the substring, and then we need to start a new substring measurement,
but instead of starting from scratch, we can start from the lastSeenIndex + 1 and this way we keep the unique characters
that are in between the 2 identical ones.
