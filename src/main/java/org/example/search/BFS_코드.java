package org.example.search;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_코드 {

    /**
     * 너비 우선 탐색 (BFS - Breadth-First Search)
     *
     * 가까운 노드부터 우선하여 탐색
     * 출처: https://codingnojam.tistory.com/41
     */

    // 큐(Queue)로 구현
    static String bfs(int start, int[][] graph, boolean[] visited) {
        // 탐색 순서를 출력
        StringBuffer sb = new StringBuffer();
        // BFS에 사용할 Queue
        Queue<Integer> queue = new LinkedList<Integer>();

        // Queue에 BFS 시작 노드 번호를 삽입
        queue.offer(start);

        // 시작 노드 방문 처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            // 큐에서 값을 하나 뺌
            int nodeIndex = queue.poll();
            // 뺀 원소를 StringBuffer에 추가
            sb.append(nodeIndex + " -> ");

            // 큐에서 꺼낸 노드와 연결된 노드 확인
            for (int i=0; i<graph[nodeIndex].length; i++) {
                // 해당 노드와 연결된 노드
                int temp = graph[nodeIndex][i];
                // 방문하지 않았다면 방문 처리 후, 큐에 삽입
                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }

        // 탐색 결과 리턴
        return sb.toString();
    }

    public static void main(String[] args) {
        // 방문처리를 위한 boolean배열 선언
        boolean[] visited = new boolean[9];
        // 2차원 배열로 표현한 그래프
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        System.out.println(bfs(1, graph, visited));
    }


}
