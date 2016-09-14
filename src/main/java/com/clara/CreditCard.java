package com.clara;

import java.util.Scanner;


/**
 * Created by we4954cp on 8/31/2016.
 */
public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isValidCreditCard(String cc) {

        //TODO Replace with your code to process the credit card number, and determine if it is valid.
        //TODO Make sure all the tests pass!

        System.out.println(cc);

        //Create an int[] array with one digit of your number per element
        int[] ccArray = new int[cc.length()];

        for (int x = 0 ;  x < cc.length(); x++){

            ccArray[x] = cc.charAt(x)- '0';
        }

        //sum of numbers per specs
        int sum = 0;

        if (ccArray.length == 16){

            if (ccArray[0] == 4){

                boolean even = false;

                System.out.println("Before for loop " + sum);

                for (int i = ccArray.length-1; i >= 0 ; i--){


                    if (even){
                        System.out.println("if even");
                        //String x = new String();
                        //x = Integer.toString(ccArray[i] * 2);

                        int x = ccArray[i] * 2;

                        //if its even and has 2 digits after multiplying by 2
                        if (x > 10){

                            System.out.println("if x.length "+ x +" ==2 happened");

                            //int firstInt = Integer.parseInt(x);

                            //add the two digits together
                            String str = Integer.toString(x);
                            System.out.println("str: "+str);
                            int firstNum = str.charAt(0)-'0';
                            int secNum = str.charAt(1)-'0';
                            int tempNum = firstNum + secNum;
                            System.out.println("tempNum: "+tempNum);

                            //tempNum added to sum
                            sum += tempNum;
                            System.out.println(sum);
                        }
                        else
                        {
                            sum += x;
                            System.out.println(sum);
                        }

                    } else {
                        System.out.println("if odd");
                        //adds all of the numbers together inside the array
                        sum += ccArray[i];
                        System.out.println(sum);

                    }
                    even = !even;
                }

                if(sum % 10 == 0){
                    System.out.println(sum);
                    System.out.println("Success!");

                    return true;

                }

            }else{
                //not visa
                System.out.println("Not a VISA");
                System.out.println(ccArray[0]);

                return false;
            }

        } else {
            //not visa
            System.out.println("Not a VISA, too short");

            return false;
        }




        return false;

    }




}
