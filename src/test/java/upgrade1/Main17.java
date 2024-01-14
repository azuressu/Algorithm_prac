package upgrade1;

import java.io.*;

public class Main17 {

    /* 1316번 문제
        그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
        예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
        단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

        입력
        첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
        둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

        출력
        첫째 줄에 그룹 단어의 개수를 출력한다.*/

    public static void main(String[]args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        // 입력받은 단어의 개수만큼 반복
        for (int i=0; i<N; i++) {
            // 다음 줄의 단어를 매개변수로 넣어줌
            // 해당 메소드에서 true(그룹문자로 판단된 경우)가 반환되면 count 값을 하나 증가시킴
            if (check(br.readLine())) {
                count ++;
            }
        }
        System.out.println(count);*/
    } // main

    static boolean check(String str) {
        // 알파벳 개수만큼 boolean 의 배열 생성
        boolean[] check = new boolean[26];
        // 이전 문자의 인덱스 값
        int prev = -1; // 0도 되나? -> 상관은 없을 듯 !

        // 문자열의 길이만큼 반복문을 돌림
        for(int i = 0; i < str.length(); i++) {
            // 현재는 해당 문자열의 한 글자(알파벳) -> 인덱스 값 으로 설정
            int now = str.charAt(i);

            // 만약, 이전 인덱스 값과 현재 인덱스 값이 다르다면 (같은 경우는 고려하지 않음. 이미 true 임)
            if (prev != now) {
                // check 배열 안의 값이 false 라면
                if (!check[now - 'a']) {
                    // 해당 인덱스에 해당하는 boolean 배열 값을 true로 설정하고,
                    check[now - 'a'] = true;
                    // prev 값을 now로 변경
                    prev = now;
                } // true 라면 (이미 해당 알파벳이 배열에 true로 찍혀있다면) false를 return 하게 됨 -> 왜냐면 그룹 단어가 아니라서
                else {
                    return false;
                }
            }
        }
        // 문자열의 길이만큼 반복문을 다 돌고 그룹 문자로 판단되었다면 true를 return
        return true;
    }


    // 다른 메소드 생성하지 않고 하나의 main 메소드 안에서 풀이하기
    public static void main2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 몇 개의 문자를 입력받는지
        int N = Integer.parseInt(br.readLine());
        // 그룹 문자의 개수
        int count = 0;

        // 입력받을 단어의 개수만큼 반복
        for (int i=0; i<N; i++) {
            // 알파벳 개수만큼 반복
            String str = br.readLine();
            boolean [] check = new boolean[26];
            boolean flag = true;
            check[str.charAt(0)] = true;

            for (int j=0; j<str.length(); j++) {
                // 이전의 알파벳과 동일하지 않다면
                if (str.charAt(j) != str.charAt(j-1)) {
                    // 해당 알파벳의 boolean 배열 값이 false라면 (아직 나오지 않은 알파벳)
                    if (!check[str.charAt(j)]) {
                        check[str.charAt(j)] = true;
                    } else { // 이미 true라면 (이미 나왔던 알파벳임)
                        flag = false;
                    }
                }
            }

            if (flag) count ++;
        } // for문 단어만큼 반복 종료
        System.out.println(count);
    }

}
