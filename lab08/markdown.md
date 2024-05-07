## Lab08

### Problem Statement
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

#### Clean input

Check if input is clean meaning amount is a non-negative number

```python
    if amount < 0:
        return -1
```

#### Add Memoization Table with base case of 0
```python
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0

```

### Iterate an add optimal amount of coins
```python
    for coin in coins:
        for i in range(coin, amount + 1):
            dp[i] = min(dp[i], dp[i - coin] + 1)

```

### Return optimal amount or -1 if infinity
```python
    return dp[amount] if dp[amount] != float('inf') else -1
```