class Solution {
    
    private static final int[] result = new int[]{6, 6, 5, 4, 3, 2, 1}; //index 개 맞췄을때의 등수
    
    public int[] solution(int[] lottos, int[] win_nums) {
        //못알아본 숫자 수량
        int blankCnt = 0;
        for(int lotto : lottos) {
            if(lotto == 0) blankCnt++;
        }
        
        //현재 기본 개수 확인
        int badCnt = 0;
        for(int i = 0; i < lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    badCnt++;
                }
            }
        }
        
        int goodCnt = badCnt + blankCnt;
        
        return new int[]{result[goodCnt], result[badCnt]};
    }
}