package org.example.pgm_prac;

import java.util.Stack;

public class P120853 {

    // 내 풀이
    public static int solution(String s) {
        Stack<String> stack = new Stack<>();
        int answer = 0;
        String[] array = s.split(" ");

        for (String ss: array) {
            if (ss.equals("Z")) {
                answer -= Integer.parseInt(stack.pop());
            } else {
                answer += Integer.parseInt(ss);
                stack.push(ss);
            }
        }
        return answer;
    }

    // 다른 사람들의 풀이
    public static int solution2(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (String w : s.split(" ")) {
            if (w.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(w));
            }
        }
        for (int i : stack) {
            answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        /*      s	      result
           "10 Z 20 Z 1"  	1     */
        String s = "10 Z 20 Z 1";
        int answer = solution(s);
        int answer2 = solution2(s);
        System.out.println("answer : " + answer);
        System.out.println("answer2 : " + answer2);
    }
    
}
