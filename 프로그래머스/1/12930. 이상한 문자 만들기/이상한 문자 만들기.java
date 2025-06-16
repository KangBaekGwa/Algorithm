//각 단어로 쪼개야됨
//단어별로 쪼개서, 변환하는 메서드가 있어야함

import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sToken = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < sToken.length; i++) {
            sb.append(transfer(sToken[i]));
            if (i < sToken.length - 1) sb.append(" "); // 단어 사이 공백 추가
        }
        
        return sb.toString();
    }
    
    private String transfer(String str) {
        if( str.isBlank() ) return str;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append(i % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }
        return sb.toString();
    }
}