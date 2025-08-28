import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[score.length];
        
        for(int idx = 0; idx < score.length; idx++) {
            int nowScore = score[idx];
            pq.offer(nowScore);
            
            if(pq.size() > k) {
                pq.poll();
            }
            
            result[idx] = pq.peek();
        }
        
        return result;
    }
}