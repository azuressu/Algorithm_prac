package upgrade1;

import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        String str = " ";
        int N = sc.nextInt();

        for (int i=1; i<=N; i++) {
            if (i != 5) sb.append(str.repeat(5-i)).append("*".repeat(2*i-1)).append("\n");
            else sb.append("*".repeat(2*i-1)).append("\n");
        }
        for (int j=N-2; j>=0; j--) {
            sb.append(str.repeat(4-j)).append("*".repeat(2*j+1));
            if (j != 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
