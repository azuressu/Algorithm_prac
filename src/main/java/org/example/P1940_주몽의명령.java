package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽의명령 {

    /**
     * 갑옷을 만들고자 한다.
     * 갑옷을 만드는 재료들은 각각 고유한 번호가 있고, 갑옷은 2개의 재료로 만드는 데 2가지 재료의 고유한 번호를 합쳐서
     * M(1<= M <= 10,000,000)이 되면 갑옷이 만들어진다.
     *
     * N(1<=N<=15,000)개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지 구하는 프로그램을 작성하자.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        int [] A = new int[N];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);  // 정렬이 필요함 !

        int count = 0;
        int i = 0;    // A[0] -> Min
        int j = N-1;  // A[N-1] -> Max

        while(i < j) {
            if (A[i] + A[j] < M) i ++;
            else if (A[i] + A[j] > M) j++;
            else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }


}
