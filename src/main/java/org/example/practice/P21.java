package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P21 {
    /**
     * [문제 21] 오픈 채팅방
     * 채팅방에 들어오고 나가거나 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때
     * 모든 기록이 처리된 다음 최종으로 방을 개설한 사람이 보는 메세지를 문자열 배열 형태로 반환하는 함수 생성
     * 제약 조건
        * record는 다음과 같은 문자열이 담긴 배열이며 길이는 1이상 100,000 이하
            * 모든 유저는 [유저 아이디]로 구분
            * [유저 아이디] 사용자가 [닉네임]으로 채팅방에 입/퇴장/변경 (Enter / Leave / Change)
            * 각 단어는 공백으로 구분, 알파벳 대문자 소문자 숫자로만 구성
            * 유저 아이디와 닉네임은 알파벳 대소문자를 구별
            * 유저 아이디와 닉네임의 길이는 1 이상 10 이하
            * 채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못된 입력은 X
     */
    private static String[] solution(String[]record) {
        // Enter/Leave 메세지 저장 해시맵
        HashMap<String, String> message = new HashMap<>();
        message.put("Enter", "님이 들어왔습니다");
        message.put("Leave", "님이 나갔습니다");

        HashMap<String, String> uid = new HashMap<>();
        // 1. record의 각 줄을 하나씩 처리
        for (String s : record) {
            // 공백 기준으로 문자열 분리
            String[] cmd = s.split(" ");
            // 2. Enter 혹은 Change인 경우
            if (cmd.length == 3) {
                uid.put(cmd[1], cmd[2]);
            }
        }

        // 답을 저장할 answer list 생성
        ArrayList<String> answer = new ArrayList<>();
        // 3. record의 각 줄을 하나씩 처리
        for (String s : record) {
            String[] cmd = s.split(" ");
            // 4. 각 상태에 맞는 메세지를 answer에 저장
            if (message.containsKey(cmd[0])) {
                answer.add(uid.get(cmd[1]) + message.get(cmd[0]));
            }
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                            "Leave uid1234", "Enter uid1234 Prodo",
                            "Change uid4567 Ryan"};
        String [] result = {"Prodo님이 들어왔습니다", "Ryan님이 들어왔습니다",
                            "Prodo님이 나갔습니다", "Prodo님이 들어왔습니다"};

        String [] solutionResult = solution(record);
        System.out.println(Arrays.equals(result, solutionResult));
    }
}
