package array2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18 {

    /* 2738번 문제
        N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

       입력
        첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

       출력
        첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.*/

    // 내 풀이
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] array = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                array[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        // 출력
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                sb.append(array[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


    // 다른 사람의 풀이
    // 입력을 읽어들이는 함수
    static int read() throws IOException {
        // System.in.read()를 통해 한 바이트를 읽어들인 후, 마지막 4비트를 제외한 나머지 비트를 0으로 만들기 위해 & 15를 사용하여 비트 마스킹 -> 이 값을 변수 n에 저장
        // 비트 연산자 &와 함께 사용된 15는 바이트에서 마지막 4비트를 제외한 나머지 비트를 모두 0으로 만들기 위한 비트 마스킹 연산
        // [&15] System.in.read()는 1바이트를 읽어들여서 ASCII 값으로 반환 -> ASCII 값은 7비트로 표현되는데, 이를 8비트 바이트로 나타내면 8번째 비트는 부호 비트로 사용될 수 있음.
        //                    그러나 이 코드에서는 음수에 대한 처리를 하지 않고, 마지막 4비트만을 사용하려는 의도로 사용
        // 이 8비트 중에서 마지막 4비트만을 남기고 나머지는 모두 0으로 만들어 해당 값을 범위 내로 조절.
        // -> c 변수에는 0부터 15 사이의 값이 저장되며, 이는 특정 ASCII 문자에 해당하는 값
        int c, n = System.in.read() & 15;

        // 아스키 코드 32 = 공백
        while ((c = System.in.read()) > 32) {
            // (n << 3): n의 값을 왼쪽으로 3비트 시프트. 이는 n을 2의 3승(8)으로 곱하는 것과 같음.
            // (n << 1): n의 값을 왼쪽으로 1비트 시프트. 이는 n을 2로 곱하는 것과 같음.
            // (c & 15): c와 15를 비트 단위 AND 연산. 이는 c의 값에서 마지막 4비트만을 남기는 것과 같음.
            // 따라서 전체적으로 보면, 현재까지 읽어들인 숫자 n을 10진수로 업데이트하기 위해 현재 값에 8배와 2배를 한 후,
            // 새로 읽은 숫자 c의 마지막 4비트를 더해주는 연산입니다. 이러한 방식으로 n은 새로운 숫자를 덧셈하여 여러 자릿수의 정수로 구성
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static void main2(String [] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        // 행과 열의 크기를 읽어들임
        int n = read();
        int m = read();

        // 2차원 배열 선언 및 초기화
        int[][] arr = new int[n][m];

        // 입력된 행렬 데이터를 처리하여 결과를 계산
        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < m; j++) {
                // n의 2배로 바깥 for문을 돌리기 때문에 n으로 나눠서 A배열 B배열을 구분
                arr[i % n][j] += read();
                // i가 n보다 크거나 같다면 sb에 원소값 추가
                if (i >= n) {
                    sb.append(arr[i % n][j]).append(" ");
                }
            }
            // i가 n보다 크거나 같다면 줄바꿈 추가
            if (i >= n) {
                sb.append("\n");
            }
        }

        // 결과를 출력
        System.out.print(sb);
    }
}
