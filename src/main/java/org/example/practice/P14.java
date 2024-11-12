package org.example.practice;

import java.util.Arrays;
import java.util.Stack;

public class P14 {
    /**
     * [문제 14] 표 편집
     * 명령어 기반으로 표의 행을 선택, 삭제, 복구하는 프로그램을 작성
     * 제약 조건
        * 5 <= n <= 1,000,000
        * 0 <= k < n
        * 1 <= cmd의 원소 개수 <= 200,000
            * cmd의 각 원소는 "U X", "D X", "C", "Z" 중 하나
            * X는 1 이상 300,000 이하의 자연수이며 0으로 시작하지 않음
            * X가 나타나는 자연수에 쉼표는 없음
        * 표의 범위를 벗어나는 이동은 입력으로 주어지지 않음
     */

    private static String solution(int n, int k, String[] cmd) {
        // 1. 삭제된 행의 "인덱스"를 저장하는 스택
        Stack<Integer> deleted = new Stack<>();
        // 2. 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열 (n+2칸으로 생성)
        int[] up = new int[n+2];
        int[] down = new int[n+2];

        for (int i=0; i<n+2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        // 3. 현재 위치를 나타내는 인덱스 값
        k++;

        // 4. 주어진 명령어(cmd) 배열을 처리하는 반복문
        for (String c : cmd) {
            // 5. 현재 위치를 삭제하고 그 다음 위치로 이동
            if (c.startsWith("C")) {
                // 삭제할 인덱스 값 stack에 push
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            // 6. 가장 최근에 삭제된 행을 복원
            } else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            // 7. U 혹은 D를 사용해 현재 위치를 위, 아래로 이동
            } else {
                // 공백을 기준으로 문자열 배열 생성
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    // 만약 U로 시작한다면 up, 그렇지 않으면(D로 시작한다면) down
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        } // for

        // 8. 삭제된 행의 위치에 'X'를 그렇지 않으면 'O'를 저장한 문자열 반환
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int i : deleted) {
            answer[i-1] = 'X';
        }

        return new String(answer);
    }

    public static void main(String[] args) {
        String[] cmd1 = {"D 2", "C", "U 3", "D 4", "C", "U 2", "Z", "Z"};
        String answer = solution(8, 2, cmd1);

        System.out.println(answer);
    }
}
