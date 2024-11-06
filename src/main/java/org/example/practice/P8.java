package org.example.practice;

import java.nio.charset.CharsetEncoder;
import java.util.ArrayDeque;
import java.util.Stack;

public class P8 {

    /**
     * [문제 08] 올바른 괄호 짝 판단하기
     * "()()" 또는 "(())()"는 올바른 괄호
     * ")()(" 또는 "(()("는 올바르지 않은 괄호
     * 문자열 s의 길이는 100,000 이하의 자연수 이며 '(' 혹은 ')'로만 이루어짐
     */

    private static boolean solution1(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (c == '(') {
                stack.push('(');
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        boolean result = stack.isEmpty() ? true : false;
        return result;
    }

    private static boolean solution2(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(()(";
        boolean result = solution2(s);
        System.out.println("result: " + result);
    }
}
