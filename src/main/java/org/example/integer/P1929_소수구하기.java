package org.example.integer;

import java.util.Scanner;

public class P1929_소수구하기 {
    /**
     * M이상 N이하의 소수를 모두 출력하는 프로그램
     *
     * 에라토스테네스 방법으로 문제를 풀어야 시간을 맞출 수 있음
     *
     * N 제곱근까지만 탐색하는 이유?
     * N이 a*b라고 가정했을 때, a와 b모두 N 제곱근보다 클 수 없음
     * 따라서 N 제곱근까지만 확인해도 전체 범위의 소수를 판별할 수 있음
     * 만약 16의 범위까지 소수를 구할 때 16=4*4로 이루어지면 16보다 작은 숫자는 항상 4보다 작은 약수를 갖게 된다는 뜻
     * 따라서 4까지만 확인하고 소수 판별을 진행하면 됨
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();


        int A[] = new int[N+1];

        for (int i=1; i<N; i++) {
            A[i] = i;         // 각 인덱스값으로 초기화함
        }

        // N의 제곱근까지 반복
        for (int i=2; i<=Math.sqrt(N); i++) {
            if (A[i] == 0) continue;  // 0이며 넘어감
            for (int j=i+i; j<=N; j=j+i) {
                A[j] = 0;
            }
        }

        for (int i=M; i<=N; i++) {
            if (A[i]!=0) System.out.println(A[i]);
        }


    } // main



}
