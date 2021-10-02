/*
 *  UCF COP3330 Fall 2021 Assignment 27 Solutions
 *  Copyright 2021 Garrett Adams
 */

package Exercise27;

//Imports what we need
import java.util.regex.*;
import java.util.*;

public class Solution27 {
    //Creates String used for all functions
    static String SystemMessage ="";

    //Function that checks if last name is filled in
    public static boolean CheckLastNameFill(String UserLastName) {
        //Sets our variable to true
        boolean TempHold = true;
        //If the length isnt 0, stays true
        if (UserLastName.length() != 0) {
            TempHold = true;
        }
        //If is 0, prints error message, sets to false
        else {
            SystemMessage = SystemMessage + "The last name must be filled in.\n";
            TempHold = false;
        }
        //Returns value of TempHold
        return TempHold;
    }

    //Function to check if the last and first name are greater then 2 characters
    public static boolean CheckNameLength(String UserFirstName, String UserLastName) {
        //Sets our variable to true
        boolean TempHold = true;
        //If greater than 2, stays true
        if (UserFirstName.length() > 2) {
            TempHold = true;
        }
        //If less then 2, displays error and sets to false
        else{
            SystemMessage = SystemMessage + "The first name must be at least 2 characters long.\n";
            TempHold = false;
        }
        //If greater then 2, stays true
        if (UserLastName.length() > 2) {
            TempHold = true;
        }
        //If less than 2, displays error and sets to false
        else {
            SystemMessage = SystemMessage + "The last name must be at least 2 characters long.\n";
            TempHold = false;
        }
        //Returns TempHold
        return TempHold;
    }

    //Function to check if the employee ID is in the right format
    public static boolean CheckEmpID(String UserEIDInput) {
        //Defines our format
        String EMPIDFormat = "[a-zA-Z][a-zA-Z][-]{1}[0-9]{4}";
        //If the format matches up, returns true
        if (Pattern.matches(EMPIDFormat,UserEIDInput)) {
            return true;
        }
        //If the format doesnt, displays error and returns false
        SystemMessage = SystemMessage + "The employee ID must be in the format of AA-1234.\n";
        return false;
    }

    //Function to check if zip code is 5 digits and only digits
    public static boolean CheckZip(String UserZipInput) {
        //Defines char array ZipCondition
        char[]ZipCondition;
        //Sets ZipCondition to an array from UserZipInput
        ZipCondition = UserZipInput.toCharArray();
        //Sets TempHold and ZipDigit to true
        boolean TempHold = true;
        boolean ZipDigit = true;
        //If the length is 5, stays true
            if (UserZipInput.length() == 5) {
                TempHold = true;
            }
            //If length is not 5, displays error message and sets to false
            else {
                SystemMessage = SystemMessage + "The zipcode must be a 5 digit number.\n";
                TempHold = false;
            }

            //Loop to check if each element of zip code is a digit
        for (char i : ZipCondition)
        {

            if (Character.isDigit(i))
                ZipDigit = true;
            else
                ZipDigit = false;
        }
        //If ZipDigit is true, nothing happens
        if (ZipDigit){

        }
        //If ZipDigit is false, sends error message and sets TempHold to false
        else {
            SystemMessage = SystemMessage + "The zipcode must be a 5 digit number.\n";
            TempHold = false;
        }
        //Returns TempHold
        return TempHold;
    }

    //Function to check if UserFirstName is filled
    public static boolean CheckFirstNameFill(String UserFirstName) {
        //Sets TempHold to true
        boolean TempHold = true;

        //If length isnt 0, stays true
        if (UserFirstName.length() != 0) {
            TempHold = true;
        }
        //If 0, sets to false and displays error message
        else {
            SystemMessage = SystemMessage + "The first name must be filled in.\n";
            TempHold = false;
        }
        //Returns TempHold
        return TempHold;
    }

    //ValidateInput function that runs all of the validations
    public static void validateInput(String UserFirstName, String UserLastName, String UserZipInput, String UserEIDInput) {
        //Stores CheckNameLength in NameLength
        boolean NameLength = CheckNameLength(UserFirstName, UserLastName);
        //Stores CheckLastNameFill in lastfill
        boolean lastfill = CheckLastNameFill(UserLastName);
        //Stores CheckFirstNameFill in firstfill
        boolean firstfill = CheckFirstNameFill(UserFirstName);
        //Stores CheckEmpID in EID
        boolean EID = CheckEmpID(UserEIDInput);
        //Stores CheckZip in ZIPCheck
        boolean ZIPCheck = CheckZip(UserZipInput);
        //If no errors, sets SystemMessage to no errors found
        if (firstfill && EID && NameLength && ZIPCheck && lastfill) {
            SystemMessage = "There were no errors found.";
        }
        //Prints out the final output statement
        System.out.println(SystemMessage);
    }

    public static void main(String[] args) {
        //Sets up our scanner
        Scanner ScanWord = new Scanner(System.in);
        //Prompts user to enter all data, and stores all data appropiately
        System.out.print("Enter the first name: ");
        String UserFirstName = ScanWord.nextLine();
        System.out.print("Enter the last name: ");
        String UserLastName = ScanWord.nextLine();
        System.out.print("Enter the ZIP code: ");
        String UserZipInput = ScanWord.nextLine();
        System.out.print("Enter the employee ID: ");
        String UserEIDInput = ScanWord.nextLine();

        //Calls the validateInput function with the other validations as parameters
        validateInput(UserFirstName, UserLastName, UserZipInput, UserEIDInput);

    }
}

