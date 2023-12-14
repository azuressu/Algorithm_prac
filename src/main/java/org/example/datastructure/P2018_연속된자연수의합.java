package org.example.datastructure;

import java.util.Scanner;

public class P2018_연속된자연수의합 {

    /**
     * 어떤 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
     * 당신은 어떤 자연수 N(1<=N<=10,000,000)을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다.
     * 이 때 사용하는 자연수는 N이어ㅑ 한다.
     * 예를 들어 15을 나타내는 방법에는 15, 7+8, 4+5+6, 1+2+3+4+5 가 있다.
     * 반면, 10을 나타내는 방법에는 10, 1+2+3+4 가 있다.
     * N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하자.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            if (sum == N) {
                count ++;
                end_index++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index; // sum을 먼저 변경해주어야 함
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);


    }

}
