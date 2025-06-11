// long 을 각 자리수로 쪼개야됨.
// long -> String -> char -> 정렬 -> 합쳐서 String -> long 하면 될듯?
import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        List<Character> list = new ArrayList<>();
        for(char c : str.toCharArray()){
            list.add(c);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        str = "";
        for(char c : list) {
            str += c;
        }
        
        return Long.parseLong(str);
    }
}