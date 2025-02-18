package ps2;
/*
 * Methods6.java
 * 
 * Code added by: Chi Hin Nathan Chang nc0926@bu.edu
 *
 * Practice with static methods, part I
 */
import java.util.*;

public class Methods6 {
    /*
     * 0) printVertical - takes a string s and prints the characters of 
     *    the string vertically -- with one character per line.
     */
    public static void printVertical(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
        }
    }
    public static void printEveryOther(String s) {
        for (int i = 0; i < s.length(); i += 2){
            System.out.print(s.charAt(i));
            }   
        }
    public static int longerLen(String x, String y){
        return (x.length() > y.length()) ? x.length():y.length();

    }
    public static int secondIndex(String s, char c){
        int res = -1;
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c){
                count++;
            }
            if (count == 2){
                res = i;
                break;
            }
        }
        return res;

    }
    public static void main(String[] args) {
        /* Sample test call */
        printVertical("method");
        printEveryOther("method"); 
        System.out.println(longerLen("hi","Im fine"));
        System.out.println(secondIndex("banana",'x'));
    }
}
