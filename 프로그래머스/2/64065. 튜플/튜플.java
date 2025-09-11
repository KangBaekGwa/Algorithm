import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        String[] sArray = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(sArray, Comparator.comparingInt(String::length));
        
        for(String str : sArray) {
            String[] strArray = str.split(",");
            for(String strNumber : strArray) {
                int number = Integer.parseInt(strNumber);
                if(!visited.contains(number)) {
                    visited.add(number);
                    result.add(number);
                }
            }
        }
        
        int[] list = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            list[i] = result.get(i);
        }
        
        return list;
    }
}