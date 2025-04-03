package ps6;

import java.util.*;

public class PairFinder {
    public static void findPairSums(int k, int[] arr) {
        if (arr == null) throw new IllegalArgumentException("");
        // 2sum brute force
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + k);
                }
            }
        }

    }   

    public static void findPairSumsFaster(int k, int[] arr) {
        if (arr == null) throw new IllegalArgumentException("");
        Sort.mergeSort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] > k) {
                r--;
            } else if (arr[l] + arr[r] < k) {
                l++;
            } else {
                System.out.println(arr[l] + " + " + arr[r] + " = " + k);

                // Skip duplicates from the left
                int leftVal = arr[l];
                while (l < r && arr[l] == leftVal)
                    l++;
                // Skip duplicates from the right
                int rightVal = arr[r];
                while (l < r && arr[r] == rightVal)
                    r--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 4, 7, 7, 8, 8, 5, 15 };
        int[] arr2 = { 1, 2, 2, 3, 3, 4 };
        System.out.println("slower");
        findPairSums(5, arr2);
        System.out.println("faster");
        findPairSumsFaster(5, arr2);
    }
}
