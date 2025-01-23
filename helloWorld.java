import java.util.Scanner;

public class helloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Read a full line of input
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Read an integer input

        System.out.println("Hello, " + name + "! You are " + age + " years old.");

        scanner.close(); // Close the scanner to free resources
    }
}
