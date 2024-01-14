package upgrade1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main15 {

    /* 2941번 문제
        예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
        크로아티아 알파벳	변경
        č	c=  ć	c-  dž	dz=  đ	d-  lj	lj  nj	nj  š	s=  ž	z=
        예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다.
        단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
        dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다.
        lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

        입력
        첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
        단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

        출력
        입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.*/

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<String, String> c = new HashMap<>();
        int N = 0;         // 반복문 변수
        int count = 0;     // 알파벳 수 변수
        // Map에 언어 삽입
        makeC(c);

        // 반복문 돌림
        while (N < str.length()) {
            String substr = "";
            String substr2 = "";
            if ((N < str.length() -1) && ((N+2)!= str.length() -1)) {
                substr = str.substring(N, N+2);
            }

            if ((N < str.length() -2) && ((N+3)!= str.length() -1)) {
                substr2 = str.substring(N, N+3);
            }

            // 해당 키가 있는지 확인하는 것
            // 있으면 크로아티아 언어로 확인하고, 아니면 그냥 알파벳으로 count
            if (c.containsKey(substr)) {
                count ++;
                N += 2;
            } else if (c.containsKey(substr2)){
                count ++;
                N += 3;
            } else {
                count ++;
                N ++;
            }

        }

        System.out.println(count);
    }

    public static void makeC(Map<String, String> c) {
        c.put("c=", "c=");
        c.put("c-", "c-");
        c.put("dz=", "dz=");
        c.put("d-", "d-");
        c.put("lj", "lj");
        c.put("nj", "nj");
        c.put("s=", "s=");
        c.put("z=", "z=");
    }


    // 다른 사람의 풀이
    public static void main2() {
        Scanner s=new Scanner(System.in);
        // 해당 문자들 중에 해당 사항이 있다면 다른 문자 (1글자)로 교체 후 길이를 출력하기
        String sar=s.next().replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "a");
        System.out.println(sar.length());
    }
}
