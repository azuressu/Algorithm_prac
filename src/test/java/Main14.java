import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main14 {

    /* 25206번 문제
       인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다.
       그런데 아뿔싸, 치훈이는 깜빡하고 졸업고사를 응시하지 않았다는 사실을 깨달았다!
       치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
       전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
       인하대학교 컴퓨터공학과의 등급에 따른 과목평점은 다음 표와 같다.

        A+	4.5  A0	4.0 B+	3.5 B0	3.0 C+	2.5 C0	2.0 D+	1.5 D0	1.0 F	0.0
        P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
        과연 치훈이는 무사히 졸업할 수 있을까?

        입력
        20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.

        제한
        1 ≤ 과목명의 길이 ≤ 50
        과목명은 알파벳 대소문자 또는 숫자로만 이루어져 있으며, 띄어쓰기 없이 주어진다. 입력으로 주어지는 모든 과목명은 서로 다르다.
        학점은 1.0,2.0,3.0,4.0중 하나이다.
        등급은 A+,A0,B+,B0,C+,C0,D+,D0,F,P중 하나이다.
        적어도 한 과목은 등급이 P가 아님이 보장된다. */

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double sum = 0;
        double s = 0;

        for (int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            Double score = Double.parseDouble(st.nextToken());
            String str = st.nextToken();

            switch(str) {
                case "A+" :
                    sum += score * 4.5;
                    s += score;
                    break;
                case "A0" :
                    sum += score * 4.0;
                    s += score;
                    break;
                case "B+" :
                    sum += score * 3.5;
                    s += score;
                    break;
                case "B0" :
                    sum += score * 3.0;
                    s += score;
                    break;
                case "C+" :
                    sum += score * 2.5;
                    s += score;
                    break;
                case "C0" :
                    sum += score * 2.0;
                    s += score;
                    break;
                case "D+" :
                    sum += score * 1.5;
                    s += score;
                    break;
                case "D0" :
                    sum += score * 1.0;
                    s += score;
                    break;
                case "F" :
                    s += score;
                    break;
                case "P" :
                    break;
            } // switch
        } // for

        System.out.println(sum == 0 ? 0.0000 : sum / s);

    } // main

    // 다른 풀이
    public static void main2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Double> score = new HashMap<>();
        int CNT = 0;
        Double Total = 0.0;
        // 점수 기록
        makeScores(score);
        String[] line;
        for (int i=0; i<20; i++) {
            line = br.readLine().split(" ");

            // 점수가 P라면 계산하지 않고 넘어감
            if (line[2].equals("P")) continue;

            Double S = Double.parseDouble(line[1]);
            Double rank = score.get(line[2]); // 해당 등급에 해당하는 값을 가져옴 (value를 가져옴)
            Total += S * rank;
            CNT += S;
        } // for
        System.out.println(Math.round((Total/CNT) * 1000000) / 1000000.0);
    }
    static void makeScores(Map<String,Double> score) {
        score.put("A+", 4.5);
        score.put("A0", 4.0);
        score.put("B+", 3.5);
        score.put("B0", 3.0);
        score.put("C+", 2.5);
        score.put("C0", 2.0);
        score.put("D+", 1.5);
        score.put("D0", 2.0);
        score.put("F", 0.0);
    }


}

