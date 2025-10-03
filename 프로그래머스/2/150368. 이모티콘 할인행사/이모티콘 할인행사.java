class Solution {
    private static final int[] RATES = {10, 20, 30, 40};
    private int bestSubscribers = -1;
    private int bestRevenue = -1;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int m = emoticons.length;
        int[] assign = new int[m]; // 각 이모티콘에 부여한 할인율 인덱스(0..3)
        dfs(0, users, emoticons, assign);
        return new int[]{bestSubscribers, bestRevenue};
    }
    
    private void dfs(int idx, int[][] users, int[] emoticons, int[] assign) {
        if (idx == emoticons.length) {
            evaluate(users, emoticons, assign);
            return;
        }
        for (int r = 0; r < 4; r++) {
            assign[idx] = r;
            dfs(idx + 1, users, emoticons, assign);
        }
    }
    
    private void evaluate(int[][] users, int[] emoticons, int[] assign) {
        int subs = 0;
        int revenue = 0;
        
        for (int[] user : users) {
            int minRate = user[0];
            int limit   = user[1];
            int sum = 0;
            
            // 사용자 기준에 맞는 이모티콘만 구매
            for (int i = 0; i < emoticons.length; i++) {
                int rate = RATES[assign[i]];
                if (rate >= minRate) {
                    // 할인가 = 정가 * (100 - rate) / 100
                    sum += emoticons[i] * (100 - rate) / 100;
                }
            }
            
            if (sum >= limit) {
                subs++;
            } else {
                revenue += sum;
            }
        }
        
        // 우선: 구독자 수, 다음: 매출
        if (subs > bestSubscribers || (subs == bestSubscribers && revenue > bestRevenue)) {
            bestSubscribers = subs;
            bestRevenue = revenue;
        }
    }
}