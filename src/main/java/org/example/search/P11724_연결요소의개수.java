package org.example.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {

    /**
     * 첫 번째 줄에 노드의 개수 N(1<=N<=1,000)과 에지의 개수 M(0<=M<=N(N-1)/2
     * 두 번째 줄부터 M개의 줄에 에지의 양 끝 점 u와 v가 주어짐
     * 연결 요소의 개수란 ? 몇 개의 그래프로 구성되어 있는가를 물어보는 것
     */

    // 노드 최대의 개수가 1,000 이므로 시간 복잡도 N²이하의 알고리즘을 모두 사용 가능
    // 방향성을 알려주지 않았으므로 양쪽으로 모두 이용이 가능하다는 점 유의하기

    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];       // 실제로 인접 리스트의 시작 부분만 선언해준 것
        visited = new boolean[n+1];

        for (int i=1; i<n+1; i++) {
            A[i] = new ArrayList<Integer>(); // 리스트 안에 리스트 형태로 선언해줄 것
        }

        for (int i=0; i<m; i++) {
            // M개 동안 인접 리스트에 넣어줄 것
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양쪽 방향으로 모두 add를 해주어ㅑㅇ 함
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0; // 처음 시작은 0으로 초기화
        for (int i=1; i<n+1; i++) { // 0번째가 아니라 1부터 사용하기 때문에 범위를 1부터 ~ 로 사용해야 함
            if (!visited[i]) {
                // 방문하지 않은 노드
                count++;
                DFS(i);   // 현재 방문하지 않은 노드를 기준으로 함수 실행
            }
        }

        System.out.println("연결 요소의 개수: "+count);
    } // main 함수 종료

    private static void DFS(int v) {
        if(visited[v]) {
            return;
        }
        // 방문 노드가 아닐 경우
        visited[v] = true; // 이제 방문한 노드가 되므로 true로 값을 변경해줌
        // 현재 연결 노드 중 방문하지 않은 노드를 찾아야 함
        for (int i: A[v]) {
            // 재귀 함수
            if(!visited[i]) { // 이 함수 안에서 방문하지 않은 노드가 있다면
                // 그 노드를 기준으로 다시 탐색해주세요
                DFS(i);
            }
        }


    }




}
