## High-level approach 1:


### Steps: 
create a list to contain lists
create a list of set combinations
Iterate through the array 3 times.
- the first iterator will iterate through the entire list - 2
- the second iterator will iterate through the first iterator + 1 to list - 1
- the third iterator will iterate through the second iterator + 1 to the end of the list

This reduces the number of times we call each set of three and ensures that each set of 3 have 3 unique elements within the array

while iterating through the 3rd iterator:
- check if the sum of all three elements is ZERO, and if the set of the three elements are not in the list of set combinations
    - if not, add a list of the three elements into the list of lists

## High level approach 2:

The previous algorithm is pretty slow. Its t(n) = t(n * (n-1) * (n-2)) which is rougly eqivalent to t(n^3)

The second approach first sorts the array, iterates through the entire array - 2 elements, and utilized left and right pointers to exit faster. This approach is t(n^2)

### Steps
- first sort to array
- create a list to hold integer lists
- iterate through the array
    - check if current iterator is the same as previous iterator to skip that entry
    - instantiate left and right at the ends of the remaining array
    - while:
        - check if total of current, left, and right values are 0
        - if its less than zero, then the left value is too small
        - if its greater than zero, the right value is too big
        - else it means that total is zero and we append it to the list of lists
            - we also continue check other values within the remaining array because there may be more combinations