package org.example.practice;

import java.util.Stack;

public class P13 {
    /**
     * [문제 13] 크레인 인형 뽑기 게임
     * board는 2차연 배열, 크기는 5 * 5 이상 30 * 30 이하
     * board의 각 칸에는 0이상 100 이하인 정수가 담겨 있음
        * 0은 빈 칸
        * 1~100 의 각 숫자는 각기 다른 인형의 모양을 의미, 같은 숫자는 같은 모양의 인형을 의미
     *  moves 배열 크기는 1 이상 1,000 이하
     *  moves 배열 각 원소들의 값은 1 이상, board 배열의 가로 크기 이하인 자연수
     */

    private static int solution(int[][] board, int[] moves) {
        // 1. 각 열에 대한 스택 생성
        Stack<Integer>[] lanes = new Stack[board.length];

        for (int i=0; i<lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        // 2. board를 역순으로 탐색하며, 각 열의 인형을 lanes에 push
        for (int i=lanes.length-1; i>=0; i--) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] > 0) lanes[j].push(board[i][j]);
            } // for
        } // for

        // 3. 인형을 담을 stack 생성
        Stack<Integer> stack = new Stack<>();
        // 4. 인형의 총 개수를 저장할 변수 초기화
        int answer = 0;

        // 5. moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가
        for (int move: moves) {
            if (!lanes[move - 1].isEmpty()) { // 해당 열에 인형이 있는 경우
                int doll = lanes[move - 1].pop();
                // 6. 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
                if (!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer += 2;
                } else {
                    // 7. 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
                    stack.push(doll);
                } // if-else
            } // if
        }
        return answer;
    }

    public static void main(String[] args) {
        int [][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int [] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int result = solution(board, moves);
        System.out.println("result: " + result);
    }

}
