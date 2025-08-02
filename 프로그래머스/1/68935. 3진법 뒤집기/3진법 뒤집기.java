import java.util.*;

class Solution {
    public int solution(int n) {
        //3진법 String 으로 변환
        String wlsqjq3 = Integer.toString(n, 3);
        
        //reverse
        StringBuffer sb = new StringBuffer(wlsqjq3);
        
        String result = sb.reverse().toString();
        return Integer.valueOf(result, 3);
    }
}