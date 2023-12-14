package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11286_절대값힙구현 {

    /**
     * 절대값 힙은 다음과 같은 연산을 하는 자료구조
     * 배열에 정수 X(X!=0)
     * 배열에서 절댓값이 가장 작은 값을 출력한 후, 그 값을 배열에서 제거
     * 절대값이 가장 작은 값이 여러 개일 경우 그 중 가장 작은 수를 출력하고 그 값을 배열에서 제거
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs) {  // 절대값이 같은 경우에는 음수가 우선
                // o1이 o2보다 크다면 1, 아니라면 -1을 리턴
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs;  // 절대값이 작은 데이터가 우선
        });

        for (int i=0; i<N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (myQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(request); // 아닌 경우라면 우선순위 큐에 데이터를 삽입하면 됨
            }
        }
    }


}
