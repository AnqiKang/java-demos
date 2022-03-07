package codeTest.OA.apple;

import java.util.List;

public class DayOfTheWeek {
    public static void main(String[] args) {
        List<String> days = List.of("Mon", "Tue", "Wed", "Thu", "Fir", "Sat", "Sun");
        String s = "Sat";
        int k = 23;
        String res = findKDaysLater(days, s, k);
        System.out.println(res);
    }


    private static String findKDaysLater(List<String> days, String s, int k) {
        if (k == 0) {
            return s;
        }

        // list.indexOf():  得到 element 的 index
        int numOfWeek = days.indexOf(s);
        // 当前位置 + k天之后 就是结果，避免重复搜索 7天一个轮回
        return days.get((numOfWeek + k) % 7);
    }


}
