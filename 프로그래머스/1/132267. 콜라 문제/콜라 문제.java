class Solution {
    public int solution(int a, int b, int n) {
        
        int nowCokeCount = n;
        int totalReturnCokeCount = 0; //페이백 받은 콜라 개수
        //반복을 돌림
        // 종료 조건은 더이상 빈병을 가져다 줄 수 없을 만큼 적을경우.
        while(nowCokeCount >= a) {
            //a의 배수 중, 가장 최대한 많이 가져다 주기
            int targetCokeCount = (nowCokeCount / a) * a;
            int nowReturnCokeCount = (targetCokeCount / a) * b;
            totalReturnCokeCount += nowReturnCokeCount;
            
            //배수 하고 남은건 저장해두기
            int remainCokeCount = nowCokeCount - targetCokeCount;
            
            //반환 오는거 더해서 현재 값에 저장해두기
            nowCokeCount = nowReturnCokeCount + remainCokeCount;
        }
        
        return totalReturnCokeCount;
    }
}