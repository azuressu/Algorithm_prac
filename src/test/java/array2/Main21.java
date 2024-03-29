package array2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main21 {

    /* 문제 2563번
    * 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
    * 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
    * 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
    * 예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.

    * 입력
    * 첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
    * 색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고,
    * 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다.
    * 색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다

    * 출력
    * 첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.
    * */

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        // 큰 정사각형 종이 2차열 배열로 선언
        int[][] paper = new int[100][100];
        // 색종이의 개수 입력받기
        int n = sc.nextInt();
        int w = 0;

        // 반복문 돌리기
        for (int i=0; i<n; i++) {
            int a = sc.nextInt(); // 가로
            int b = sc.nextInt(); // 세로
            // 사각형 넓이만큼 1 삽입
            for (int j=a; j<a+10; j++) {
                for (int k=b; k<b+10; k++) {
                    if (paper[j][k] == 1) continue;
                    paper[j][k] = 1;
                    w += 1;
                }
            }
        }
        System.out.println(w);
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int w = 0;
        int [][] paper = new int [100][100];

        for (int k=0; k<n; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int i = a; i<a+10; i++) {
                for (int j=b; j<b+10; j++) {
                    if (paper[i][j] == 1) continue;
                    paper[i][j] = 1;
                    w += 1;
                }
            }
        }
        System.out.println(w);
    }

}
