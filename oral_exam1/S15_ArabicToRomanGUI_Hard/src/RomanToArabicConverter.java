/**
 * This class has two static method in it. Thus its a very all in one library for converting Roman to Arabic
 * or back. Both methods in the class are static and can be used without instantiation.
 */
public class RomanToArabicConverter {

    /**
     * This is converting Roman to arabic. To do this it first looks at the character at the front of the
     *
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
     *
     * @param number Arabic number to be converted
     * @return Roman numeral computed
     */
    public static String ArabicConversion(int number) {
        String roman = "";
        while (number > 999) {
            roman = roman + "M";
            number = number - 1000;
        }
        while (number > 899) {
            roman = roman + "CM";
            number = number - 900;
        }
        while (number > 499) {
            roman = roman + "D";
            number = number - 500;
        }
        while (number > 399) {
            roman = roman + "DC";
            number = number - 400;
        }
        while (number > 99) {
            roman = roman + "C";
            number = number - 100;
        }

        while (number > 49) {
            roman = roman + "L";
            number = number - 50;
        }
        while (number > 39) {
            roman = roman + "XL";
            number = number - 40;
        }
        while (number > 9) {
            roman = roman + "X";
            number = number - 10;
        }
        while (number > 4) {
            roman = roman + "V";
            number = number - 5;
        }
        while (number > 3) {
            roman = roman + "IV";
            number = number - 4;
        }
        while (number > 0) {
            roman = roman + "I";
            number = number - 1;
        }
        if (roman.isEmpty()) {
            return
                    "0";
        }
        return roman;
    }
}