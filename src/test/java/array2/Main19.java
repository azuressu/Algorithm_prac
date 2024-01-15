package array2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19 {

    /* 2566번 문제
        <그림 1>과 같이 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.

       입력
        첫째 줄부터 아홉 번째 줄까지 한 줄에 아홉 개씩 수가 주어진다. 주어지는 수는 100보다 작은 자연수 또는 0이다.

       출력
        첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다. 최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력한다.*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int max = Integer.MIN_VALUE; // 0으로 두어도 됨 (최솟값이 0)
        int n = 0;
        int m = 0;

        for (int i=1; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (max < num) {
                    max = num;
                    n = i;
                    m = j;
                }
            }
        }

        // 문자열 + 하지말고 append로 다 붙이기. 시간에서 차이가 난다
//        sb.append(max + "\n").append(n + " " + m); // 160ms
        sb.append(max).append("\n").append(n).append(" ").append(m); // 124 ms
        System.out.println(sb);
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // max -> 최대값, r -> 행 번호, h -> 열 번호
        int max=0, r=0, h=0;

        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                int n = Integer.parseInt(st.nextToken());
                if(max<n){
                    max = n;
                    r = i;
                    h = j;
                }
            }
        }
        sb.append(max).append("\n").append(r+1).append(" ").append(h+1);
        System.out.println(sb);
    }
}
