//? 이해가 안되는디?
// 아 h값을 계속 바꾸면서 검증하면서 최대값을 찾는거구나.
// 최대 h를 찾는거니, 높은 h 부터 검증 진행

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int total = citations.length;
        Arrays.sort(citations);
        
        //h를 max로 시작해서 검증
        for (int h=total; h >= 0; h--) {
            int okCount = 0;
            int notCount = 0;
            for(int i=0; i<total; i++) {
                if(citations[i] >= h) okCount++;
                else if(citations[i] < h) notCount++;
            }
            if(okCount >= h && notCount <= h) return h;
        }
        return 0;
    }
}