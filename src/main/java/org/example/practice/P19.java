package org.example.practice;

import java.util.HashMap;

public class P19 {
    /**
     * [문제 19] 완주하지 못한 선수
     * 많은 선수 중 단 한 명의 선수를 제외하고 모든 선수가 마라톤을 완주
     * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 completion에서
     * 완주하지 못한 선수의 이름을 반환하는 함수 작성
     * 제약 조건
         * 마라톤 경기에 참여한 선수 수는 1명 이상 100,000명 이하
         * completion 길이는 participant 길이보다 1 작음
         * 참가자 이름은 1개 이상 20개 이하의 알파벳 소문자로 구성
         * 참가자 중에는 동명이인 존재 가능
     */

    private static String solution(String[] participant, String[] completion) {
        // 1. 해시맵 생성
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 2. 완주한 선수들의 이름을 해시맵에 저장
        for (String name : completion) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }

        // 3. 참가한 선수들의 이름을 키로 하는 값을 찾는다면 1씩 감소
        for (String name : participant) {
            // 4. 완주하지 못한 선수를 찾으면 반환
            if (hashMap.getOrDefault(name, 0) == 0) {
                return name;
            }
            hashMap.put(name, hashMap.get(name) - 1);
        }
        return null;
    }

    public static void main(String[] args) {
        String [] participant = {"leo", "kiki", "eden"};
        String [] completion = {"eden", "kiki"};
        String result = solution(participant, completion);
        System.out.println("result : " + result);
    }
}
