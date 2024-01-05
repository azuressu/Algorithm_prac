import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main12 {

    /* 5622번 문제
        상근이의 할머니는 아래 그림과 같이 오래된 다이얼 전화기를 사용한다.
        전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다.
        숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.
        숫자 1을 걸려면 총 2초가 필요하다.
        1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
        상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다.
        즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 예를 들어, UNUCIC는 868242와 같다.
        할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 최소 시간을 구하는 프로그램을 작성하시오.

        입력
        첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다.

        출력
        첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다.*/
    public static void myAns1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = 0;

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'A' : case 'B' : case 'C' :
                    sum += 3;
                    break;
                case 'D' : case 'E' : case 'F' :
                    sum += 4;
                    break;
                case 'G' : case 'H' : case 'I' :
                    sum += 5;
                    break;
                case 'J' : case 'K' : case 'L' :
                    sum += 6;
                    break;
                case 'M' : case 'N' : case 'O' :
                    sum += 7;
                    break;
                case 'P' : case 'Q' : case 'R' : case 'S' :
                    sum += 8;
                    break;
                case 'T' : case 'U' : case 'V' :
                    sum += 9;
                    break;
                case 'W' : case 'X' : case 'Y' : case 'Z' :
                    sum += 10;
                    break;
            }
        }

        System.out.println(sum);
    }

    public static void otherAns1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int time = 0;

        for (int i=0; i<str.length(); i++) {
            // 해당 문자에서 'A'를 빼면, 해당 알파벳의 위치를 나타냄 -> 'W'라면 22
            int num = str.charAt(i) - 'A' + 1;

            // num이 18보다 크다면? R 이후의 알파벳이라면
            if (num > 18) num--;

            // 3으로 나누어지지 않는 예외의 S와 Z는 따로 처리
            if (str.charAt(i) == 'S') {
                time += 8;
                continue; // 밑으로 흘러가지 않도록 끊기
            } else if (str.charAt(i) == 'Z') {
                time += 10;
                continue; // 밑으로 흘러가지 않도록 끊기
            }

            if (num % 3 == 0) {
                // 3으로 나누어 떨어지는 경우라면 해당 값의 몫에 2만 더해주면 됨
                time += num / 3 + 2;
            } else {
                // 3으로 나누어 떨어지지 않는 경우(나머지가 1 혹은 2)
                // 해당 값의 몫이 더해주려는 값보다 -1 상태이기 때문에 3을 더해주어야 함
                time += num / 3 + 3;
            }
        } // for
        System.out.println(time);
    }

    public static void main(String[]args) throws IOException {
        myAns1();
        otherAns1();
    }
}
