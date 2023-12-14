package org.example;

import java.util.Scanner;
import java.util.Stack;

public class P1874_오름차순수열 {

    /**
     * 1번째 줄에 수열의 개수 (1 <= n <= 100,000)
     * 2번째 줄에 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 1개씩 순서대로 주어짐
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num=1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i=0; i<A.length; i++) {
            int su = A[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++); // 값을 삽입
                    bf.append("+\n");
                }
                stack.pop(); // 값을 삭제 후 확인
                bf.append("-\n");
            } else {
                int n = stack.pop(); // 값을 삭제 후 확인
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        } // for

        if (result) System.out.println(bf.toString());

    }



}
