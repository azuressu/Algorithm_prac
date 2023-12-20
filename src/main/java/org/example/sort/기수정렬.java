package org.example.sort;

import java.util.*;

public class 기수정렬 {

    /**
     * 기수 정렬
     * 값을 비교하지 않고, 값을 놓고 비교할 자릿수만 정한 다음 해당 자릿수만 비교하는 알고리즘
     * 시간 복잡도는 O(kn) -> k는 데이터의 자릿수
     */

    // 기수 정렬 알고리즘 구현
    public static void radixSort(int[] array) {
        // 배열 중 최대값을 찾아 자릿수를 구함
        // int max = Arrays.stream(array).max().getAsInt();
        int max = Integer.MIN_VALUE;
        for (int i=0; i<array.length; i++) {
            if (array[i] > max) max = array[i];
        }

        // 자릿수를 하나씩 올려가면서 구하므로 10씩 곱해짐
        for (int exp = 1; (max / exp) > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    // countingSort 메소드를 사용하여 기수 정렬의 한 단계를 수행
    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10]; // 0부터 9까지의 숫자를 세기 위한 배열

        // 현재 자릿수에 해당하는 숫자의 빈도를 세기
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // count 배열 업데이트: 누적 빈도로 변경
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // output 배열에 정렬된 순서대로 원소 복사
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // output 배열을 원래 배열로 복사
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};

        radixSort(array);

        for (int a: array) {
            System.out.println(a);
        }
    }
}
