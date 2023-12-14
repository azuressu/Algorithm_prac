package org.example.datastructure;

import java.util.*;

public class P1546_평균구하기 {

    /**
     * 점수들 중 최대값을 골라 M이라고 하고, 모든 점수에 대해 M으로 나눈 다음 100을 곱하여 평균을 구하고자 한다.
     * 새로운 평균을 구하는 프로그램을 작성하시오.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 시험을 본 과목의 개수를 입력받는다.
        int N = sc.nextInt();
        // 과목들의 점수를 입력받을 배열을 선언한다. (사용하지 않는 방법도 존재)
        int A[] = new int[N];

        // 위의 선언한 배열에 과목들의 점수를 입력받는다.
        /*for (int i=0; i<N; i++) { // 향상된 for문을 사용하면 왜 값이 NaN이 나올까?
            A[i] = sc.nextInt();
        }*/

        long sum = 0; // 과목 점수의 합계
        long max = 0; // 과목 점수들 중 최대값

        // 반복문을 돌려 최대값과 합계를 구한다.
        /*for (int a: A) {
            if (a > max) max = a;
            sum += a;
        }*/

        // 반복문을 돌려 점수를 입력받고, 최대값을 판별하고, 합계를 구한다.
        // 반복문을 한 번만 돌려서 구할 수도 있다.
        for (int i=0; i<N; i++) {
            int temp = sc.nextInt();
            if (temp > max) max = temp;
            sum += temp;
        }

        // 평균을 구한다.
        // 예를 들어 과목이 3개라면
        // (A/M*100) + (B/M*100) + (C/M*100) / 3 = (A+B+C) * 100 / M / 3
        // 다시 말해 (점수들의 총합) * 100 / (최대값) / (과목의 개수) 로 계산할 수 있다.
        System.out.println(sum * 100.0 / max / N); // 100.0으로 하면 자동으로 double 형태로 계산
    }
}
