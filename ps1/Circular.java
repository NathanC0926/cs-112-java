package ps1;

import java.util.*;

/*
 * Circular.java
 * 
 * This program calculates the area of a circular piece of land given its diameter.
 * It displays the area both in square feet (rounded) and in square yards plus remaining square feet.
 * 
 * completed by: Chi Hin Nathan Chang (nc0926@bu.edu)
 */

public class Circular {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the diameter of the piece of land (specified to the nearest foot): ");
        int diameter = scanner.nextInt();

        final double PI = Math.PI;
        double radius = diameter / 2.0;
        double area = PI * radius * radius;

        int roundedArea = (int) Math.round(area);
        int squareYards = roundedArea / 9;  
        int remainingSquareFeet = roundedArea % 9;

        System.out.println("The area of the circle is approximately:");
        System.out.println(roundedArea+ " square feet");
        System.out.println(squareYards + " square yards plus " + remainingSquareFeet + " square feet");
        scanner.close();
    }
}
