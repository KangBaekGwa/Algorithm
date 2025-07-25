// 1,000,000 * 1,000,000? 최악의 조건?
// a b c d e e d c b a => 이런게 최대 1,000,000 자리까지 있는 경우가 가장 최악이
// stack? 인형쌓기?
// 하면, 한번만 반복해도 되네

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++) {
            char now = s.charAt(i);
            char lastChar = '1';
            if(!deque.isEmpty()) lastChar = deque.peekLast();
            
            if(now == lastChar) deque.pollLast();
            else deque.addLast(now);
        }
        
        return deque.size() == 0 ? 1 : 0;
    }
}