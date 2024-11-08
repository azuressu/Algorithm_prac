package org.example.practice;

import java.util.Arrays;
import java.util.Stack;

public class P12 {
    /**
     * [문제 12] 주식 가격
     * 초 단위로 기록된 주식 가격이 담긴 배열 prices가 매개변수로 주어질 때,
     * 가격이 떨어지지 않은 기간은 몇 초 인지를 반환하도록 하는 함수 작성
     * prices의 각 가격은 1 이상 10,000 이하인 자연수
     * prices의 길이는 2 이상 100,000 이하
     */
    private static int[] solution(int[] prices) {
        // 1. 가격이 떨어지지 않을 기간을 저장할 배열
        int n = prices.length;
        int[] answer = new int[n];

        // 2. 스택을 사용해 이전 가격과 현재 가격 비교
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 제일 처음 "인덱스 번호"를 push

        for (int i=1; i<n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                // 3. 가격이 떨어졌으므로 이전 가격의 기간 계산
                int j = stack.pop();
                answer[j] = i-j;
            }
            stack.push(i);
        }

        // 4. 스택에 남아 있는 가격들은 가격이 떨어지지 않은 경우
        while(!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j; // 전체 기간에서 (j+1) 값을 제외하여 기간 계산
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] prices = {1, 2, 3, 2, 3};
        int [] answer = solution(prices);
        System.out.println("answer : " + Arrays.toString(answer));
    }
}
