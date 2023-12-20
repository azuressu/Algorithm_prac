package org.example.sort;

public class 퀵정렬 {

    /**
     * 퀵 정렬
     * 기준값인 pivot을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복하며 정렬하는 알고리즘
     * 평균 시간 복잡도는 O(nlogn) 이며 최악의 경우는 O(n²)
     */

    // 퀵 정렬 알고리즘 구현
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // partition 메소드를 통해 pivot의 올바른 위치를 찾음
            int pivotIndex = partition(array, low, high);

            // pivot을 기준으로 분할하여 재귀로 정렬
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // 배열을 분할하고 pivot의 올바른 위치를 찾는 메서드
    public static int partition(int[] array, int low, int high) {
        // 끝에 위치한 값을 pivot으로 설정
        int pivot = array[high];
        // i는 시작보다 하나 왼쪽에 위치
        int i = low - 1;

        // j가 낮을 때부터 높아질 때까지 반복
        for (int j = low; j < high; j++) {
            // 만약 j번째에 위치한 원소가 pivot 값보다 작거나 같은 경우라면
            if (array[j] <= pivot) {
                // 시작 값을 오른쪽으로 이동시킴
                i++;
                // 현재 원소와 i가 가리키는 원소를 교환
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // pivot과 i가 가리키는 원소 교환
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // 실행
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        quickSort(array, 0, array.length - 1);

        for (int n: array) {
            System.out.println(n);
        }
    }

}
