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
        int finalNumber = 0;
        for (int i = 0; i < number.length(); i++) {
            switch (number.charAt(i)) {
                case 'I':
                    if (i > 2 && number.charAt(i - 3) == 'I' && number.charAt(i - 2) == 'I' && number.charAt(i - 1) == 'I') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    } else if (checkNumber(i, number)) {
                        if (number.charAt(i + 1) == 'I') {
                            finalNumber = finalNumber + 1;
                        } else {
                            if (i > 0 && number.charAt(i - 1) == 'I' && number.charAt(i + 1) != 'I') {
                                throw new IllegalArgumentException("Invalid Roman Numeral");
                            }
                            finalNumber = finalNumber - 1;
                        }

                    } else {
                        finalNumber = finalNumber + 1;
                    }
                    break;
                case 'V':
                    if (checkNumber(i, number)) {
                        if (number.charAt(i + 1) == 'V') {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        } else {
                            if (number.charAt(i + 1) == 'I') {
                                finalNumber = finalNumber + 5;
                            } else {
                                finalNumber = finalNumber - 5;
                            }
                        }

                    } else {
                        finalNumber = finalNumber + 5;
                    }
                    break;
                case 'X':
                    if (checkNumber(i, number)) {
                        if (i > 2 && number.charAt(i - 3) == 'X' && number.charAt(i - 2) == 'X' && number.charAt(i - 1) == 'X') {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        }
                        if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X') {
                            finalNumber = finalNumber + 10;
                        } else {
                            finalNumber = finalNumber - 10;
                            if (i > 0 && number.charAt(i - 1) == 'X' && number.charAt(i + 1) != 'X') {
                                throw new IllegalArgumentException("Invalid Roman Numeral");
                            }

                        }
                    } else {
                        finalNumber = finalNumber + 10;
                    }
                    break;

                case 'L':
                    if (number.charAt(i - 1) == 'L') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    } else {
                        if (checkNumber(i, number)) {
                            if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X' || number.charAt(i + 1) == 'L') {
                                finalNumber = finalNumber + 50;
                            } else
                                finalNumber = finalNumber - 50;
                        } else {
                            finalNumber = finalNumber + 50;
                        }
                        break;
                    }
                case 'C':
                    if (i > 2 && number.charAt(i - 3) == 'C' && number.charAt(i - 2) == 'C' && number.charAt(i - 1) == 'C') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    if (checkNumber(i, number)) {
                        if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X' || number.charAt(i + 1) == 'L' || number.charAt(i + 1) == 'C') {
                            finalNumber = finalNumber + 100;
                        } else {
                            finalNumber = finalNumber - 100;
                            if (i > 0 && number.charAt(i - 1) == 'C' && number.charAt(i + 1) != 'C') {
                                throw new IllegalArgumentException("Invalid Roman Numeral");
                            }
                        }
                    } else {
                        finalNumber = finalNumber + 100;
                    }
                    break;
                case 'D':
                    if (number.charAt(i - 1) == 'D') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    } else {
                        if (checkNumber(i, number)) {
                            if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X' || number.charAt(i + 1) == 'L' || number.charAt(i + 1) == 'C' || number.charAt(i + 1) == 'D') {
                                finalNumber = finalNumber + 500;
                            } else
                                finalNumber = finalNumber - 500;
                        } else {
                            finalNumber = finalNumber + 500;
                        }
                    }
                    break;
                case 'M':
                    if (i > 2 && number.charAt(i - 3) == 'M' && number.charAt(i - 2) == 'M' && number.charAt(i - 1) == 'M') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    if (checkNumber(i, number)) {
                        if (number.charAt(i + 1) == 'I' || number.charAt(i + 1) == 'V' || number.charAt(i + 1) == 'X' || number.charAt(i + 1) == 'L' || number.charAt(i + 1) == 'C' || number.charAt(i + 1) == 'D' || number.charAt(i + 1) == 'M') {
                            finalNumber = finalNumber + 1000;
                        } else {
                            finalNumber = finalNumber - 1000;
                        }
                        if (i > 0 && number.charAt(i - 1) == 'M' && number.charAt(i + 1) != 'M') {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        }

                    } else {
                        finalNumber = finalNumber + 1000;
                    }
                    break;
                default:
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
        String roman = "";
        String[] romanChars = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] romanVals = {1000,900,500,400,100,90,40,10,9,5,4,1};
        int i=0;
        while (number > 0) {
            while(number >= romanVals[i]){
                number = number - romanVals[i];
                roman = roman + romanChars[i];
            }
            i++;
        }
        if (roman.isEmpty()) {
            return
                    "0";
        }

        return roman;
    }

}