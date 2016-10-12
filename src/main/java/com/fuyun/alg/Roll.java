package com.fuyun.alg;

/**
 * Created by bl05959 on 2016/9/12.
 * 从楼上扔一个球，判定球碎的临界楼层
 */
public class Roll {
    public static void main(String[] args) {
        System.out.println(dropTimes(100));
    }

    private static int dropTimes(int layer) {
        int[] layer2times = new int[layer + 1];
        for (int i = 2; i <= layer; i++) {
            int minTimes = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                int times = Math.max(j, 1 + layer2times[i - j]);
                if (times < minTimes) {
                    minTimes = times;
                }
            }
            layer2times[i] = minTimes;
        }
        return layer2times[layer];
    }
}
