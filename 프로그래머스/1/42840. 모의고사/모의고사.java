// 문제는 answers 대로 반복됨.
// 즉, [1, 2, 3, 4, 5] ... -> [1, 2, 3, 4, 5, 1, 2, 3, 4, 5 ... n]

// 수포자1 = [1, 2, 3, 4, 5 ...] x 반복
// 수포자2 = [2, 1, 2, 3, 2, 4, 2, 5] x 반복
// 수포자3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] x 반복

// 문제느 최대 10,000 문제
// 모든 케이스에 대해 수포자1, 2, 3 검사를 하면?
// 최대 O(n+n+n) = O(30,000) 만 확인을 하면됨.
// 그럼 그냥 단순히 반복으로 구현 해결해도 될듯?

// 공통 메서드로 진행? ㅇㅇ 굳이?

import java.util.*;

class Solution {
    private int max = Integer.MIN_VALUE;
    private static final int[] p1 = new int[]{1, 2, 3, 4, 5};
    private static final int[] p2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] p3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {        
        int p1Count = 0, p2Count = 0, p3Count = 0;
        //수포자 1 확인
        for(int i=0; i<answers.length; i++) {
            // 수포자1
            if(answers[i] == p1[i%5]){
                p1Count++;
            }
            // 수포자2
            if(answers[i] == p2[i%8]){
                p2Count++;
            }
            // 수포자3
            if(answers[i] == p3[i%10]){
                p3Count++;
            }
        }
        
        //가장 많은 정답의 수를 확인
        max = Math.max(p1Count, p2Count);
        max = Math.max(max, p3Count);
 
        List<Integer> list = new ArrayList<>();
        int collectCount = 0;
        if(max == p1Count) list.add(1);
        if(max == p2Count) list.add(2);
        if(max == p3Count) list.add(3);
        
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}