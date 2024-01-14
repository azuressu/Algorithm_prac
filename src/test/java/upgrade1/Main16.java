package upgrade1;

import java.io.IOException;
import java.util.Scanner;

public class Main16 {

    /**
     1157번 문제
     알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

     입력
     첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

     출력
     첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();

        int [] a = new int[26]; // 알파벳 개수만큼 배열 크기 지정

        for (int i=0; i<str.length(); i++) {
            // 해당 알파벳에 해당하는 인덱스의 값 증가
            a[str.charAt(i)-'A'] ++;
        }

        int max = -1;
        char ans = '?';

        for (int i=0; i<a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                ans = (char)(i + 65);
            } else if (a[i] == max) {
                ans = '?';
            }
        }

        System.out.println(ans);
    }

    // 다른 사람 풀이
    static void main2 (String[]args) throws Exception{
        int[] a = new int[26];
        int c, max = 0, maxa = -2;

        /* System.in.read() -> 표준 입력 스트림(System.in)으로부터 바이트를 읽어오는 메서드
                               InputStream 클래스의 메서드 중 하나로, 입력 스트림으로부터 한 바이트씩 데이터를 읽어들임
                               사용자가 키보드에서 문자를 입력하면, 해당 문자의 ASCII 코드 값이 반환됨 */
        while ((c = System.in.read()) > 64) {
            // 알파벳 빈도수를 계산
            /* c < 96인 경우에는 65를 빼고, 그렇지 않으면 97을 빼서 결과를 c에 할당.
               a[c]의 값을 1 증가

               * 소문자 알파벳(a-z)의 ASCII 코드 값 범위가 97부터 122까지이고, 대문자 알파벳(A-Z)의 ASCII 코드 값 범위가 65부터 90까지임을 이용.
                 따라서, c < 96이면 소문자 -> 65를 빼서 a 배열의 인덱스로 사용, 그렇지 않으면 대문자 -> 97을 빼서 a 배열의 인덱스로 사용.
                 이렇게 하면 알파벳이 등장할 때마다 해당 알파벳에 대한 빈도수를 증가시키는 역할*/
            a[c -= c < 96 ? 65 : 97]++;

            if (max < a[c]) {
                max = a[c];
                maxa = c;
            } else if (max == a[c])
                maxa = -2;
        }

        System.out.print((char)(maxa + 65));
    }
}
