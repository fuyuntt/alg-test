package com.fuyun.alg;

import java.util.Arrays;

/**
 * Created by bl05959 on 2016/9/18.
 * 最长单调递增子序列
 */
public class MaxLengthInc {
    public static void main(String[] args) {
        int[] test1 = new int[] { 1, 4, 5, 8, 9, 2, 3, 4, 6, 1, 2, 3, 4, 5, 9 };
        System.out.println(Arrays.toString(maxLengthInc(test1)));
    }

    // 1D/1D dp算法
    private static int[] maxLengthInc(int[] input) {
        int length = input.length;
        int[] dp = new int[length];
        int[] path = new int[length];
        int max = 1;
        int maxIdx = 0;
        dp[0] = 1;
        path[0] = -1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    path[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIdx = i;
            }
        }
        int[] result = new int[max];
        for (int i = max - 1; i >= 0; i--) {
            result[i] = input[maxIdx];
            maxIdx = path[maxIdx];
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(path));
        return result;
    }
}
