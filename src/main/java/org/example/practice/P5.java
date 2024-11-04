package org.example.practice;

import java.util.Arrays;

public class P5 {
    /**
     * [문제 05] 행렬의 곱셈
     * arr1과 arr2를 입력받아 곱한 결과를 반환
     * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하
     * 행렬 arr1, arr2의 데이터는 -10 이상 20 이하인 자연수
     * 곱할 수 있는 배열만 주어짐
     */

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. arr1과 arr2의 행과 열의 수
        int row1 = arr1.length;
        int column1 = arr1[0].length;
        int row2 = arr2.length;
        int column2 = arr2[0].length;

        // 2. 곱셈 결괄르 저장할 2차원 배열 초기화
        int [][] answer = new int [row1][column2];

        // 3. 첫 번째 행렬 arr1의 각 행과 두 번째 행렬 arr2의 각 열에 대해서
        for (int i=0; i<row1; i++) {
            for (int j=0; j<column2; j++) {
                // 4. 두 행의 데이터를 곱하여 결과 리스트에 더함
                for (int k=0; k<column1; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                } // for
            } // for
        } // for

        return answer;
    } // solution

    public static void main(String[] args) {
        int [][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int [][] arr2 = {{3, 3}, {3, 3}};

        int [][] result = solution(arr1, arr2);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }



}
