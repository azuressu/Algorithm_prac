package org.example.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색하기 {

    /**
     * 미로의 각 칸에 들어 있는 숫자 중 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
     * 한 칸에서 다른 칸으로 이동할 때는 서로 인접한 칸으로만 이동 가능
     * 이동한 칸을 셀 때는 시작 위치와 도착 위치를 포함
     * 즉 (1,1) 에서 (4,6)으로 이동하려면 총 15칸을 지나야 함
     * 
     * N * M 크기의 미로가 주어질 때, (1,1) 에서 출발해 (N,M) 의 위치로 이동하기 위해
     * 지나야 하는 칸 수의 최솟값을 구하는 프로그램 작성하기
     */

    // 상하좌우 탐색
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int[][] A;
    static boolean[][] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        // 최초 한 번만 true 값으로 선언해주면 됨
        visited[i][j] = true;
        // 더 이상 BFS를 탐색할 수 없을 때까지
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for (int k=0; k<4; k++) {  // 상하좌우로 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                // 좌표가 유효한지 검사
                if (x >= 0 && y >= 0 && x < N && y < M) {   // 배열을 넘어가면 안됨
                    if (A[x][y] != 0 && ! visited[x][y]) {  // 0이어서 갈 수 없거나 기방문한 곳이면 안됨
                        // 이제 갈 수 있는 곳
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;    // 핵심 - 깊이를 하나 늘려줌
                        queue.add(new int[] {x,y} );
                    }
                }
            }
        }

    }
}
