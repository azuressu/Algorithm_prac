package org.example.practice;

import java.util.Arrays;
import java.util.Collections;

public class P1 {
    /**
     * [문제 01] 배열 정렬하기
     * 정수 배열의 길이는 2이상 10^5 이하
     * 정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하
     */

    // 원본도 함께 수정됨
    private static int[] solution1(int[]arr) {
        Arrays.sort(arr);
        return arr;
    } // solution1

    // 원본은 건드리지 않음
    private static int[] solution2(int[]arr) {
        int[] sorting = arr.clone();
        Arrays.sort(sorting);
        return sorting;
    } // solution2

    public static void main(String[] args) {
        int[] org = {4, 2, 3, 1, 5};
        int[] sorted1 = solution1(org);
        int[] sorted2 = solution2(org);
        System.out.println(Arrays.toString(sorted1));
        System.out.println(Arrays.toString(sorted2));
    }
}
