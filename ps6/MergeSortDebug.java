package ps6;
import java.util.Arrays;

public class MergeSortDebug {

    // Track merge call count for mergeSort
    private static int mergeCallCount = 0;
    
    /* merge - helper method for mergesort with tracking */
    private static void merge(int[] arr, int[] temp, 
      int leftStart, int leftEnd, int rightStart, int rightEnd) 
    {
        mergeCallCount++;
        int currentCallNumber = mergeCallCount;
        
        System.out.println("Before merge call " + currentCallNumber + " (leftRange=" 
            + leftStart + "-" + leftEnd + ", rightRange=" + rightStart + "-" + rightEnd 
            + "): " + Arrays.toString(arr));
        
        int i = leftStart;    // index into left subarray
        int j = rightStart;   // index into right subarray
        int k = leftStart;    // index into temp
        
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; 
            } else {
                temp[k] = arr[j];
                j++; 
            }
            k++;
        }
        
        while (i <= leftEnd) {
            temp[k] = arr[i];
            i++; 
            k++;
        }
        while (j <= rightEnd) {
            temp[k] = arr[j];
            j++; 
            k++;
        }
        
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }
        
        System.out.println("After merge call " + currentCallNumber + ": " + Arrays.toString(arr));
        
        // Extra message for merge call 2 and 4
        if (currentCallNumber == 2 || currentCallNumber == 4) {
            System.out.println("==> Snapshot after merge call " + currentCallNumber + ": " + Arrays.toString(arr));
        }
    }
    
    /** mSort - recursive method for mergesort */
    private static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int middle = (start + end) / 2;
        mSort(arr, temp, start, middle);
        
        // Check: In the very first call covering the entire array,
        // after the left half is sorted, print the array state.
        if (start == 0 && end == arr.length - 1) {
            System.out.println("After completion of the first recursive call (sorting indices " 
                               + start + " to " + middle + "): " + Arrays.toString(arr));
        }
        
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }
    
    /** mergesort - reset call counter */
    public static void mergeSort(int[] arr) {
        System.out.println("\nMergeSort - initial array: " + Arrays.toString(arr));
        mergeCallCount = 0;
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
        System.out.println("MergeSort - final sorted array: " + Arrays.toString(arr));
    }
    
    public static void main(String[] args) { 
        int[] array = {24, 3, 27, 13, 34, 2, 50, 12};
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("----------------------------------------------");
        
        // Test mergesort (other sorts omitted for brevity)
        int[] mergeArray = Arrays.copyOf(array, array.length);
        mergeSort(mergeArray);
        System.out.println("----------------------------------------------");
    }
}
