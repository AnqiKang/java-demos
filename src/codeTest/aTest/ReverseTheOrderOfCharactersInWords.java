package codeTest.aTest;

/**
 * 翻转每一个单词的字母顺序
 * Input: "Let's go for a walk.”
 * Output: "s'teL og rof a .klaw"
 */
public class ReverseTheOrderOfCharactersInWords {
    public static void main(String[] args) {
        String input = "Let's go for a walk.";
        String output = reverse(input);
        System.out.println(output);
    }

    private static String reverse(String input) {
        if (input == null || input.length() < 1) {
            return "";
        }
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            for (int i = word.length() - 1; i >= 0; i--) {
                sb.append(word.charAt(i));
            }
            words[j] = sb.toString();
            sb.setLength(0);

        }


        return String.join(" ", words);
    }
}
