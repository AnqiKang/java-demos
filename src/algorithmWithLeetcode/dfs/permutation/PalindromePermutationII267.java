package algorithmWithLeetcode.dfs.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePermutationII267 {
    public static void main(String[] args) {
        String s = "aabb";
        generatePalindromes(s);

    }

    // 会超时
    public static List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 1){
            return res;
        }

        boolean[] visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        dfs(chars, res, visited, new StringBuilder());
        return res;

    }

    private static void dfs(char[] chars, List<String> res, boolean[] visited, StringBuilder sb){
        if(sb.length() == chars.length && isPalindrome(sb.toString())){
            res.add(sb.toString());
            return;
        }

        for(int i = 0; i < chars.length; i++){
            if(visited[i]){
                continue;
            }

            if(i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]){
                continue;
            }

            sb.append(chars[i]);
            visited[i] = true;
            dfs(chars, res, visited, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }

    private static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while(left <= right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
