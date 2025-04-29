package ps6;
import java.util.Arrays;

public class Sort {
    public static final int NUM_ELEMENTS = 8;
    
    /*
     * swap - swap the values of arr[a] and arr[b].
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    /*
     * indexSmallest - returns the index of the smallest element
     * in the subarray from arr[start] to the end of the array.  
     */
    private static int indexSmallest(int[] arr, int start) {
        int indexMin = start;
        
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[indexMin]) {
                indexMin = i;
            }
        }
        
        return indexMin;
    }
    
    /** selectionSort with tracking after each pass */
    public static void selectionSort(int[] arr) {
        System.out.println("Selection Sort - initial array: " + Arrays.toString(arr));
        
        for (int i = 0; i < arr.length - 1; i++) {
            int j = indexSmallest(arr, i);
            swap(arr, i, j);
            System.out.println("Selection Sort - after pass " + (i+1) + ": " + Arrays.toString(arr));
        }
    }
    
    /** insertionSort with tracking after each iteration */
    public static void insertionSort(int[] arr) {
        System.out.println("\nInsertion Sort - initial array: " + Arrays.toString(arr));
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                // Save a copy of the element to be inserted.
                int toInsert = arr[i];
                
                // Shift right to make room for element.
                int j = i;
                do {
                    arr[j] = arr[j - 1];
                    j = j - 1;
                } while (j > 0 && toInsert < arr[j-1]);
                
                // Put the element in place.
                arr[j] = toInsert;
            }
            System.out.println("Insertion Sort - after iteration " + i + ": " + Arrays.toString(arr));
        }
    }
    
    /** bubbleSort with tracking after each pass */
    public static void bubbleSort(int[] arr) {
        System.out.println("\nBubble Sort - initial array: " + Arrays.toString(arr));
        
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
            System.out.println("Bubble Sort - after pass " + (arr.length - i) + ": " + Arrays.toString(arr));
        }
    }
    
    /* partition - helper method for qSort */
    private static int partition(int[] arr, int first, int last) {
        int pivot = arr[(first + last)/2];
        int i = first - 1;  // index going left to right
        int j = last + 1;   // index going right to left
        
        do {
            // moving from left to right, find an element >= the pivot
            do {i++;} while (arr[i] < pivot);
            // moving from right to left, find an element <= the pivot
            do {j--;} while (arr[j] > pivot); 
            
            if (i < j) {
                swap(arr, i, j);
            }
        } while (i < j);
        
        return j;
    }
    
    // Track partition call count for quickSort
    private static int partitionCallCount = 0;
    
    /* qSort - recursive method with tracking */
    private static void qSort(int[] arr, int first, int last) {
        partitionCallCount++;
        int currentCallNumber = partitionCallCount;
        
        System.out.println("QuickSort - before partition call " + currentCallNumber + 
                         " (first=" + first + ", last=" + last + "): " + Arrays.toString(arr));
        
        int split = partition(arr, first, last);
        
        System.out.println("QuickSort - after partition call " + currentCallNumber + 
                         " (pivot index=" + split + "): " + Arrays.toString(arr));
        
        if (first < split) {
            qSort(arr, first, split);      // left subarray
        }
        if (last > split + 1) {
            qSort(arr, split + 1, last);   // right subarray
        }
    }
    
    /** quicksort - reset call counter */
    public static void quickSort(int[] arr) {
        System.out.println("\nQuickSort - initial array: " + Arrays.toString(arr));
        partitionCallCount = 0;
        qSort(arr, 0, arr.length - 1); 
    }
    
    // Track merge call count for mergeSort
    private static int mergeCallCount = 0;
    
    /* merge - helper method for mergesort with tracking */
    private static void merge(int[] arr, int[] temp, 
      int leftStart, int leftEnd, int rightStart, int rightEnd)
    {
        mergeCallCount++;
        int currentCallNumber = mergeCallCount;
        
        System.out.println("MergeSort - before merge call " + currentCallNumber + 
                         " (leftRange=" + leftStart + "-" + leftEnd + 
                         ", rightRange=" + rightStart + "-" + rightEnd + "): " + 
                         Arrays.toString(arr));
        
        int i = leftStart;    // index into left subarray
        int j = rightStart;   // index into right subarray
        int k = leftStart;    // index into temp
        
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; k++;
            } else {
                temp[k] = arr[j];
                j++; k++;
            }
        }
        
        while (i <= leftEnd) {
            temp[k] = arr[i];
            i++; k++;
        }
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++; k++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
        
        System.out.println("MergeSort - after merge call " + currentCallNumber + ": " + 
                         Arrays.toString(arr));
    }
    
    /** mSort - recursive method for mergesort */
    private static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int middle = (start + end)/2;
        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }
    
    /** mergesort - reset call counter */
    public static void mergeSort(int[] arr) {
        System.out.println("\nMergeSort - initial array: " + Arrays.toString(arr));
        mergeCallCount = 0;
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
    }
    
    public static void main(String[] args) { 
        int[] array = {14, 7, 27, 13, 24, 20, 10, 33};
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("----------------------------------------------");
        
        // Test selection sort
        int[] selArray = Arrays.copyOf(array, array.length);
        selectionSort(selArray);
        System.out.println("----------------------------------------------");
        
        // Test insertion sort
        int[] insArray = Arrays.copyOf(array, array.length);
        insertionSort(insArray);
        System.out.println("----------------------------------------------");
        
        // Test bubble sort
        int[] bubArray = Arrays.copyOf(array, array.length);
        bubbleSort(bubArray);
        System.out.println("----------------------------------------------");
        
        // Test quicksort
        int[] quickArray = Arrays.copyOf(array, array.length);
        quickSort(quickArray);
        System.out.println("----------------------------------------------");
        
        // Test mergesort
        int[] mergeArray = Arrays.copyOf(array, array.length);
        mergeSort(mergeArray);
        System.out.println("----------------------------------------------");
        
    }
}