// 범위가 딱히 나와있진않음.
// 딱히 생각나는 알고리즘도 없음. 반복문으로 해결하자 그냥

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();
        
        for(int val : arr) {
            if(val % divisor == 0) result.add(val);
        }
        
        if(result.isEmpty()) return new int[]{-1};
        
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}