//가장 중요한거. 모든 달은 28일까지로 통일. 굳구ㅡㄷ굳

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> termMap = new HashMap<>(); //key = 약관 종류, value = 유효기간 日
        int todayDay = convertDay(today);
        
        for(String term : terms) {
            String[] termArray = term.split(" ");
            String type = termArray[0];
            int days = Integer.parseInt(termArray[1]) * 28;
            
            termMap.put(type, days);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] priArray = privacies[i].split(" ");
            int endDay = convertDay(priArray[0]) + termMap.get(priArray[1]);
            if(endDay <= todayDay) {
                resultList.add(i + 1);
            }
        }
        
        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
    
    private int convertDay(String day) {
        String[] dayArray = day.split("\\.");
        return Integer.parseInt(dayArray[0]) * 12 * 28 + Integer.parseInt(dayArray[1]) * 28 + Integer.parseInt(dayArray[2]);
    }
}