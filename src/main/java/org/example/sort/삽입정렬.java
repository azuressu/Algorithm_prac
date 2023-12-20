package org.example.sort;

public class 삽입정렬 {

    private static int[] insertion_sort(int[] array) {
        // 배열의 길이만큼 반복
        for(int i = 1; i < array.length; i++) {
            // 타겟 넘버 설정
            int target = array[i];

            // i 하나 이전까지
            int j = i - 1;

            // 타겟이 이전 원소보다 크기 전 까지 반복
            while(j >= 0 && target < array[j]) {
                array[j + 1] = array[j];          // 이전 원소를 하나씩 뒤로 이동
                j--;
            }

            // 안의 반복문에서 탈출하는 경우는 앞 원소가 타겟 넘버보다 작다는 것
            // 타겟 넘버는 j번째 원소의 뒤에 위치해야 함
            // 따라서 타겟은 j+1에 위치
            array[j + 1] = target;
        }

        return array;
    }

    public static void main(String[] args) {
        int [] sorting = {3,5,6,1,2};
        int [] A = insertion_sort(sorting);

        for (int n: A) {
            System.out.println(n);
        }
    }


}
