import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11 {

    /* 11718번 문제
        입력 받은 대로 출력하는 프로그램을 작성하시오.

        입력
        입력이 주어진다.
        입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다.
        각 줄은 100글자를 넘지 않으며, 빈 줄은 주어지지 않는다. 또, 각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.

        출력
        입력받은 그대로 출력한다. */
    public static void main(String[] args) throws IOException {
        // 시스템에서 입력받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력할 String
        StringBuffer sb = new StringBuffer();

        // br의 line별 string 값을 가져올 변수
        String s = "";

        while ((s = br.readLine()) != null) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
