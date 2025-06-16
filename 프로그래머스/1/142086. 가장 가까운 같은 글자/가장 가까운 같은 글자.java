// 현재 인덱스 위치와, 마지막에 'b', 'c' 등이 나온 인덱스 위치를 알 수 있으면 됨.
// key-value map 으로 처리하자

import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] result = new int[s.length()];
        
        int i=0;
        for(char c : s.toCharArray()) {
            int now = map.getOrDefault(c, -1); //마지막에 나온걸 찾음. 없으면 -1
            
            if(now == -1) result[i] = -1;
            else result[i] = i-now;
            
            map.put(c, i);
                
            i++;
        }
        
        return result;
    }
}