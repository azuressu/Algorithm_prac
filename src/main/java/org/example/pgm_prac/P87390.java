package org.example.pgm_prac;

import java.util.Arrays;

public class P87390 {

    /**
     * n^2 배열 자르기
     * https://school.programmers.co.kr/learn/courses/30/lessons/87390
     */

    /**
     * 잘못 생각한 나의 풀이
     */
    private static int[] solution(int n, long left, long right) {
        int[] answer = new int [(int)(right-left)+1];

        int index = 0;
        int idx = 0;
        boolean isFull = false;

        for (int i=0; i<n; i++) {
            if (isFull) continue;
            for (int j=0; j<n; j++) {
                if (index >= (int)left && index <= (int)right) {
                    int number;
                    if (j > i) {
                        number = (j + 1);
                    } else {
                        number = (i + 1);
                    }
                    answer[idx] = number;
                    idx++;
                    if (idx == (int) right) {
                        isFull = true;
                        continue;
                    }
                }
                index++;
            } // for
        }

        return answer;
    }

    /**
     * 시간 복잡도에 맞는 풀이
     */
    private static int[] solution2(int n, long left, long right) {
        int[] answer = new int [(int)(right-left)+1];

        int index = 0;

        for (long i = left; i<=right; i++) {
            answer[index] = Math.max((int)(i/n), (int)(i%n)) + 1;
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(4,7,14);
        System.out.println(Arrays.toString(answer));
    }
}
