package algorithmWithLeetcode.b.string;

/**
 * 1. substring, get cur ascii code,
 * 2. change code to int number
 * 3. (char) num, get corresponding char
 */
public class ASCIIToChar {
    public static void main(String[] args) {
        String asciiStr = "656667";
        for (int i = asciiStr.length(); i >= 2; i-= 2){
            String asciiCode = asciiStr.substring(i-2,i);
            int asciiNum = Integer.parseInt(asciiCode);
            char curChar = (char) asciiNum;
            System.out.println("current ascii code  = " + asciiCode + " -- ascii char = " + curChar);
        }
    }
}
