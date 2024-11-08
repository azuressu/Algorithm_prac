package org.example.pgm_prac;

import java.util.ArrayList;
import java.util.Arrays;

public class P12910 {

    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if ((arr[i]%divisor) == 0) arrayList.add(arr[i]);
        }

        if (arrayList.isEmpty()) arrayList.add(-1);
        return arrayList.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution2(int[] array, int divisor) {
        int[] answer = Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6};
        int divisor = 10;
        int[] result = solution(arr, divisor);
        int[] result2 = solution2(arr, divisor);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }
}
