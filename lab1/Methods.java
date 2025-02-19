package lab1;
/*
 * CS112
 *
 * Lab 2: Simple Methods
 *
 * name: 
 * email:
 *
 *
 * Note: Because this class is simply a collection of static methods 
 * and it does not have a main method, you cannot run it.
 * 
 * You will need to write a main method that makes calls to each of the
 * methods to test them. Follow the instructions in the lab.
 */

public class Methods {
    /*
     * print3Times - takes a string s and prints it 3 times
     */
    public static void print3Times(String s) {
        for (int i = 0; i < 3; i++) {
            System.out.println(s);
        }
    }
    public static void printNTimes(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }
    public static void main(String[] args){
        printNTimes(5,"hi");
        print3Times("hello");
    }
}

