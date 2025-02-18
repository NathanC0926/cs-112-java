package ps3;
/* File: MyArrays
 *
 * Author:  CS112 
 *
 * Purpose: To create a class that allows you to
 * manipulate an array of integers.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MyArray {

    // the sentinel value used to indicate end of input, initialized to -999
    // the default size of the array if one is not specified, initialized to 20
    // the lower bound of the range of integer elements, initialized to 10
    // the upper bound of the range of integer elements, initialized to 50
    // a data member to reference an array of integers
    // a data member to represent the number of elements entered into the array
    private static final int SENTINEL = -999;
    private static final int DEFAULT_SIZE = 2;
    private static final int LOWER_BOUND = 10;
    private static final int UPPER_BOUND = 50;
    private int[] arr;
    private int numElements;

    private int min = 0;
    private int max = 0;
    private int sum = 0;
    private double avg = 0.0;

    // CONSTRUCTORS
    // Initializes a MyArray object using default members
    public MyArray() {
        arr = new int[DEFAULT_SIZE];
        numElements = 0;
    }

    public MyArray(int n) {
        arr = new int[n];
        numElements = 0;
    }

    public MyArray(int[] nums) {
        arr = new int[nums.length];
        numElements = 0;
        for (int num : nums) {
            // if in bound
            if (validInput(num)) {
                arr[numElements] = num;
                numElements++;
            }
        }
        computeStatistics();
    }

    public void inputElements() {
        Scanner scanner = new Scanner(System.in);
        int remaining = arr.length - numElements;
        System.out.print("Enter up to " + remaining + " integers between " + LOWER_BOUND + " and " + UPPER_BOUND
                + " inclusive.");
        System.out.print(" Enter " + SENTINEL + " to end user input: ");
        int userInput = -99999;
        while (userInput != SENTINEL && remaining != 0) {
            userInput = scanner.nextInt();
            if (validInput(userInput)) {
                arr[numElements] = userInput;
                numElements++;
                remaining--;
            }
        }
        computeStatistics();
    }

    public static boolean validInput(int num) {
        return (LOWER_BOUND <= num && num <= UPPER_BOUND);
    }

    @Override
    public String toString() {
        int[] validElements = new int[numElements];

        // Copy only the valid elements to a new array
        for (int i = 0; i < numElements; i++) {
            validElements[i] = arr[i];
        }

        return Arrays.toString(validElements);
    }

    public void computeStatistics() {
        sum = 0;
        min = 0;
        max = 0;
        avg = 0.0;
        if (numElements == 0) return;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < numElements; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }

        avg = (double) sum / numElements;

    }

    public int numOccurences(int n) {
        int count = 0;
        for (int i = 0; i < numElements; i++) {
            if (arr[i] == n) {
                count++;
            }
        }
        return count;
    }

    public boolean insertElement(int n, int position) {
        // if arr is full
        if (numElements == arr.length)
            return false;
        // if out of bound
        if (!(0 <= position && position <= numElements)) {
            return false;
        }
        // back fill the arr
        for (int i = numElements; i > position; i--) {
            arr[i] = arr[i - 1];
        }
        arr[position] = n;
        numElements++;
        computeStatistics();
        return true;
    }

    public int removeElement(int position) {
        if (!(0 <= position && position < numElements)) {
            return -1;
        }
        int res = arr[position];
        for (int i = position; i < numElements - 1; i++) {
            arr[i] = arr[i + 1];
        }

        numElements--;
        computeStatistics();
        return res;
    }

    public boolean growArray(int n) {
        if (n <= 0)
            return false;
        int newLen = arr.length + n;
        int[] newArr = new int[newLen];

        for (int i = 0; i < numElements; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        return true;
    }

    public int getSum() {
        return sum;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getAvg() {
        return avg;
    }

    public int[] getArr() {
        return arr;
    }

    public String computeHistogram() {
        String s = "";
        for (int i = 0; i < numElements; i++) {
            s += helperStar(arr[i]);
        }
        return s;
    }

    private String helperStar(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "*";
        }
        return s + "\n";
    }

    // scanner.close();
    // System.out.println(Arrays.toString(arr));

    public static void main(String[] args) {

        System.out.println("\nUnit Test for MyArray.\n");
        MyArray arr = new MyArray();
        arr.inputElements();
        System.out.println(arr.computeHistogram());
        
        // Fill in your unit tests

    }
}
