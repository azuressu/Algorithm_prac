package org.example.greedy;

import java.util.Scanner;

public class P1541_최솟값괄호배치 {

    /**
     * 양수와 +, -, 괄호를 이용해 어떤 수식을 만듦
     * 괄호를 모두 지우고, 다시 괄호를 적절하게 넣어 수식의 값을 최소로 만들고자 함
     * 수식 값을 최소로 만드는 프로그램 작성
     *
     * 식은 '0'`'9', '+', '-' 만으로 이루어진 식.
     * 가장 처음과 마지막 문자는 숫자. 연속해서 2개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없음
     * 수는 0으로 시작될 수 있음
     */


    static int answer = 0;
    public static void main(String[] args) {
        // 빼는 숫자가 크면 클수록 전체 수식의 결과는 최소가 됨
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");

        for (int i=0; i<str.length; i++) {
            int temp = mySum(str[i]);

            if (i==0) answer += temp;
            else answer -= temp;
        }

        System.out.println(answer);
    }

    private static int mySum(String s) {
        int sum = 0;
        String[] temp = s.split("[+]");
        for (int i=0; i<temp.length; i++) {
            sum = sum + Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
