package org.example.practice;

import java.util.Arrays;
import java.util.HashSet;

public class P3 {
    /**
     * [문제 03] 두 개 뽑아서 더하기
     * numbers의 길이는 2 이상 100 이하
     * numbers의 모든 수는 0 이상 100 이하
     */

    private static int[] solution(int[]numbers) {
        // 1. 중복값 제거를 위한 SET
        HashSet<Integer> set = new HashSet<>();
        // 2. 두 수를 선택하는 모든 경우를 반복문으로 구현
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                // 3. 선택한 두 수를 더한 값을 set에 추가
                set.add(numbers[i] + numbers[j]);
            }
        }
        // 4. 해시셋의 값을 오름차순 정렬 후 int 형 배열로 변환 후 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    } // solution

    public static void main(String[] args) {
        int[]numbers = {2,1,3,4,1};
        int[]result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }


}
