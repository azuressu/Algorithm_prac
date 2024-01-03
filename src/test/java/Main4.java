import java.io.*;
import java.util.StringTokenizer;

public class Main4 {

    /* A+B 를 출력하는 문제 */

    private static void one() throws IOException{
        // 1. BufferedReader +  StringTokenizer + BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s;

        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(a+b+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static void two() throws IOException {
        // 2. BufferedReader + StringTokenizer + StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s;

        while((s = br.readLine()) != null) {
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }

        System.out.println(sb);
    }

    public static void three() throws IOException {
        // 3. BufferedReader + charAt + BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;

        while((s = br.readLine()) != null) {
            int a = s.charAt(0) - 48;
            int b = s.charAt(2) - 48;
            bw.write((a+b) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void four() throws IOException {
        // 4. BufferedReader + charAt + StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;

        while((s = br.readLine()) != null) {
            int a = s.charAt(0) - 48;
            int b = s.charAt(2) - 48;
            sb.append(a+b).append("\n");
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException {
        // 1. BufferedReader +  StringTokenizer + BufferedWriter
        // 메모리: 14672KB | 시간: 140ms | 코드길이: 656B
        one();

        // 2. BufferedReader + StringTokenizer + StringBuilder
        // 메모리: 14204KB | 시간: 124ms | 코드길이: 584B
        two();

        // 3. BufferedReader + charAt + BufferedWriter
        // 메모리: 15824KB | 시간: 140ms | 코드길이: 530B
        three();

        // 4. BufferedReader + charAt + StringBuilder
        // 메모리: 14160KB | 시간: 124ms | 코드길이: 491B
        four();
    }
}
