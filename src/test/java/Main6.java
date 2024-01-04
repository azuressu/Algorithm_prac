import java.util.*;
import java.io.*;

public class Main6 {

    /* 10871번 문제
       정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

       입력
       첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
       둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.

       출력
       X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
    */

    public static void main(String[] args) throws IOException {
        // 배열이 없는 버전 - 시간이 훨씬 적게 듬 ! - 164ms
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer(); // append()

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 그 다음 줄 읽기
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a < X) sb.append(a).append(" ");
        }

        System.out.println(sb);

        // 배열이 있는 버전 - 216ms
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer(); // append()

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 그 다음 줄 읽기
        int A[] = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int a = Integer.parseInt(st.nextToken());
            A[i] = a;
        }

        for (int a: A) {
            if (a < X) sb.append(a + " ");
        }

        System.out.println(sb);*/

    }

}
