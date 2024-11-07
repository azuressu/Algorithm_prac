package org.example.practice;

import java.util.ArrayDeque;
import java.util.HashMap;

public class P10 {
    /**
     * [문제 10] 괄호 회전하기
     * 대괄호, 중괄호 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어짐
     * 이 s를 왼쪽으로 x만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 반환하는 함수 작성
     * x는 0보다 크거나 같고, s의 길이보다 작거나 같음 (0 <= x <= s의 길이)
     */

    private static int solution(String s) {
        // 1. 괄호의 정보를 저장
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        int n = s.length();
        s += s;
        int answer = 0;

        // 2. 확인할 문자열의 시작 인덱스를 0부터 n까지 이동
        A:for (int i=0; i<n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // 3. 시작 위치에서 원본 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확ㅇ니
            for (int j=i; j<i+n; j++) {
                char c = s.charAt(j);
                // 해시맵 안에 해당 키가 없다면
                if (!map.containsKey(c)) {
                    stack.push(c);
                }
                else {
                    // 4. 스택이 비어있거나 짝이 맞지 않으면 내부 for문 종료 후 초기 for문으로 이동
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                } // else
            } // for
            // 5. 3에서 continue되지 않았고, 스택이 비어있다면 올바른 괄호 문자열이므로 answer값 +1
            if (stack.isEmpty()) {
                answer ++;
            }
        } // for A

        return answer;
    } // solution

    public static void main(String[] args) {
        String s = "[](){}";
        int answer = solution(s);
        System.out.println("answer : " + answer);
    }
}
