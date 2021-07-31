### [Map Sum Pairs](https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3832/)

Create a map in which you can insert a string key and a value. If the same key is inserted twice, the previous value is
overwritten. When requesting the sum of the map with a prefix, return the sum of all the keys that start with the
prefix.

### Thought process

#### Approach number 1 (Accepted solution):

My first idea was to insert the value to each prefix of the inserted key, but then I realized that this would not
satisfy the overwriting an existing key requirement. This made me change the idea and instead of storing the value for
each prefix of the inserted key (in a set), I saved the actual key and in another map i was saving the value.

For the sum, since there already is a map which keeps all the keys for a prefix, by getting the set of keys for the
given prefix, and using those keys we get the values from the values map and add them together.

#### Approach number 2 (Accepted solution):

Instead of keeping a separate prefix to keys map, we can have a partial key which stores a character based map to the
next levels of the key. The key for this map is the first letter of the given key and for the next level, the new key
used will be one element shorter (the first letter).

To calculate the sum we first need to go to the depth of the prefix and then sum all the possible paths from there. 
