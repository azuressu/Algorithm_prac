package org.example.pgm_prac;

import java.util.ArrayList;
import java.util.Stack;

public class P12906 {

    // 내 풀이
    public int[] solution(int [] arr) {
        Stack<Integer> stack = new Stack<>();

        // if문 안의 조건을 중첩 if문으로 작성하지 않고 한 줄로 쓰는 것이 더 좋아보임
        for (int i : arr) {
            // if (!stack.isEmpty() || stack.peek() != i) 이렇게 !
            if (!stack.isEmpty()) {
                if (stack.peek() != i) {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        // stream을 사용하여 stack을 array로 바꿔서 return
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    // 다른 사람의 풀이
    public int[] solution2(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i);
        }
        return answer;
    }

    public Stack<Integer> solution3(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for(int num : arr){
            if(stack.size() == 0 || stack.peek() != num){
                stack.push(num);
            }
        }

        return stack;
    }
}
