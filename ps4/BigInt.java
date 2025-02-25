/* 
 * BigInt.java
 *
 * A class for objects that represent non-negative integers of 
 * up to 20 digits.
 */

public class BigInt {
    // the maximum number of digits in a BigInt -- and thus the length
    // of the digits array
    private static final int MAX_SIZE = 20;

    // the array of digits for this BigInt object
    private int[] digits;

    // the number of significant digits in this BigInt object
    private int numSigDigits;

    /*
     * Default, no-argument constructor -- creates a BigInt that
     * represents the number 0.
     */
    public BigInt() {
        digits = new int[MAX_SIZE];
        numSigDigits = 1; // 0 has one sig. digit--the rightmost 0!
    }

    public BigInt(int[] arr) {
        if (isValidInput(arr)) {
            digits = new int[MAX_SIZE];
            int startIndex = MAX_SIZE - arr.length;
            // copy the input to digits
            for (int i = 0; i < arr.length; i++) {
                digits[startIndex + i] = arr[i];
            }
            // find numSigDigits
            for (int i = startIndex; i < MAX_SIZE; i++) {
                if (digits[i] != 0 || i == MAX_SIZE - 1) {
                    numSigDigits = MAX_SIZE - i;
                    break;
                }
            }
        }
    }

    public BigInt(int n) {
        if (n < 0) throw new IllegalArgumentException("negative");
        digits = new int[MAX_SIZE];
        numSigDigits = (n == 0) ? 1 : 0;
        int index = MAX_SIZE - 1;
        while (n > 0) {
            digits[index] = n % 10;
            n /= 10;
            index--;
            numSigDigits++;
        }
    }

    private boolean isValidInput(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }
        if (arr.length > MAX_SIZE) {
            throw new IllegalArgumentException("Array out of bound.");
        }
        for (int num : arr) {
            if (num < 0 || num > 9) {
                throw new IllegalArgumentException("Array contains an invalid digit:" + num);
            }
        }
        return true;

    }

    public int getNumSigDigits() {
        return numSigDigits;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = MAX_SIZE - numSigDigits; i < MAX_SIZE; i++) {
            res = res + digits[i];
        }
        return res;
    }

    public int compareTo(BigInt other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot compare to null.");
        }
        if (numSigDigits != other.getNumSigDigits()) {
            return (numSigDigits > other.getNumSigDigits()) ? 1 : -1;
        }
        for (int i = MAX_SIZE - numSigDigits; i < MAX_SIZE; i++) {
            if (digits[i] > other.digits[i]) { // Allowed because same class
                return 1;
            } else if (digits[i] < other.digits[i]) {
                return -1;
            }
        }
        return 0;
    }

    public BigInt add(BigInt other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot compare to null.");
        }
        int[] res = new int[MAX_SIZE];
        int carry = 0;
        for (int i = MAX_SIZE - 1; i > -1; i--) {
            int sum = digits[i] + other.digits[i] + carry;
            if (i == 0 && sum >= 10) {
                throw new ArithmeticException("Overflow error: result exceeds maximum capacity.");
            }
        
            res[i] = sum % 10;
            carry = sum / 10;
        }
        return new BigInt(res);
    }

    public BigInt mul(BigInt other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot multiply by null.");
        }

        BigInt res = new BigInt();

        for (int i = MAX_SIZE - 1; i > -1; i--) {

            BigInt mult = new BigInt();

            for (int j = 0; j < other.digits[i]; j++) {
                mult = mult.add(this);
            }

            res = res.add(moveZero(mult, MAX_SIZE - 1 - i));
        }
        return res;

    }

    private BigInt moveZero(BigInt b, int moveBy) {
        int[] res = new int[MAX_SIZE];

        // Find where the original digits start
        int startIdx = MAX_SIZE - b.numSigDigits;
        int newStartIdx = startIdx - moveBy;

        if (newStartIdx < 0) {
            throw new ArithmeticException("Overflow error: result exceeds maximum capacity.");
        }

        // Shift digits
        for (int i = 0; i < b.numSigDigits; i++) {
            res[newStartIdx + i] = b.digits[startIdx + i];
        }

        return new BigInt(res);
    }


    public static void main(String[] args) {
        System.out.println("Unit tests for the BigInt class.");
        System.out.println();

        /*
         * You should uncomment and run each test--one at a time--
         * after you build the corresponding methods of the class.
         */

         
            BigInt a = new BigInt(Integer.MAX_VALUE);
            BigInt b = new BigInt(1);
            BigInt result = a.mul(b);
            System.out.println("Expected: 5535");
            System.out.println("Actual:   " + result.toString());


        /*
         * System.out.println("Test 1: result should be 7");
         * int[] a1 = { 1,2,3,4,5,6,7 };
         * BigInt b1 = new BigInt(a1);
         * System.out.println(b1.getNumSigDigits());
         * System.out.println();
         * 
         * System.out.println("Test 2: result should be 1234567");
         * b1 = new BigInt(a1);
         * System.out.println(b1);
         * System.out.println();
         * 
         * System.out.println("Test 3: result should be 0");
         * int[] a2 = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
         * BigInt b2 = new BigInt(a2);
         * System.out.println(b2);
         * System.out.println();
         * 
         * System.out.println("Test 4: should throw an IllegalArgumentException");
         * try {
         * int[] a3 = { 0,0,0,0,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0 };
         * BigInt b3 = new BigInt(a3);
         * System.out.println("Test failed.");
         * } catch (IllegalArgumentException e) {
         * System.out.println("Test passed.");
         * } catch (Exception e) {
         * System.out.println("Test failed: threw wrong type of exception.");
         * }
         * System.out.println();
         * 
         * System.out.println("Test 5: result should be 1234567");
         * b1 = new BigInt(1234567);
         * System.out.println(b1);
         * System.out.println();
         * 
         * System.out.println("Test 6: result should be 0");
         * b2 = new BigInt(0);
         * System.out.println(b2);
         * System.out.println();
         * 
         * System.out.println("Test 7: should throw an IllegalArgumentException");
         * try {
         * BigInt b3 = new BigInt(-4);
         * System.out.println("Test failed.");
         * } catch (IllegalArgumentException e) {
         * System.out.println("Test passed.");
         * } catch (Exception e) {
         * System.out.println("Test failed: threw wrong type of exception.");
         * }
         * System.out.println();
         * 
         * System.out.println("Test 8: result should be 0");
         * b1 = new BigInt(12375);
         * b2 = new BigInt(12375);
         * System.out.println(b1.compareTo(b2));
         * System.out.println();
         * 
         * System.out.println("Test 9: result should be -1");
         * b2 = new BigInt(12378);
         * System.out.println(b1.compareTo(b2));
         * System.out.println();
         * 
         * System.out.println("Test 10: result should be 1");
         * System.out.println(b2.compareTo(b1));
         * System.out.println();
         * 
         * System.out.println("Test 11: result should be 0");
         * b1 = new BigInt(0);
         * b2 = new BigInt(0);
         * System.out.println(b1.compareTo(b2));
         * System.out.println();
         * 
         * // * System.out.println("Test 12: result should be\n123456789123456789");
         * // * int[] a4 = { 3,6,1,8,2,7,3,6,0,3,6,1,8,2,7,3,6 };
         * // * int[] a5 = { 8,7,2,7,4,0,5,3,0,8,7,2,7,4,0,5,3 };
         * // * BigInt b4 = new BigInt(a4);
         * // * BigInt b5 = new BigInt(a5);
         * // * BigInt sum = b4.add(b5);
         * // * System.out.println(sum);
         * // * System.out.println();
         * 
         * System.out.println("Test 13: result should be\n123456789123456789");
         * System.out.println(b5.add(b4));
         * System.out.println();
         * 
         * System.out.println("Test 14: result should be\n3141592653598");
         * b1 = new BigInt(0);
         * int[] a6 = { 3,1,4,1,5,9,2,6,5,3,5,9,8 };
         * b2 = new BigInt(a6);
         * System.out.println(b1.add(b2));
         * System.out.println();
         * 
         * System.out.println("Test 15: result should be\n10000000000000000000");
         * int[] a19 = { 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9 }; // 19 nines!
         * b1 = new BigInt(a19);
         * b2 = new BigInt(1);
         * System.out.println(b1.add(b2));
         * System.out.println();
         */
    }
}
