/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    /*
    The number2Int function converts a string into a number.
    Making the code simpler and clearer can make it easier to understand and use.
     */
    public static int number2Int(String num) {
        int ans = -1;
        if (!isNumber(num)) {
            return ans;
        }
        else {
            if (!num.contains("b"))
                return Integer.parseInt(num);
        }
        ans =0;
        String[] spiltByB = num.split("b");
        int base = convertToInt(spiltByB[1].charAt(0));
        for (int i = 0; i < spiltByB[0].length(); i++) { /* This loop calculates the numerical value of a string in a specific base.
        Simplifying the calculation and improving readability can make the code easier to follow and maintain.
        */
            ans += (int) (convertToInt(spiltByB[0].charAt(i)) * Math.pow(base, spiltByB[0].length() - i - 1)); /*
            This line calculates the contribution of each character
             in the base representation to the overall numeric value
            */

        }
        return ans;
    }
    /*
    The function convertToInt converts a single character to its integer value,
    leveraging the ASCII table for decoding both numeric ('0'-'9')
    and alphabetic ('A'-'G') representations.
     */
    public static int convertToInt(char num) {
        int ans = -1;
        if (num - '0' >= 0 && num - '0' <= 9) { // Utilizes the ASCII table to retrieve a value for numbers between 0 - 9.
            ans = num - '0';
            return ans;
        }
        else if (num - '0' > 9){
            if ((num - 'A' + 10) >= 10 && (num - 'A' + 10) <= 16) { // Utilizes the ASCII table to retrieve a numeric value for numbers between 10 and 16.
                ans  = num - 'A' + 10;
                return ans;
            }
        }
        return ans;
        }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    /*isNumber A function that checks whether a number is valid for
    progression and returns -1 if the number is not valid for progression.
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (a.isEmpty() || a == null){
            return false;
        }
        if(!a.contains("b")){
            for(int i=0; i<a.length(); i++){
                if(!(convertToInt(a.charAt(i))>=0 && convertToInt(a.charAt(i))<=9)){
                    return false;
                }
            }
        }
        else {
            String[] spiltByB = a.split("b"); //Splits a string into two parts, using the character 'b' as the delimiter.
            if (spiltByB.length != 2 || spiltByB[0].isEmpty() || spiltByB[1].length() != 1) {
                return false;
            }
            int base = convertToInt(spiltByB[1].charAt(0));
            if (base < 2 || base > 16)
                return false;
            for (int i = 0; i < spiltByB[0].length(); i++) {
                int charValue = convertToInt(spiltByB[0].charAt(i)); /*
                This line converts a character at position i in the string
                to its numeric value using the convertToInt function.
                It handles both digits ('0'-'9') and letters ('A'-'F') for the given base.
                */
                if (!(charValue >= 0 && charValue < base)) {
                    return false;
                }
            }
        }
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */


    /*
    The function int2Number converts an integer to its representation in a specified
     base between 2 and 16. While the logic attempts to handle both numeric and alphabetic
      characters for bases above 10,
     */

    public static String int2Number(int num, int base) {
        String ans = "";
        char charBase;
        if (base >= 10) {
            charBase = (char)(base - 10 + 'A');
        }
        else {
            charBase = (char)(base +'0');
        }

        if(num < 0 || base < 2 || base > 16) {
            return ans;
        }
        while (num > 0) {
            if (num % base >= 10) {
                ans = ans + ((char)((num % base) - 10 +(int) 'A'));
            }
            else {
                ans += String.valueOf(num % base);
            }
            num /= base;

        }
        ans = new StringBuilder(ans).reverse().toString()+"b"+charBase; /*
        Reverses the string to correct its order, adds "b" as a separator to indicate the base,
         and appends the base indicator (charBase) to complete the formatted result.
         */
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    /*
    The equals function compares two string representations of
     numbers by converting them to integers.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
       if(number2Int(n1)!=number2Int(n2)){
           ans = false;
       }
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    /*
    The maxIndex function finds the index of the largest number in a string array.
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (number2Int(arr[i]) > number2Int((arr[ans]))){
                ans = i;
            }
        }
        return ans;
    }
}