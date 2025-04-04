package lab1;
/* 
 * Lab 2 - Debugging Exercise #2
 * 
 * Practice debugging a static method
 *
 * name:
 * email:
 *
 * Fix all the bugs in this file! Then run it and add some extra tests
 * to make sure everything works
 *
 */

public class Debugging2 {
    /*
     * triArea - computes and returns the area of a triangle 
     * with base b and height h (both of which are integers).
     * The area is returned as a floating-point number, and 
     * the result should be as precise as possible.
     */
    public static double triArea(float b, float h) {
        float area = b/2*h;
        return area;
    }
	
    public static void main(String[] args) {
        System.out.println("Testing the triArea method");
        double a = triArea(9, 3);
        System.out.println("triArea(10, 3) is: " + a);
    }
}
