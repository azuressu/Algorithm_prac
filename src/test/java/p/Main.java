package p;

public class Main {
    public static void main(String[] args) {
        int hp = 23;
        int answer = 0;
        int save;
        // 5로나눴을때의 몫, 나머지,
        // 3으로 나눴을 때의 몫, 나머지,
        // 그 나머지느 ㄴ그냥 더해주기

        answer += (int)(hp / 5);
        save = hp % 5;

        answer += (int)(save / 3);
        save = save % 3;

        answer = save != 0 ? answer += save : answer;
        System.out.println(answer);
    }
}
