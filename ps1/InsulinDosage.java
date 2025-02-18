package ps1;
/*
 * InsulinDosage.java
 * 
 * This program computes the dosage of insulin that a person should
 * take before a meal, based on the person's current blood sugar, 
 * their target blood sugar, the amount of exercise they have performed
 * recently, and two characteristics of the meal they are about to consume.
 * 
 * CS 112 Course Staff (cs112-staff@cs.bu.edu)
 * 
 * completed by: Chi Hin Nathan Chang (nc0926@bu.edu)
 * partner (if any): None
 */
import java.util.*;

 public class InsulinDosage {
     public static void main(String[] args) {
         // Create a Scanner that can read from the console.
         Scanner scanner = new Scanner(System.in);
         
         /*
          * TO DO: replace each of the 0s below with a method
          * call that gets an integer from the user.
          * You MUST use the Scanner object created above
          * at the start of main. You may NOT construct an
          * additional Scanner object.
          */
         System.out.print("current blood sugar: ");
         int currentSugar = scanner.nextInt();
         System.out.print("target blood sugar: ");
         int targetSugar = scanner.nextInt();
         System.out.print("carbohydrate equivalency: ");
         int carbEquiv = scanner.nextInt();
         System.out.print("carbohydrates to consume: ");
         int carbConsume = scanner.nextInt();
         System.out.print("amount of exercise (0-3): ");
         int exercise = scanner.nextInt();
         
         /*
          * TO DO: complete the rest of the program below.
          */
        double dossage = (currentSugar - targetSugar) / 55.0 + (carbConsume / (double) carbEquiv) - exercise;
        if (dossage == 1.0) {
            System.out.println("recommended dosage: 1 unit");
        }
        else if (dossage <= 0.0) {
            System.out.println("recommended dosage: 0 units");
        }
        else if (dossage % 1 == 0) {
            System.out.println("recommended dosage: " + (int) dossage + " units");
        }
        else {
            System.out.println("recommended dosage: " + dossage + " units");
        }
        
         // Leave this line unchanged.
         scanner.close();
     }
 }
 