import java.util.*;

class Solution {
    public void combine(String now, List<String> combineList, String[] menuArray, int nowIdx) {
        if(now.length() >= 2) combineList.add(now);
        
        for(int i=nowIdx; i < menuArray.length; i++) {
            combine(now + menuArray[i], combineList, menuArray, i+1);
        }
    }
        
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> history = new HashMap<>();
        
        // orders 돌며, 조합 생성.
        for(String order : orders) {
            String[] menuArray = order.split("");
            List<String> combineList = new ArrayList<>();
            combine("", combineList, menuArray, 0);
            
            for(String combine : combineList) {
                char[] arr = combine.toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);
                history.put(key, history.getOrDefault(key, 0) + 1);
            }
        }
        
        List<String> resultList = new ArrayList<>();

        for (int len : course) {
            int max = 0;

            for (Map.Entry<String, Integer> entry : history.entrySet()) {
                if (entry.getKey().length() == len && entry.getValue() > 1) {
                    max = Math.max(max, entry.getValue());
                }
            }

            for (Map.Entry<String, Integer> entry : history.entrySet()) {
                if (entry.getKey().length() == len && entry.getValue() == max) {
                    resultList.add(entry.getKey());
                }
            }
        }

        Collections.sort(resultList);
        String[] result = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        
        return result;
    }
}
