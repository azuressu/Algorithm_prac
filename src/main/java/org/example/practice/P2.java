package org.example.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class P2 {
    /**
     * [문제02] 배열 제어하기
     * 배열 길이는 2이상 1,000 이하
     * 각 배열의 데이터 값은 -100,000 이상 100,000 이하
     */

    private static int[] solution1(int[]arr) {
        // 1. 중복값 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        // 2. 내림차순 정렬
        Arrays.sort(result, Collections.reverseOrder());
        // 3. int 배열로 변환 후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    } // solution1

    private static int[] solution2(int[]arr) {
        // 1. 중복값 제거, 내림차순 정렬
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int number : arr) {
            set.add(number);
        } // for

        // 2. int 배열에 담아서 반환
        int[] result = new int[set.size()];

        for(int i = 0; i<result.length; i++) {
            result[i] = set.pollFirst();
        }

        return result;
    } // solution2

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 1, 3, 4};
        int[] org = solution1(arr);
        System.out.println(Arrays.toString(org));
    }
}
