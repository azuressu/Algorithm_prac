package org.example.practice;

import java.util.Stack;

public class P9 {
    /**
     * [문제 09] 10진수를 2진수로 변환
     * 10진수를 입력받아 2진수로 변환해 반환하는 함수 작성
     */

    private static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while(decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    } // solution

    public static void main(String[] args) {
        int decimal = 10;
        String result = solution(decimal);
        System.out.println("result : " + result);
    }
}
