import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dic = new HashMap<>();
        
        for(int i=0; i<26; i++) {
            char alp = (char)('A' + i);
            dic.put(String.valueOf(alp), i + 1);
        }
        
        Stack<String> msgStack = new Stack<>();
        for (int i = msg.length() - 1; i >= 0; i--) {
            msgStack.push(String.valueOf(msg.charAt(i)));
        }
        
        List<Integer> resultList = new ArrayList<>();
        int nowIndexNumb = 27;
        while (!msgStack.isEmpty()) {
            // 1. msgStack에서, 최초로 dic에서 못찾는 거 나올 때까지 빼서 string 만들기
            StringBuilder keySb = new StringBuilder();
            boolean added = false;
            
            while (!msgStack.isEmpty()) {
                String nowW = msgStack.pop();
                keySb.append(nowW);
                if (!dic.containsKey(keySb.toString())) {
                    msgStack.push(nowW);
                    dic.put(keySb.toString(), nowIndexNumb++);
                    added = true;
                    break;
                }
            }
            
            String key = added
                    ? keySb.substring(0, keySb.length() - 1)
                    : keySb.toString();
            
            resultList.add(dic.get(key));
        }
        
        // 변환 후, 응답
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}