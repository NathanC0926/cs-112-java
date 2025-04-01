package ps6;

import java.util.*;

public class MergeApproach {
    public static int[] union(int[] a1, int[] a2) {
        if (a1 == null || a2 == null)
            throw new IllegalArgumentException("");
        int[] res = new int[a1.length + a2.length];
        Sort.mergeSort(a1);
        Sort.mergeSort(a2);

        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while (p1 < a1.length && p2 < a2.length) {
            // skip dulp
            if (p1 != 0 && a1[p1 - 1] == a1[p1]) {
                p1++;
                continue;
            }
            if (p2 != 0 && a2[p2 - 1] == a2[p2]) {
                p2++;
                continue;
            }
            if (a1[p1] == a2[p2]) {
                res[i] = a1[p1];
                i++;
                p1++;
                p2++;
            } else if (a1[p1] < a2[p2]) {
                res[i] = a1[p1];
                i++;
                p1++;
            } else {
                res[i] = a2[p2];
                i++;
                p2++;
            }
        }
        if (p1 == a1.length && p2 != a2.length) {
            for (int j = p2; j < a2.length; j++) {
                if (j != 0 && a2[j - 1] == a2[j]) {
                    continue;
                }
                res[i] = a2[j];
                i++;
            }
        } else if (p2 == a2.length && p1 != a1.length) {
            for (int j = p1; j < a1.length; j++) {
                if (j != 0 && a1[j - 1] == a1[j]) {
                    continue;
                }
                res[i] = a1[j];
                i++;
            }
        }
        return res;
    }

    public static int[] intersect(int[] a1, int[] a2) {
        if (a1 == null || a2 == null)
            throw new IllegalArgumentException("");
        int[] res = new int[Math.min(a1.length, a2.length)];
        Sort.mergeSort(a1);
        Sort.mergeSort(a2);

        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while (p1 < a1.length && p2 < a2.length) {
            // skip dulp
            if (p1 != 0 && a1[p1 - 1] == a1[p1]) {
                p1++;
                continue;
            }
            if (p2 != 0 && a2[p2 - 1] == a2[p2]) {
                p2++;
                continue;
            }
            if (a1[p1] == a2[p2]) {
                res[i] = a1[p1];
                i++;
                p1++;
                p2++;
            } else if (a1[p1] < a2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        // int[] a1 = { 10, 5, 7, 5, 9, 4 };
        // int[] a2 = { 7, 5, 15, 7, 7, 9, 10 };
        // int[] result1 = union(a1, a2);
        // System.out.println("result1: " + Arrays.toString(result1));

        // int[] a3 = { 0, 2, -4, 6, 10, 8 };
        // int[] a4 = { 12, 0, -4, 8 };
        // int[] result2 = union(a3, a4);
        // System.out.println("result2: " + Arrays.toString(result2));

        // int[] a5 = { 1, 2, 2 };
        // int[] a6 = { 2, 3, 3 };
        // int[] result3 = union(a5, a6);
        // System.out.println("result2: " + Arrays.toString(result3));

        int[] a1 = { 10, 5, 7, 5, 9, 4 };
        int[] a2 = { 7, 5, 15, 7, 7, 9, 10 };
        int[] result = intersect(a1, a2);
        System.out.println(Arrays.toString(result));

        int[] a3 = { 0, 2, -4, 6, 10, 8 };
        int[] a4 = { 12, 0, -4, 8 };
        int[] result1 = intersect(a3, a4);
        System.out.println(Arrays.toString(result1));

    }
}