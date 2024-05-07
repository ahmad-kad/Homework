package lab08;

import java.util.*;

public class lab08 {
    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));  // Output: 3
        System.out.println(coinChange(new int[]{2}, 3));         // Output: -1
        System.out.println(coinChange(new int[]{1}, 0));         // Output: 0
    }
}
