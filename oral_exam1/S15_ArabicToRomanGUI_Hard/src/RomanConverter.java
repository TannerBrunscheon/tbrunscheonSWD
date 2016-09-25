import sun.plugin2.message.Conversation;

/**
 * Created by Tanner on 9/19/2016.
 */
public class RomanConverter {
    private String number;
    private int finalNumber = 0;

    public RomanConverter(String number) {
        this.number = number;
    }

    private void Conversion(){
        for (int i =0;i<number.length();i++) {
            switch (number.charAt(i)){
                case 'I':
                    if(i>2 && number.charAt(i-3) =='I'&& number.charAt(i-2) =='I'&& number.charAt(i-1) =='I')
                    {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    else if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I')
                        {
                            finalNumber = finalNumber+1;
                        }
                        else {
                            if (i > 0 && number.charAt(i - 1) == 'I' && number.charAt(i + 1) != 'I') {
                                throw new IllegalArgumentException("Invalid Roman Numeral");
                            }
                            finalNumber = finalNumber - 1;
                        }

                    }
                    else
                    {
                        finalNumber = finalNumber+1;
                    }
                    break;
                case 'V':
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1)=='V')
                        {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        }
                        else
                        {
                            if (number.charAt(i + 1) == 'I') {
                                finalNumber = finalNumber + 5;
                            } else {
                                finalNumber = finalNumber - 5;
                            }
                        }

                    }
                    else
                    {
                        finalNumber = finalNumber+5;
                    }
                    break;
                case 'X':
                    if (checkNumber(i))
                    {
                        if(i>2 && number.charAt(i-3) =='X'&& number.charAt(i-2) =='X'&& number.charAt(i-1) =='X') {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        }
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V'|| number.charAt(i+1) == 'X')
                        {
                            finalNumber = finalNumber+10;
                        }
                        else
                        {
                            finalNumber = finalNumber-10;
                            if (i>0 && number.charAt(i-1) =='X' && number.charAt(i+1) != 'X' )
                            {
                                throw new IllegalArgumentException("Invalid Roman Numeral");
                            }

                        }
                    }
                    else
                    {
                        finalNumber = finalNumber+10;
                    }
                    break;

                case 'L':
                    if (number.charAt(i-1)=='L')
                    {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    else {
                        if (checkNumber(i)) {
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
                    if(i>2 && number.charAt(i-3) =='C'&& number.charAt(i-2) =='C'&& number.charAt(i-1) =='C') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V'|| number.charAt(i+1) == 'X'|| number.charAt(i+1) == 'L'|| number.charAt(i+1) == 'C')
                        {
                            finalNumber = finalNumber+100;
                        }
                        else {
                            finalNumber = finalNumber - 100;
                            if (i > 0 && number.charAt(i - 1) == 'C' && number.charAt(i + 1) != 'C') {
                                throw new IllegalArgumentException("Invalid Roman Numeral");
                            }
                        }
                    }
                    else
                    {
                        finalNumber = finalNumber+100;
                    }
                    break;
                case 'D':
                    if (number.charAt(i-1)=='D'){
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    else {
                        if (checkNumber(i)) {
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
                    if(i>2 && number.charAt(i-3) =='M'&& number.charAt(i-2) =='M'&& number.charAt(i-1) =='M') {
                        throw new IllegalArgumentException("Invalid Roman Numeral");
                    }
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V'|| number.charAt(i+1) == 'X'|| number.charAt(i+1) == 'L'|| number.charAt(i+1) == 'C'|| number.charAt(i+1) == 'D' || number.charAt(i+1) == 'M')
                        {
                            finalNumber = finalNumber+1000;
                        }
                        else {
                            finalNumber = finalNumber - 1000;
                        }
                        if (i > 0 && number.charAt(i - 1) == 'M' && number.charAt(i + 1) != 'M') {
                            throw new IllegalArgumentException("Invalid Roman Numeral");
                        }

                    }
                    else
                    {
                        finalNumber = finalNumber+1000;
                    }
                    break;
            }
        }
    }

    private boolean checkNumber(int i){
        if (i+1 < number.length())
        {
            return true;
        }
        return false;
    }

    public String getNumber() {
        Conversion();
        return number;
    }

    @Override
    public String toString() {
        Conversion();
        return "Number = " + finalNumber;

    }
}
