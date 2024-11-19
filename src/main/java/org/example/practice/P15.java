package org.example.practice;

import java.util.ArrayDeque;

public class P15 {
    /**
     * [문제 15] 요세푸스 문제
     * N명의 사람이 원 형태로 서 있고, 각 사람은 1부터 N까지 번호표를 소지하고 있음
     * 임의의 숫자 K가 주어졌을 때, 다음과 같이 사람을 소거
        * 1번 번호표를 가진 사람을 기준으로 K번째 사람을 소거
        * 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 소거
     */

    private static int solution(int n, int k) {
        // 1. 1부터 N까지의 번호를 deque에 추가 (사람 번호를 deque에 추가)
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=n; i++) {
            deque.addLast(i);
        }

        // 2. deque에 하나의 요소가 남을 때 까지 반복 (마지막에 남은 사람의 번호를 알기 위해)
        while (deque.size() > 1) {
            // 3. K번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가 (K번째 사람의 번호를 제거해야 하기 때문)
            for (int i=0; i<k-1; i++) {
                deque.addLast(deque.pollFirst());
            }
            // 4. K번째 요소 제거
            deque.pollFirst();
        }

        // 5. 마지막으로 남은 사람의 번호 반환
        return deque.pollFirst();
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        int answer = solution(n, k);
        System.out.println("answer : " + answer);
    }
}
