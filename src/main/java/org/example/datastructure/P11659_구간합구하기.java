package org.example.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합구하기 {

    /**
     * 1번째 줄에 수의 개수 N(1<= N <= 100,000), 합을 구해야 하는 횟수 M(1<= M<= 100,000), 2번재 줄에 N개의 수가 주어진다.
     * 각 수는 1,000보다 작거나 같은 자연수이다. 3번째 줄 부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.
     *
     * 총 M개의 줄에 입력으로 주어진 i 번재 수에서 j 번째 수 까지의 합을 출력한다.
     */

    // 문제에서 수와 합을 구해야 하는 횟수가 모두 최대 100,000 이다.
    // 또, 구간마다 합을 매번 계산하면 0.5초 안에 모든 구간 합 계산을 끝낼 수 없다.
    // 이런 경우 구간 합을 이용 !

    public static void main(String[] args) throws IOException {
        // 받는 수가 많을 때는 Scanner 보다 BufferedReader가 빠르다
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        // N개에 해당하는 데이터가 쭉 들어올 것.
        // 들어오는 대로 바로 합 배열을 만들어줌
        long [] S = new long[suNo+1]; // 숫자형 데이터를 다룰 시, 습관적으로 int 보다 long으로 사용하자

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i=1; i <= suNo; i++) { // 0 번째 인덱스는 신경쓰지 않음
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 질의 개수만큼 반복
        for (int q = 0; q<=quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}
