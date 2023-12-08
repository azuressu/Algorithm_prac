package org.example;

import java.util.*;

public class P11720_숫자의합 { // 백준에서 풀이할 때는 class 명을 Main으로 두어야 한다.

    /**
     * 첫째 줄에 숫자의 개수 N(1<=N<=100)
     * 둘째 줄에 숫자 N개가 공백 없이 주어진다고 했을 때,
     * 둘째 줄에 주어진 숫자들의 합을 구하시오.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 먼저 숫자의 개수를 입력받고
        int N = sc.nextInt();
        // 숫자를 입력받는다 (String 타입으로 !)
        String sNum = sc.next();

        // 위에서 입력받은 숫자를 char 배열로 만들어준 다음,
        char[] cNum = sNum.toCharArray();
        // 합계를 구할 변수를 선언한다.
        int sum = 0;

        // char 배열의 반복문을 돌려 각 숫자를 sum 변수에 더해준다.
        for (char c : cNum) {
            // char은 문자인데, 이 문자를 해당 숫자로 바꾸기 위해서 아스키 코드를 이용한다.
            // 문자 '0' 을 빼주거나, 48을 빼줄 수 있다.
            sum += c - 48; // '0'
        }
        // 합계를 출력해본다.
        System.out.println(sum);
    }

}
