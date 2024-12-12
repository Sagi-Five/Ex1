Introduction
This program is a solution for working with numbers in different bases (from 2 to 16). It includes two classes:

Ex1Main: The main program for interacting with the user.
Ex1: class with methods to handle number conversions and calculations.

Program Flow:
      The program validates if the input string is a number in a correct format.
      Example: "101b2" is valid, "123b20" is not valid.
      Convert Number to Decimal:
      
      Converts numbers from any base (2-16) to decimal.
      Example: "101b2" → 5.
      Convert Decimal to Other Bases:
      
      Converts a decimal number into another base (2-16).
      Example: 10 in base 2 → "1010b2".
      Basic Math Operations:
      
      Adds and multiplies two numbers and converts results to a chosen base.
      Example: "10b2" + "11b2" in base 2 → "101b2".
      Find the Largest Number:
      
      Compares an array of numbers and finds the largest one.

Methods in Ex1 Class
      1)isNumber(String a):
      Checks if a string is a valid number format.
      
      2)number2Int(String num):
      Converts a valid number to its decimal (integer) value.
      
      3)int2Number(int num, int base):
      Converts a decimal integer to a string representation in a specific base.
      
      4)equals(String n1, String n2):
      Checks if two numbers are equal in value.
      
      5)maxIndex(String[] arr):
      Finds the index of the largest number in an array.
      
      6)convertToInt(char num):
      Converts a single character to its integer value.
