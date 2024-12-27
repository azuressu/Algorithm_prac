package org.example.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P23 {
    /**
     * [문제 23] 신고 결과 받기
     * 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템 개발
     * 제약 조건
        * 2 <= id_list의 길이 <= 1,000
            * 1 <= id_list의 원소 길이 <= 10
            * id_list의 원소는 이용자의 id를 나타내는 문자열, 알파벳 소문자로만 구성
            * id_list에는 같은 아이디가 중복해 들어있지 않음
        * 1 <= report의 길이 <= 200,000
            * 3 <= report의 원소 길이 <= 21
            * report의 원소는 "이용자 ID 신고한 ID" 형태의 문자열
            * id는 알파벳 소문자로만 구성
            * 이용자 ID와 신고한 ID는 공백 하나로 구분, 자기 자신을 신고하는 경우 X
        * 1 <= k <= 200, k 는 자연수
        * 반환하는 배열은 id_list에 담긴 ID 순서대로 각 유저가 받은 결과 메일 수를 담으면 됨
     */

    private static int[] solution(String[] id_list, String[] report, int k) {
        // 신고당한 유저 - 신고 유저 집합을 저장할 해시맵
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        // 처리 결과 메일을 받은 유저 - 받은 횟수를 저장할 해시맵
        HashMap<String, Integer> count = new HashMap<>();

        // 1. 신고 기록 순회하기
        for (String r: report) {
            String [] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            // 2. 신고당한 기록이 없다면
            if (!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }
            // 3. 신고한 사람의 아이디를 해시맵의 value인 해시셋에 추가
            reportedUser.get(reportedId).add(userId);
        }

        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            // 4. 정지 기준에 만족하는지 확인
            if (entry.getValue().size() >= k) {
                // 5. 해시셋을 순회하며 count 계산
                for (String uid : entry.getValue()) {
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }

        int [] answer = new int[id_list.length];

        // 6. 각 아이디별 메일을 받은 횟수를 순서대로 정리
        for (int i=0; i<id_list.length; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }

        return answer;
    }


    public static void main(String[] args) {
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int [] result = solution(id_list, report, k);
        System.out.println("result : " + Arrays.toString(result));
    }
}
