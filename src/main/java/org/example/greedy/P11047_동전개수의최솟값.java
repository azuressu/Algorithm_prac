package org.example.greedy;

import java.util.Scanner;

public class P11047_동전개수의최솟값 {

    /**
     * 준규가 소유하고 있는 동전은 총 N종류이고, 각 동전의 개수가 많다.
     * 동전을 적절히 사용해 그 가격의 합을 K로 만들고자 할 때, 필요한 동전 개수의 최솟값을 구하는 프로그램 작성
     *
     * K원을 만드는 데 필요한 동전 개수의 최솟값
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int A[] = new int[N];

        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        // 그리디 알고리즘 -> 큰 동전부터 사용하기
        int count = 0;
        for (int i=N-1; i>=0; i--) {
            if (A[i] <= K) {
                count += (K/A[i]); // 몫 - 해당 동전을 사용하는 것 (그 동전 몇개쓸건데?)
                K = K % A[i];      // 나머지
            }
        }

        System.out.println(count);

    }


}
