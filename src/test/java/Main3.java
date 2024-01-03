import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    /*
    * 오븐의 시간 계산하기
    * BufferedReader, StringTokenizer 연습하기 !
    */
    public static void main(String[] args) throws IOException {

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());

        if ((minute + time) > 60) {
            // (int)(minute + time / 60) 의 몫
            int newhour = (int) ((minute + time) / 60);
            int newminute = (int) ((minute + time) % 60);

            // 등호 하나 빼먹어서 틀렸다가 맞음 .. ^^
            if (newhour + hour >= 24) {
                System.out.println((newhour + hour - 24) + " " + newminute);
            } else {
                System.out.println((newhour + hour) + " " + newminute);
            }
        } else if ((minute + time) == 60) {
            System.out.println((hour + 1) + " " + 0);
        } else {
            System.out.println(hour + " " + (minute + time));
        }*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long cost = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Long sum = Long.parseLong("0");

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            sum += (Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken()));
        }

        System.out.println(cost.equals(sum) ? "Yes" : "No");

    } // main


}
