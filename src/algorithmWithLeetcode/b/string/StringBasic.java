package algorithmWithLeetcode.b.string;

public class StringBasic {
    public static void main(String[] args) {
        //合并两个字符串  +
        String firstName = "Karen";
        String lastName = "Kang";
        String fullName = firstName + " " + lastName;
        System.out.println("full name is : " + fullName);

        // 字符串长度 str.length()
        System.out.println("The length of full name : " + fullName.length());

        // 求某一个位置的字符串
        char firstLetter = fullName.charAt(0);
        System.out.println("first letter is :" + firstLetter);

        // 求子串
        String subStr = fullName.substring(6,10);
        System.out.println("sub string : " + subStr);

        // 查找某个子串, 返回该子串第一个字母出现的位置, 找不到返回-1
        int index = fullName.indexOf("lastName");
        System.out.println("index :" + index);

        // 数字转变为字符串
        String intStr = String.valueOf(1234);
        System.out.println("string of a number : "+ intStr);

        // 字符串转变为数字
        int intNum = Integer.parseInt("3");
        float floatNum = Float.parseFloat("3.14");








    }






}
