package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P12891_DNA비밀번호  {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int Result = 0;
        myArr = new int[4];      // 비밀번호를 확인할 배열
        checkArr = new int [4];  // 현재 상태의 배열

        char A[] = new char[S];
        checkSecret = 0; // 찾아낸 비밀번호의 개수

        A = br.readLine().toCharArray(); // 입력받은 문자열을 배열로
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                // 해당 체크 문자가 0이라면 (필요없는 문자라는 의미)
                checkSecret++;
            }
        }

        for(int i=0; i<P; i++) {  // 부분 문자열 처음 받을 때의 세팅
            Add(A[i]); // 전체 주어진 배열의 첫 번째 값을 넣어준다는 의미
        }

        if (checkSecret == 4) Result++;

        // 슬라이딩 윈도우 (슬라이딩부터 처리함)
        for (int i=P; i<S; i++) {
            int j = i-P; // j가 맨 왼쪽, i가 맨 오른쪽 (범위의 처음과 끝임)
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) Result++;
        }

        System.out.println(Result);
        br.close();

    }

    private static void Remove(char c) {
        switch(c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;

        }


    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++; // 딱 맞을 때만 값을 올려줌
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++; // 딱 맞을 때만 값을 올려줌
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++; // 딱 맞을 때만 값을 올려줌
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++; // 딱 맞을 때만 값을 올려줌
                break;
        }
    }
}
