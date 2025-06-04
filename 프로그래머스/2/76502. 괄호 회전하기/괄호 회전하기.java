import java.util.*;

class Solution {
    public int solution(String s) { 
        
        int count = 0;
        
        for(int i=0; i<s.length(); i++) {
            char firstChar = s.charAt(0);
            s = s.substring(1, s.length());
            s = s + firstChar;
            boolean isCheck = check(s);
            
            if(isCheck == true) {
                count++;
            }
        }
        return count;
    }
    
    private boolean check(String s) {
        Stack<Character> st = new Stack<>();
        
        for(Character c : s.toCharArray()) {
            // 시작하는 괄호 타입이면, 그냥 넣으면 된다.
            if(c.equals('[') || c.equals('{') || c.equals('(')) {
                st.push(c);
                continue;
            }
            
            // 시작하는 괄호가 없는데, 닫는 괄호부터 오는 경우... return false
            if(st.empty()) return false;
            
            Character lastC = st.peek();
            if((lastC.equals('[') && c.equals(']')) ||
               (lastC.equals('{') && c.equals('}')) ||
               (lastC.equals('(') && c.equals(')')))
            {
                st.pop();
                continue;
            }
            
            // stack. 마지막에 '['이게 있는데, 이번에 들어온건 } 혹은 ) 인 경우 여기까지 흘러옴
            return false;
        }
        
        if(st.empty() == true) {
            return true;
        }
        return false;
    }
}

///
// EX1) "[](){}"
// } ] )
// stack, 마지막에 넣은 괄호가 어떤건지 확인
// {, [, (
// 
//