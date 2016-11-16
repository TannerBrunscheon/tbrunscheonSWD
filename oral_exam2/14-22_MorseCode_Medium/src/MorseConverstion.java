import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tanner on 11/14/2016.
 */
public class MorseConverstion {
    private static HashMap<Character,String> engtoMorMap = new HashMap<>();
    static {
        engtoMorMap.put('A',".-");
        engtoMorMap.put('B',"-..");
        engtoMorMap.put('C',"-.-.");
        engtoMorMap.put('D',"-..");
        engtoMorMap.put('E',".");
        engtoMorMap.put('F',"..-.");
        engtoMorMap.put('G',"--.");
        engtoMorMap.put('H',"....");
        engtoMorMap.put('I',"..");
        engtoMorMap.put('J',".---");
        engtoMorMap.put('K',"-.-");
        engtoMorMap.put('L',".-..");
        engtoMorMap.put('M',"--");
        engtoMorMap.put('N',"-.");
        engtoMorMap.put('O',"---");
        engtoMorMap.put('P',".--.");
        engtoMorMap.put('Q',"--.-");
        engtoMorMap.put('R',".-.");
        engtoMorMap.put('S',"...");
        engtoMorMap.put('T',"-");
        engtoMorMap.put('U',"..-");
        engtoMorMap.put('V',"...-");
        engtoMorMap.put('W',".--");
        engtoMorMap.put('X',"-..-");
        engtoMorMap.put('Y',"-.--");
        engtoMorMap.put('Z',"--..");
        engtoMorMap.put('0',"-----");
        engtoMorMap.put('1',".----");
        engtoMorMap.put('2',"..---");
        engtoMorMap.put('3',"...--");
        engtoMorMap.put('4',"....-");
        engtoMorMap.put('5',".....");
        engtoMorMap.put('6',"-....");
        engtoMorMap.put('7',"--...");
        engtoMorMap.put('8',"---..");
        engtoMorMap.put('9',"----.");
    }
    private static HashMap<String,Character> mortoEngMap = new HashMap<>();
    static {
        for(Character keys : engtoMorMap.keySet()){
            mortoEngMap.put(engtoMorMap.get(keys),keys);
        }
    }
    public static String engtoMorse(String english){
        english = english.toUpperCase();
        StringBuilder morse = new StringBuilder();
        for (int i = 0;i<english.length();i++){
            if (english.charAt(i) == ' '){
                morse.append("   ");
            }
            else if (!engtoMorMap.containsKey(english.charAt(i))){
                throw new IllegalArgumentException("Character not found");
            }
            else
            {
                morse.append(engtoMorMap.get(english.charAt(i))+" ");
            }
        }
        return morse.toString();
    }
    public static String morsetoEng(String morse){
        String[] splitSet =  morse.split("   ");
        String[] inProgressSplit;
        ArrayList<String> splittierSet = new ArrayList<>();
        StringBuilder finalString = new StringBuilder();
        for(int i =0; i<splitSet.length;i++){
            inProgressSplit = splitSet[i].split(" ");
            for(int j = 0; j<inProgressSplit.length;j++){
                splittierSet.add(inProgressSplit[j]);
            }
        }
        for(int i = 0; i < splittierSet.size();i++){
            if (mortoEngMap.get(splittierSet.get(i)) == null){
                finalString.append(" ");
            }
            else {
                finalString.append(mortoEngMap.get(splittierSet.get(i)));
            }

        }
        for(int i = 0; i < finalString.length(); i++){
        }
        return finalString.toString();
    }

}
