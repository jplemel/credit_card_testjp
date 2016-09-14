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



                for (int i = ccArray.length ; i < 0 ; i--){

                    even = !even;

                    if (even){

                        String x = Integer.toString((ccArray[i] * 2));

                        //if its even and has 2 digits after multiplying by 2
                        if (x.length() == 2){

                            System.out.println("if x.length ==2 happened");

                            //int firstInt = Integer.parseInt(x);

                            //add the two digits together
                            int tempNum = x.charAt(0) + x.charAt(1);

                            //tempNum added to sum
                            sum += tempNum;

                        }

                    } else {

                        //adds all of the numbers together inside the array
                        sum += ccArray[i];

                    }
                }

                if(sum % 10 == 0){

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
