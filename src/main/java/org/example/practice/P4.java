package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class P4 {
    /**
     * [문제 04] 가장 많은 문제를 맞힌 수포자
     * 1번 수포자가 찍는 방식 : 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 ...
     * 2번 수포자가 찍는 방식 : 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5 ...
     * 3번 수포자가 찍는 방식 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 ...
     *
     * 시험은 최대 10,000 문제로 구성
     * 문제의 정답은 1, 2, 3, 4, 5 중 하나
     * 가장 높은 점수를 받은 사람이 여럿이라면 반환 값을 오름차순으로 정렬
     */

    private static int[] solution(int[]answers) {
        // 1. 수포자들의 패턴을 미리 저장
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 2. 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];

        // 3. 수포자 패턴과 정답 일치 여부 확인
        for (int i=0; i<answers.length; i++) {
            for (int j=0; j<pattern.length; j++) {
                if (answers[i] == pattern[j][i%pattern[j].length]) {
                    scores[j]++;
                } // if
            } // for
        } // for

        // 4. 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 5. 가장 높은 점수를 가진 수포자들의 번호를 찾아 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<scores.length; i++) {
            if (scores[i] == maxScore) { // 미리 선정해둔 maxScore와 같으면 수포자의 번호를 arraylist에 저장
                answer.add(i+1); // index가 0부터 시작이므로 +1
            } // if
        } // for

        return answer.stream().mapToInt(Integer::intValue).toArray();
    } // solution

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }


}