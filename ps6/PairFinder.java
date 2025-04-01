package ps6;

import java.util.*;

public class PairFinder {
    public static void findPairSums(int k, int[] arr) {
        // 2sum brute force
        for (int i = 0; i < arr.length; i++) {
            // skip dulp for i
            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = i; j < arr.length; j++) {
                // skip dulp for j
                if (j != 0 && arr[j] == arr[j - 1]) {
                    continue;
                }
                if (arr[i] + arr[j] == k) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + k);
                }
            }

        }
    }

    public static void findPairSumsFaster(int k, int[] arr) {
        Sort.mergeSort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] > k) {
                r--;
            } else if (arr[l] + arr[r] < k) {
                l++;
            } else {
                // skip dulp
                // if not (in bound and the prev element is the same with the curr element)
                if (!((l != 0 && r != arr.length - 1) && (arr[l] == arr[l - 1] && arr[r] == arr[r + 1])))
                    System.out.println(arr[l] + " + " + arr[r] + " = " + k);
                l++;
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
