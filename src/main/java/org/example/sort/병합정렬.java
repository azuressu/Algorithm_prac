package org.example.sort;

public class 병합정렬 {

    /**
     * 병합 정렬
     * 분할 정복 방식을 사용하여 데이터를 분할하고, 분할한 집합을 정렬하면서 합치는 알고리즘
     * 시간 복잡도는 O(nlogn)
     *
     * 투 포인터의 개념을 사용하여 두 개의 그룹을 병합
     */

    // 병합 정렬 알고리즘 구현
    public static void mergeSort(int[] array, int left, int right) {
        // 왼쪽이 오른쪽보다 낮다면
        if (left < right) {
            // 중간 지점을 찾아 배열을 두 개로 분리
            int middle = (left + right) / 2;

            // 두 개로 나눈 배열에 대해 재귀로 정렬
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // 정렬된 두 배열을 병합
            merge(array, left, middle, right);
        }
    }

    // 두 배열을 병합하는 메서드
    public static void merge(int[] array, int left, int middle, int right) {
        // 병합할 두 배열의 크기 계산
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 임시 배열을 생성하여 데이터를 복사
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 왼쪽의 배열 복사
        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        // 오른쪽의 배열 복사
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[middle + 1 + j];

        // 두 배열을 정렬하여 병합
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 남은 요소들을 복사
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // 실행
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        mergeSort(array, 0, array.length - 1);

        for (int a: array) {
            System.out.println(a);
        }
    }


}
