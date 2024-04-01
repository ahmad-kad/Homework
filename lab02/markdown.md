# Steps

First establish what anagrams will include

- two strings must have the same length and same count for each character
- each character Uppercase and Lowercase will be treated separately since its not defined

    def isAnagram(s, t):
        if len(s) != len(t):
            return False
        else:
            hashmap = {}
            hashmapS = hashmap.get(s, 0) + 1
            hashmapT = hashmapget(t, 0) + 1
            return hashmapS == hashmapT  

## Implementation

create the obvious case where length of string 's' != string 't' so that it exits

create two hashmaps, one for string 's' and string 't'.

compare two hashmaps to return True or False based on condition