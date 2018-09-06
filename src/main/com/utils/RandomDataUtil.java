package com.utils;

import java.util.Random;

public class RandomDataUtil {

    public static int[] generateRandomIntArr(int n, int small, int large) throws Exception {
        if (small > large) {
            throw new Exception("small need littler than large");
        }

        if (n <= 0) {
            throw new Exception("n need larger than 0");
        }

        Random r = new Random();

        int[] arr = new int[n];
        int len = large - small + 1;
        for (int i = 0; i < n; i++) {
            int temp = r.nextInt();
            if (temp < 0) {
                temp = temp - Integer.MIN_VALUE;
            }
            System.out.println(temp);
            arr[i] = (temp % len) + small;
        }

        return arr;
    }

    public static void main(String[] args) {
        try {
            int[] result = RandomDataUtil.generateRandomIntArr(10, 1, 100);

            System.out.print("result = [");
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.print("]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
