package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164_카드게임 {

    /**
     * N장의 카드. 카드는 차례로 1-N 의 번호가 붙어있고 1번이 가장 위, N번이 가장 아래에 위치
     * 가장 위에 있는 카드를 버리면 그 다음 가장 위에 있는 카드를 가장 아래에 있는 카드 밑으로 옮김
     * 1, 2, 3, 4 일 때. 1을 버리면 2, 3, 4가 남고 2가 밑으로 가면 3, 4, 2
     * 그리고 3을 다시 버리고 4를 밑으로 옮기면 2, 4 다시 2를 버리면 4만 남음
     *
     * 1번째 줄에 정수 N(1<=N<=500,000)이 주어짐
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();

        int N = sc.nextInt();
        for (int i=1; i<=N; i++) {
            myQueue.add(i);
        }

        while(myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }

        System.out.println(myQueue.poll());

    }


}
