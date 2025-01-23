package week1;
import java.util.*;

public class Greetings {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your first name: ");
        String name = scanner.nextLine();
        System.out.println("Hello "+name+", Welcome to CS112!!!");
        System.out.print("How old are you "+name+" ");
        int age = scanner.nextInt();
        scanner.close();
        if (age<21){
            System.out.println("You are a loser");
        } else{
            System.out.println("you are all good");
        }
        for (int i=0; i<5;i++){
            System.out.println(i*2);
        }
    }
}
