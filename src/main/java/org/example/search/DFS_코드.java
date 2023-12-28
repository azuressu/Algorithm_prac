package org.example.search;

import java.util.Stack;

public class DFS_코드 {

    /**
     * 깊이 우선 탐색 (DFS - Depth-First Search)
     *
     * 첫 노드를 기준으로 그 노드를 따라 계속 안으로 들어가면서 방문한 후에 더 연결된 노드가 없다면
     * 그 전 노드로 되돌아가 다시 연결된 노드를 따라 안으로 가며 탐색
     * 출처: https://codingnojam.tistory.com/44
     */

    // 재귀 함수로 구현하기
    // 방문 처리에 사용할 배열
    static boolean[] visited = new boolean[9];
    // 그래프 연결 상태 -> 2차원 배열
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    static void dfs(int nodeIndex) {
        // 방문 처리
        visited[nodeIndex] = true;

        // 방문 노드 출력
        System.out.print(nodeIndex + " -> ");

        // 방문한 노드의 인접 노드 찾기
        for (int node: graph[nodeIndex]) {
            // 인접 노드가 방문한 적이 없는 경우 DFS 수행
            if (!visited[node]) {
                dfs(node);
            }
        }

    }


    // 스택으로 구현하기
    static Stack<Integer> stack = new Stack<>();

    static void dfs2() {

        // 시작 노드를 스택에 넣음
        stack.push(1);

        // 시작 노드 방문 처리
        visited[1] = true;

        // 스택이 비어있지 않으면 계속 반복
        while(!stack.isEmpty()) {

            // 스택에서 하나를 꺼냄
            int nodeIndex = stack.pop();

            // 방문 노드 출력
            System.out.print(nodeIndex + " -> ");

            // 꺼낸 노드와 인접한 노드 찾기
            for (int LinkedNode : graph[nodeIndex]) {
                // 인접 노드를 방문하지 않은 경우 스택에 넣고 방문처리
                if (!visited[LinkedNode]) {
                    stack.push(LinkedNode);
                    visited[LinkedNode] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 재귀함수로 구현한 DFS
        dfs(1);

        // stack으로 구현한 DFS
        dfs2();
    }

}
