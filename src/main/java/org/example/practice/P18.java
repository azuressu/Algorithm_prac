package org.example.practice;

import java.util.HashSet;

public class P18 {
    /**
     * [문제 18] 두 개의 수로 특정값 만들기
     * n개의 양의 정수로 이루어진 배열 arr와 정수 target이 주어졌을때 이 중에서 합이 target인 두 수가
     * arr에 있는지 찾고, 있으면 true 없으면 false를 반환하는 solution 함수 만들기
     */

    private static boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            // 1. target에서 현재 원소를 뺀 값이 헤시셋에 있는지 확인
            if (hashSet.contains(target-i)) {
                return true;
            }
            // 2. 해시셋 현재 값 저장
            hashSet.add(i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8};
        int target = 6;
        boolean result = solution(arr, target);
        System.out.println("result: " + result);
    }
}
