class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
            int cnt = 0;
            int now = prices[i];
            for(int j=i+1; j<prices.length; j++) {
                int next = prices[j];
                
                cnt++;
                
                if(now > next) break;
            }
            result[i] = cnt;
        }
        
        return result;
    }
}