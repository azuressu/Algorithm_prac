import java.util.*;

public class Main1 {

    /**
     * 백준 2588번
     * 세 자리 수 곱셈 과정 나타내기
     */

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        //일단 b를 100, 10, 1 로 나눠서 나눠보자. 몫을 구해야 함 !
        int b1 = (int)(b/100);
        int b2 = (int)((b-b1*100)/10);
        int b3 = (int)(b-b1*100-b2*10);

        System.out.println(a * b3);
        System.out.println(a * b2);
        System.out.println(a * b1);
        System.out.println(a * b);
    }
}
