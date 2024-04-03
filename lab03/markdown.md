## Problem 1:

Let's compare some basic math functions to refresh our memory. For each of the following, just write which function is asymptotically greater (So, you should be thinking about your asymptotic notations!). Show your reasoning for the same.

    10000000000n^2 vs n^3
    n^2 log(n) vs n(log(n))^10
    n^logn vs 2^sqrt(n)
    2^n vs 2^2n

1. 
    10000000000n^2 = n^3
    n = 10000000000
    10000000000 is the intersection of both functions. For any value n > 10000000000, n^3 will always be greater than 10000000000n^2
     **therefore n^3 is asymtotically greater than n^2**

2. 
    n^2 log(n) = n(log(n))^10
    nlog(n) = log(n)^10
    n = log(n)^9

    **n grows faster than than log(n) therefore n^2 is asymptotically greater than n(log(n))^10**

3.  n^logn vs 2^sqrt(n)
    2^sqrt(n) grows exponentially while n^log(n) grows logarithmically. Exponential growth is greater that logarithmic growth.
    Therefore 2^sqrt(n) is asymptotically greater than n^long(n)

4.  2^n vs 2^2n
    Asymtotically, 2^2n is greater than 2^n because 2^n will always be 1 degree higher than 2^n.


### Problem 2:

Now let's examine some [pseudo]code and apply asymptotic notation to it. 

    isPrime(n): 
        for(i = 2, i*i <= n; i++) {
            if(n % i == 0) {
            return false
            }
        return true

What is the 

    Best Case
    Worst Case
    Average Case

Time complexity for the above function?

    Best Case: Omega(1)
        - if n = 2, it returns and doesn't iterate
    Worst Case: O(sqrt(n))
        - if n is large prime number
        - i*i makes each iteration grow exponentially by 'i'.
        - since 'i' grows exponentially, the for loop iterator runs at sqrt(n) time.
    Average Case:  Theta(sqrt(n))
        - the average of best and worst case still simplifies to sqrt(n)