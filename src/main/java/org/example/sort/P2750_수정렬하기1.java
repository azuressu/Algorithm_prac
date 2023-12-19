package org.example.sort;

import java.util.Scanner;

public class P2750_수정렬하기1 {

    /**
     * N개의 수가 주어졌을 때, 이를오름차순 정렬하는 프로그램 작성
     * 1 번째 줄에 수의 개수 N(1<=N<=1,000), 2 번째 줄부터 N개의 줄에 숫자가 주어짐
     * 이 수는 절대값이 1,000보다 작거나 같은 정수이며 수는 중복되지 않음
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] A = new int[N];

        // 정렬되지 않은 데이터를 받음
        for (int k = 0; k < N; k++) {
            A[k] = sc.nextInt();
        }

        // 버블 정렬 구현 시작
        for (int i=0; i<N-1; i++) {         // 실제 배열 크기보다 하나 작게 범위를 설정해야 오른쪽 값과 비교 가능
            for (int j=0; j<N-1-i; j++) {
                if (A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            System.out.println(A[k]);
        }
    }
}
