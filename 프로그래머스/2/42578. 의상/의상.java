import java.util.*;

class Solution {
    public static int cnt;
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>(); //key : 의상 종류, value = 의상 이름 list
        
        for(String[] cloth : clothes) {
            String clothType = cloth[1];
            map.put(clothType, map.getOrDefault(clothType, 0) + 1);
        }
        
        int result = 1;
        for(int cnt : map.values()) {
            result *= cnt + 1;
        }
        
        return result - 1;
    }
}