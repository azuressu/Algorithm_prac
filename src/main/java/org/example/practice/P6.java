package org.example.practice;

import java.util.Arrays;
import java.util.HashMap;

public class P6 {

    /**
     * [문제 06] 실패율 구하기
     * 실패율을 구하는 코드 작성
     * 실패율 : 스테이지에 도달하였으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
     * 
     * 제약 조건
        * 스테이지 개수 N은 1이상 500 이하의 자연수
        * 게임을 이용하는 사용자가 현재 멈춰 있는 스테이지의 번호가 담긴 배열 stages의 길이는 1 이상 200,000 이하의 자연수
        * stages에는 1 이상 N+1 이하의 자연수가 존재
            * 각 자연수는 사용자가 현재 도전 중인 스테이지 번호를 명시
            * 단, N+1은 마지막 스테이지, 즉 N까지 클리어한 사용자  
        * 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 우선
        * 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0으로 정의 
     */

    /**
     * 답을 구하는 메서드
     * @param N : 전체 스테이지의 개수
     * @param stages : 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
     * @return : 실패율이 낮은 순서대로 정렬한 배열
     */
    private static int[] solution(int N, int [] stages) {
        // 1. 스테이지 별 도전자 수
        int [] challenger = new int [N+2];
        for (int i=0; i<stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        // 2. 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        System.out.println("total: " + total);

        // 3. 각 스테이지를 순회하며 실패율 계산
        for (int i=1; i<=N; i++) {   // 스테이지는 1단계부터 N단계까지
            if(challenger[i] == 0) { // 스테이지에 도전한 사람이 없는 경우, 실패율 0 삽입
                fails.put(i, 0.);
            } else {
                double failure = challenger[i]/total;
                System.out.println("failure : "+failure);
                fails.put(i, failure); // 실패율을 구하여 삽입
                total -= challenger[i];
                System.out.println("update total : "+total);
            } // else
        } // for

        // 4. 실패율이 높은 스테이지부터 내림차순 정렬 후 반환
        return fails.entrySet().stream().sorted((o1, o2) ->
                Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();

    } // solution

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution(N, stages);
        System.out.println("failure : " + Arrays.toString(result));
    } // main
}
