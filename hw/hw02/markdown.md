# Steps

The problem statement is that we have to search through an array of versions that **may** contain a bad version.
We can solve the problem iterating through the entire array in a for loop however that takes longer.
Instead we can use binary search using the provided function isBadVersion(version) to move the left and right pointers
if the middle element between left and right is a bad version, move the right pointer to that middle index and repeat until left and right pointers are at the same index.
if the middle element is not, then increment the left point to middle element + 1 as the bad version must be between in that half, if a bad version is present.
if no bad version is present, then we exit stating there is no bad version.


left, right = 0, len(array) -1
    while left < right
        middle = left + right - left / 2
        if isBadVersion(array[middle]) == true
            right = middle
        else
            left = middle + 1

    return array[left] if isBadVersion(array[left]) else -1
