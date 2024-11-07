package org.example.practice;

import java.util.Stack;

public class P11 {
    /**
     * [문제 11] 짝지어 제거
     * 알파벳 소문자로 구성된 문자열 s에서 같은 알파벳이 붙어 있는 짝을 찾음
     * 짝을 찾은 다음에는 그 둘을 제거한 후 앞두로 문자열을 이어 붙임
     * 과정을 반복하며 문자열을 모두 제거한다면 짝지어 제거하기가 종료됨
     * 성공적으로 수행가능하다면 1을, 아니면 0을 반환
     */

    private static int solution1(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);

            if (stack.isEmpty() || !stack.peek().equals(c)) {
                stack.push(c);
            } else {
                if (stack.peek().equals(c)) {
                    stack.pop();
                }
            }
        } // for
        return stack.isEmpty() ? 1 : 0;
    }

    private static int solution2(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "cdcd";
        int result = solution2(s);
        System.out.println("result: " + result);
    }
}
