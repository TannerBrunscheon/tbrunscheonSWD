/**
 * This class has two static method in it. Thus its a very all in one library for converting Roman to Arabic
 * or back. Both methods in the class are static and can be used without instantiation.
 */
public class RomanToArabicConverter {

    /**
     * This is converting Roman to arabic. To do this it goes one at a time through the numerals. It checks if there
     * is a next numeral.If their is it looks at that next numeral. If it is "higher" than the first numeral, it subtracts
     * its value from the number. If it is the same or lower or doesn't exist, it adds the roman numerals value to the number
     * To check for errors,it looks at the numerals around the one selected.If there are 3 in a row, it throws an error,
     * if there are 2 in a row then another number higher (double subtraction) it throws an error. Finally if the numeral doesn't
     * exist, it throws an error.
     * @param number The Roman numeral to be converted
     * @return The arabic number returned
     */

    public static int RomanConversion(String number) {
        //Final number
        int finalNumber = 0;
        //For loop through the string.
        for (int i = 0; i < number.length(); i++) {
            // Switch at the character in the index
            switch (number.charAt(i)) {
                case 'I':
                    //Look at the numbers around the current number and check if its a valid numeral
                    if (i > 2 && number.charAt(i - 3) == 'I' && number.charAt(i - 2) == 'I' && number.charAt(i - 1) == 'I') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    } else if (checkNumber(i, number)) {
                        //Check if the next number is lower or the same as this one. If so add
                        if (number.charAt(i + 1) == 'I') {
                            finalNumber = finalNumber + 1;
                        } else {
                            //Look at the numbers around the current number and check if its a valid numeral
                            if (i > 0 && number.charAt(i - 1) == 'I' && number.charAt(i + 1) != 'I') {
                                throw new IllegalArgumentException("Invalid Roman Numeral");
                            }
                            //Subtract the amount if the next number is "Higher" than it.
                            finalNumber = finalNumber - 1;
                        }

                    } else {
                        //If its the last number add it to the amount
                        finalNumber = finalNumber + 1;
                    }
                    break;
                case 'V':
                    if (checkNumber(i, number)) {
                        //Look at the numbers around the current number and check if its a valid numeral

                            //If there is another 1 add an O
                        if (number.charAt(i + 1) == 'I') {
                            finalNumber = finalNumber + 5;
                        } else {
                            //Subtract the amount if the next number is "Higher" than it.
                             finalNumber = finalNumber - 5;
                        }
                    }
                    else {
                        //If its the last number add it to the amount
                        finalNumber = finalNumber + 5;
                    }
                    //Look at the numbers around the current number and check if its a valid numeral
                    if (i > 0 && number.charAt(i - 1) == 'V'){
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    break;
                case 'X':
                    if (checkNumber(i, number)) {
                        //Look at the numbers around the current number and check if its a valid numeral
                        if (i > 2 && number.charAt(i - 3) == 'X' && number.charAt(i - 2) == 'X' && number.charAt(i - 1) == 'X') {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        }
                        //Check if the next number is lower or the same as this one. If so add
                        if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X') {
                            finalNumber = finalNumber + 10;
                        } else {
                            //Subtract the amount if the next number is "Higher" than it.
                            finalNumber = finalNumber - 10;
                            //Look at the numbers around the current number and check if its a valid numeral
                        }

                    } else {
                        //If its the last number add it to the amount
                        finalNumber = finalNumber + 10;
                    }
                    if (i > 0 && number.charAt(i - 1) == 'X' && number.charAt(i + 1) != 'X') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    break;

                case 'L':
                    //Look at the numbers around the current number and check if its a valid numeral
                    if (i > 0 && number.charAt(i - 1) == 'L'){
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    //Check if the next number is lower or the same as this one. If so add
                    if (checkNumber(i, number)) {
                        if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X' || number.charAt(i + 1) == 'L') {
                            finalNumber = finalNumber + 50;
                        } else
                            //Subtract the amount if the next number is "Higher" than it.
                            finalNumber = finalNumber - 50;
                    } else {
                        //If its the last number add it to the amount
                        finalNumber = finalNumber + 50;
                    }
                    break;
                case 'C':
                    //Look at the numbers around the current number and check if its a valid numeral
                    if (i > 2 && number.charAt(i - 3) == 'C' && number.charAt(i - 2) == 'C' && number.charAt(i - 1) == 'C') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    if (checkNumber(i, number)) {
                        //Check if the next number is lower or the same as this one. If so add
                        if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X' || number.charAt(i + 1) == 'L' || number.charAt(i + 1) == 'C') {
                            finalNumber = finalNumber + 100;
                        } else {
                            //Subtract the amount if the next number is "Higher" than it.
                            finalNumber = finalNumber - 100;
                            //Look at the numbers around the current number and check if its a valid numeral
                            if (i > 0 && number.charAt(i - 1) == 'C' && number.charAt(i + 1) != 'C') {
                                throw new IllegalArgumentException("Invalid Roman Numeral");
                            }
                        }
                    } else {
                        //If its the last number add it to the amount
                        finalNumber = finalNumber + 100;
                    }
                    break;
                case 'D':
                    //Look at the numbers around the current number and check if its a valid numeral
                    if (number.charAt(i - 1) == 'D') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    } else {
                        if (checkNumber(i, number)) {
                            //Check if the next number is lower or the same as this one. If so add
                            if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X' || number.charAt(i + 1) == 'L' || number.charAt(i + 1) == 'C' || number.charAt(i + 1) == 'D') {
                                finalNumber = finalNumber + 500;
                            } else
                                //Subtract the amount if the next number is "Higher" than it.
                                finalNumber = finalNumber - 500;
                        } else {
                            finalNumber = finalNumber + 500;
                        }
                        if (i > 0 && number.charAt(i - 1) == 'D' && number.charAt(i + 1) != 'D') {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        }
                    }
                    break;
                case 'M':
                    //Look at the numbers around the current number and check if its a valid numeral
                    if (i > 2 && number.charAt(i - 3) == 'M' && number.charAt(i - 2) == 'M' && number.charAt(i - 1) == 'M') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    if (checkNumber(i, number)) {
                        //Check if the next number is lower or the same as this one. If so add
                        if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X' || number.charAt(i + 1) == 'L' || number.charAt(i + 1) == 'C' || number.charAt(i + 1) == 'D' || number.charAt(i + 1) == 'M') {
                            finalNumber = finalNumber + 1000;
                        } else {
                            //Subtract the amount if the next number is "Higher" than it.
                            finalNumber = finalNumber - 1000;
                        }
                        //Look at the numbers around the current number and check if its a valid numeral
                        if (i > 0 && number.charAt(i - 1) == 'M' && number.charAt(i + 1) != 'M') {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        }
                    } else {
                        //If its the last number add it to the amount
                        finalNumber = finalNumber + 1000;
                    }
                    break;
                default:
                    //If its not a roman numeral send an error.
                    throw new IllegalArgumentException("Invalid Roman Numeral");
            }
        }
        return finalNumber;
    }

    /**
     * Simple program to check if the next number exists
     * @param i The number in the cycle that array is at
     * @param array Array to be check
     * @return True or False the next number exists
     */
    private static boolean checkNumber(int i, String array) {
        if (i + 1 < array.length()) {
            return true;
        }
        return false;
    }

    /**
     * This program is for converting an arablic number into roman numerals. It starts by "mapping" roman numerals
     * to their corresponding amounts. It does the numerals that can be 3 in a row and them minus the numerals that
     * can be only 1 in a row. For instance there is an M and a C. It then works from highest numeral to lowest
     * numeral using a while loop to subtract the value from the number and add the corresponding numeral.
     * It returns the string when the number equals 0.
     * @param number Arabic number to be converted
     * @return Roman numeral computed
     */
    public static String ArabicConversion(int number) {
        //Initialize the string for the conversion
        String roman = "";
        //Mapping for romanChar to their values
        String[] romanChars = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] romanVals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i=0;
        //While the number given is larger than the value of the roman numeral we are currently on
        //subtract that amount from the number. When its down to 0 break the loop.
        while (number > 0) {
            while(number >= romanVals[i]){
                number = number - romanVals[i];
                roman = roman + romanChars[i];
            }
            i++;
        }
        //If the string is empty return 0 because there is nothing in the string.
        if (roman.isEmpty()) {
            return
                    "0";
        }

        return roman;
    }

}