### Hw08

### Problem Statement
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

### Steps

Noteable details, we are building strings so order does not matter within a stirng.
- build a hashmap with the key:value corresponding to character:count
- iterate through hashmap adding values greater than 1 to longest
    - EVEN values can be added entirely to longestLength
    - ODD values can be added to longestLength but only after subtracting 1 to make it even and note the remainder
- then we ensure that we still count the remainder for keys with value 1
- return longestLength and remainder

##### Create Hashmap with the Count
```python
hash = {x:0 for x in s}

for x in s:
    hash[x] += 1
```

##### Adding values to longestLength variable
```python
for x in hash:
    if hash[x] > 1:
        if hash[x] % 2 == 0:
            longestLength += hash[x] 
        else:
            remainder = 1
            longestLength += hash[x] - 1
    else:
        remainder = 1
```

##### return maximum length we can build from the string
```python
    return longestLength + remainder
```