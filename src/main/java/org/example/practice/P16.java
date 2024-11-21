package org.example.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P16 {
    /**
     * [문제 16] 기능 개발
     * 각 기능은 진도가 100%일 시 서비스에 반영 가능
     * 각 기능의 개발 속도는 모두 다르므로 뒤의 기능이 앞의 기능보다 먼저 개발될 수도 있음
     * 이 때, 뒤의 기능은 앞의 기능이 배포될 때 함께 배포되어야 함
     * 배포는 하루에 한 번만 가능하며 하루의 끝에 이루어진다고 가정
     */

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();

        int n = progresses.length;

        // 1. 각 작업의 배포 가능일 계산
        int[] daysleft = new int[n];
        for (int i=0; i<n; i++) {
            // 전체를 100이라고 했을 때 현재 진행 상황(progresses[i])를 제외하고 작업 속도로 나누면 배포 가능일
            daysleft[i] = (int) Math.ceil((100.0-progresses[i]) / speeds[i]);
        }
        // 2. 배포될 작업의 수 카운트
        int count = 0;
        // 3. 현재 배포될 작업 중 가장 늦게 배포될 작업의 가능일
        int maxDay = daysleft[0];

        for (int i=0; i<n; i++) {
            // 4. 배포 가능일이 가장 늦은 배포일보다 빠르면
            if (daysleft[i] <= maxDay) {
                count++;
            // 5. 배포 예정일이 기존 배포일보다 느리면
            } else {
                answer.add(count);
                count = 1;
                maxDay = daysleft[i];
            }
        } // for

        // 6. 마지막으로 카운트된 작업들을 함께 배포
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = solution(progresses, speeds);

        System.out.println("answer: " + Arrays.toString(answer));
    }
}
