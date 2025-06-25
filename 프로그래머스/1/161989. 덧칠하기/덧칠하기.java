// 오 머리쓰는문제다
// 앞에서부터 칠하면 안되나 그냥?
// 최대 범위가 100,000 만큼
// 반복문 돌면서 하나씩 확인하고 칠하면 될 것 같은데?
// 훨신 적게 소모되긴 해서 상관없을듯?

class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int nowCovered = 0;
        for(int sec : section) {
            if(nowCovered >= sec) continue;
            
            nowCovered = sec + m - 1;
            count++;
        }
        
        return count;
    }
}