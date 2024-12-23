import java.util.Scanner;
//ID = 207372095
/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                boolean isNumber = Ex1.isNumber(num1);
                int num1Value = Ex1.number2Int(num1);
                System.out.println("num1= "+num1+" is number: "+ isNumber+" , value: "+ num1Value);
                if(isNumber) {
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();
                    if (!num2.equals("quit")) {
                        isNumber = Ex1.isNumber(num2);
                        int num2Value = Ex1.number2Int(num2);
                        System.out.println("num2= "+num2+" is number: "+ isNumber+" , value: "+ num2Value);
                        if(isNumber) {
                            System.out.println("Enter a base for output: a number [2,16] :");
                            int base = sc.nextInt();
                            if (base >= 2 && base <= 16) {
                                String sum = Ex1.int2Number(num2Value + num1Value, base);
                                String multi = Ex1.int2Number(num2Value * num1Value, base);
                                System.out.println(num1 + " + " + num2 + " = " + sum);
                                System.out.println(num1 + " * " + num2 + " = " + multi);
                                String[] values = {num1, num2, sum, multi};
                                System.out.println("Max number over [" + num1 + "," + num2 + "," + sum + "," + multi + "] is: " + values[Ex1.maxIndex(values)]);
                            } else System.out.println("ERR: wrong base, should be [2,16], got (" + base + ")");
                        }
                    }
                }

            }
        }
        System.out.println("quiting now...");


    }
}