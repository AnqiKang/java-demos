package codeTest.aTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 6, 2, 4, 6, 3));
        quickSort(list, 0, list.size() - 1);
        System.out.println(list);

    }

    private static void quickSort(List<Integer> list, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = list.get((left + right) / 2);

        while (left <= right) {
            while (left <= right && list.get(left) < pivot) {
                left++;
            }
            while (left <= right && list.get(right) > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
            }
        }

        quickSort(list, start, right);
        quickSort(list, left, end);
    }
}
