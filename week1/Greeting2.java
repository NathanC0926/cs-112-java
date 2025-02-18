package week1;
import java.util.*;

public class Greeting2 {
    public static void main(String[] args) {
        greetMe();
    }

    public static void greetMe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.print("How old are you?");
        int age = scanner.nextInt();
        if (age <= 0) {
            scanner.close();
            throw new IllegalArgumentException("Invalid age");
        }
        System.out.println(name + ", You are " + age + " years old.");
        scanner.close();
        System.out.println(insult(name,age));
    }
    public static String insult(String name, int age) {

        String res = "";

        if (age >= 50) {
            res = name + ", you are speechless!!";
        }
        else if (age >= 41) {
            res = name + ", you are miserable adults";
        }
        else if (age >= 30) {
            res = name + ", you are suffering adults";
        }
        else if (age == 21) {
            res = name + ", you just made legal age";
        }
        else if (age >= 18) {
            res = name + ", you are counting down to 30";
        }
        else if (age >= 11) {
            res = name + ", you are dweebs";
        }
        else {
            res = name + ", everyone is sweet";
        }
        return res;
    }
}
