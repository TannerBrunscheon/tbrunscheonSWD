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
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I')
                        {
                            finalNumber = finalNumber+1;
                        }
                        else
                            finalNumber = finalNumber-1;
                    }
                    else
                    {
                        finalNumber = finalNumber+1;
                    }
                    break;
                case 'V':
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V')
                        {
                            finalNumber = finalNumber+5;
                        }
                        else
                            finalNumber = finalNumber-5;
                    }
                    else
                    {
                        finalNumber = finalNumber+5;
                    }
                    break;
                case 'X':
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V'|| number.charAt(i+1) == 'X')
                        {
                            finalNumber = finalNumber+10;
                        }
                        else
                            finalNumber = finalNumber-10;
                    }
                    else
                    {
                        finalNumber = finalNumber+10;
                    }
                    break;

                case 'L':
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V'|| number.charAt(i+1) == 'X'|| number.charAt(i+1) == 'L')
                        {
                            finalNumber = finalNumber+50;
                        }
                        else
                            finalNumber = finalNumber-50;
                    }
                    else
                    {
                        finalNumber = finalNumber+50;
                    }
                    break;
                case 'C':
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V'|| number.charAt(i+1) == 'X'|| number.charAt(i+1) == 'L'|| number.charAt(i+1) == 'C')
                        {
                            finalNumber = finalNumber+100;
                        }
                        else
                            finalNumber = finalNumber-100;
                    }
                    else
                    {
                        finalNumber = finalNumber+100;
                    }
                    break;
                case 'D':
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V'|| number.charAt(i+1) == 'X'|| number.charAt(i+1) == 'L'|| number.charAt(i+1) == 'C'|| number.charAt(i+1) == 'D')
                        {
                            finalNumber = finalNumber+500;
                        }
                        else
                            finalNumber = finalNumber-500;
                    }
                    else
                    {
                        finalNumber = finalNumber+500;
                    }
                    break;
                case 'M':
                    if (checkNumber(i))
                    {
                        if (number.charAt(i+1) == 'I'|| number.charAt(i+1) == 'V'|| number.charAt(i+1) == 'X'|| number.charAt(i+1) == 'L'|| number.charAt(i+1) == 'C'|| number.charAt(i+1) == 'D' || number.charAt(i+1) == 'M')
                        {
                            finalNumber = finalNumber+1000;
                        }
                        else
                            finalNumber = finalNumber-1000;
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
        return "RomanConverter{" +
                "finalNumber=" + finalNumber +
                '}';
    }
}
