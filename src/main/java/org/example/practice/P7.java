package org.example.practice;

import java.util.HashMap;
import java.util.HashSet;

public class P7 {
    /**
     * [문제 07] 방문 길이
     * 게임 캐릭터를 다음 4가지 명렁어를 통해 움직임
        * U : 위쪽으로 한 칸
        * D : 아래쪽으로 한 칸 
        * R : 오른쪽으로 한 칸
        * L : 왼쪽으로 한 칸
     * 캐릭터는 좌표평면 상의 (0. 0) 위치에서 시작
     * 명렁어 dirs는 string형으로 주어지며 길이는 500 이하의 자연수
     */

    /**
     * 움직임이 가능한 좌표인지 확인하기 위한 메서드
     * @param nx : x 좌표
     * @param ny : y 좌표
     * @return : 가능함 여부를 true/false로 반환
     */
    private static boolean isVaildMove(int nx, int ny) {
        return (0 <= nx) && (0 <= ny) && (nx < 11) && (ny < 11);
    }

    // 다음 좌표 결정을 위한 해시맵 생성
    private static final HashMap<Character, int[]> location = new HashMap<>();
    private static void initLocation() {
        location.put('U', new int[]{0, 1});  // 위 쪽 (0, 1)
        location.put('D', new int[]{0, -1}); // 아래 쪽 (0, -1)
        location.put('R', new int[]{1, 0});  // 오른 쪽 (1, 0)
        location.put('L', new int[]{-1, 0}); // 왼 쪽 (-1, 0)
    }

    private static int solution(String dirs) {
        initLocation();
        int x = 5;
        int y = 5;
        // 겹치는 좌표는 1개로 처리하기 위하여 set 선정
        HashSet<String> answer = new HashSet<>();
        // 주어진 명령어를 움직이며 좌표 저장
        for (int i=0; i<dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i)); // 해당 명령어에 해당하는 배열 가져오기
            int nx = x + offset[0]; // x 좌표 값
            int ny = y + offset[1]; // y 좌표 값

            // 벗어난 좌표는 인정하지 않음
            if (!isVaildMove(nx, ny)) continue;

            // A에서 B로 간 경우, B에서 A로 이동한 경로도 함께 추가 (총 경로의 개수는 방향성 x)
            answer.add(x + "" + y + "" + nx + "" + ny);
            answer.add(nx + "" + ny + "" + x + "" + y);

            // 좌표를 이동했으므로 초기화
            x = nx;
            y = ny;
        } // for

        return answer.size()/2;
    }
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        int result = solution(dirs);
        System.out.println("result : "+result);
    }
}
