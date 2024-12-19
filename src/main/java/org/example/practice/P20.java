package org.example.practice;

import java.util.HashMap;

public class P20 {
    /**
     * [문제 20] 할인 행사
     * XYZ 마트는 일정 금액을 지불하면 10일 동안 회원 자격을 부여
     * 회원 대상으로 매일 1가지 제품을 할인하는 행사를 함
     * 자신이 원하는 수량과 제품이 할인하는 날짜와 10일 연속으로 일치할 때에 맞춰 회원가입을 하려고 함
     * 제약 조건
        * 1 <= want의 길이 = number의 길이 <= 10
            * 1 <= number의 원소 <= 10
            * number[i]는 want[i]의 수량
            * number의 총합은 10
        * 10 <= discount의 길이 <= 100,000
        * want와 discount의 원소들은 알페벳 소문자로 구성된 문자열
            * 1 <= want 원소의 길이 , discount 원소의 길이 <= 12
     */
    private static int solution(String [] want, int [] number, String [] discount) {
        // 1. want, number 배열 값을 해시맵에 저장
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        // 2. 총 일수 변수 초기화
        int answer = 0;

        // 3. 특정일 i에 회원가입 시 할인 받을 수 있는 품목 체크
        for (int i = 0; i< discount.length - 9; i++) { // 10일 연속 구매라 길이에서 -9
            // 4. i일 회원가입 시 할인받은 제품 및 개수를 담을 해시맵
            HashMap<String, Integer> discount10d = new HashMap<>();

            // 5. i일 회원가입 시 할인받는 제품 및 개수로 해시맵 구성
            for (int j=i; j<i+10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }

            // 6. 할인하는 상품의 개수가 원하는 수량과 일치하면 정답 변수에 +1
            if (discount10d.equals(wantMap)) {
                answer++;
            }
        } // for
        return answer;
    }

    public static void main(String[] args) {
        String [] want = {"banana", "apple", "rice", "pork", "pot"};
        int [] number = {3, 2, 2, 2, 1};
        String [] discount = {"chicken", "apple", "apple", "banana", "rice",
                              "apple", "pork", "banana", "pork", "rice", "pot",
                              "banana", "apple", "banana"};
        int result = solution(want, number, discount);
        System.out.println("result : " + result);
    }
}
