package lab5;
/* 
 * RecurPalindrome - implementing a recursive method for determining 
 * if a string is a palindrome
 */

import java.util.Scanner;

public class RecurPalindrome {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the Palindrome Test Program!");

        // Reads in one string from the user
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nType in a word and press enter: ");
        String word = userInput.next();
        userInput.close();

        // Call the recursive function here by replacing true with your call.
        boolean isPalindrome = rPalindrome(word);

        // Printing out the result
        if (isPalindrome) {
            System.out.println("Palindrome!");
        } else {
            System.out.println("Not a palindrome!");
        }
    }

    public static int countN(int n, int[] arr, int index){
        if (index == arr.length){
            return 0;
        }
        if (arr[index] == n){
            return 1 + countN(n, arr, index+1);
        }
        return countN(n, arr, index+1);
    }
        

    }
} 
