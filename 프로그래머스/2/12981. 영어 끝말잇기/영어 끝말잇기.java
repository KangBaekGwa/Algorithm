import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        
        String end = words[0].substring(words[0].length()-1);
        System.out.print(end);
        map.put(words[0], true);
        
        for(int i=1; i<words.length; i++) {
            String word = words[i];
            String first = word.substring(0, 1);
            
            if(map.containsKey(word) ||
               !first.equals(end)
              ) {
                //번호와 차례 return
                return new int[]{ i % n + 1, i / n + 1};
            }
            
            map.put(word, true);
            end = word.substring(word.length()-1);
        }
        
        return new int[]{0, 0};
    }
}