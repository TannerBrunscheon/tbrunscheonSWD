/**
 * Created by Tanner on 9/19/2016.
 */
public class ArabicConverter {
    private int number;
    private String roman = "";

    public ArabicConverter(int number) {
        this.number = number;
    }

    public void Conversion() {
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

    }


    @Override
    public String toString() {
        Conversion();
        return  "Final Number = " + roman;
    }
}
