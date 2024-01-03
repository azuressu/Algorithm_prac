import java.util.*;
import java.io.*;

public class Main2 {

    public static void main(String[]args) throws IOException{
        // 런타임에러 InputMismatch
        /*Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(A+B+C);*/


        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(A+B+C);*/

        // 런타임에러 (NumberFormat)
        /*Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] A = s.split(" ");
        int sum = 0;
        for (String a: A) {
            sum+=Integer.parseInt(a);
        }
        System.out.println(sum);   */

        // 정답 코드
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] a = s.split(" ");
        System.out.println(Long.parseLong(a[0]) + Long.parseLong(a[1]) + Long.parseLong(a[2]));
    }

}
