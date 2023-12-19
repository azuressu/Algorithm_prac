package org.example.sort;

import java.util.Scanner;

public class P1427_내림차순자릿수정렬 {

    /**
     * 1번째 줄에 정렬할 수 N이 주어진다. N은 1,000,000,000 보다 작거나 같은 자연수이다.
     * 1번째 줄에 자릿수를 내림차순 정렬한 수 출력
     *
     * 예) 2143 -> 4321
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int A[] = new int[str.length()];

        for (int i=0; i<str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        // 선택 정렬
        for (int i=0; i<str.length(); i++) {
            int Max = i;
            for (int j=i+1; j<str.length(); j++) {
                if (A[j] > A[Max]) Max = j;
            }

            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }

        for (int k=0; k<str.length(); k++){
            System.out.print(A[k]);
        }
    }


}
