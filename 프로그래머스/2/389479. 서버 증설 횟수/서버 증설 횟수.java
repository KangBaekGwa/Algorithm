//시간 순서에 맞게 players 가 넘어오네.
//그럼, 서버 증설을 해두고, 그 서버의 수명 정보를 담아놓고 관리하면 될듯?

class Solution {
    
    public int solution(int[] players, int m, int k) {
        int[] timeToCleanUp = new int[players.length + k + 1]; // 인덱스 = 시간, 값은 그 시간에 감소해야 할 서버 개수
        int nowServerCount = 0;
        int scaleOutCount = 0;
        
        for(int time=0; time < players.length; time++) {
            //정리
            if(timeToCleanUp[time] > 0) {
                nowServerCount -= timeToCleanUp[time];
            }
            
            //필요한 서버 개수 확인
            int needServerCnt = needServerCount(players[time], m);
            int needToScaleOutCount = needServerCnt - nowServerCount;
            if(needServerCnt <= nowServerCount) continue;
            
            //여기부턴 서버 증설
            scaleOutCount += needToScaleOutCount;
            nowServerCount += needToScaleOutCount;
            timeToCleanUp[time + k] = needToScaleOutCount;
        }
        
        return scaleOutCount;
    }
    
    // 필요 서버 개수 확인
    private int needServerCount(int playerCount, int m) {
        if(playerCount < m) return 0;
        return playerCount / m;
    }
}