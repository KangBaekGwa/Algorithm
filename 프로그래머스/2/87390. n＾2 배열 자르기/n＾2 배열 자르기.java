// left 나 right 좌표를 2차원 좌표로 변경할 수 있으면 될듯?

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left) + 1;
        int[] result = new int[size];
        
        int idx = 0;
        for(long l = left; l <= right; l++) {
            long y = l / (long)n;
            long x = l % (long)n;
            
            result[idx++] = (int) Math.max(x, y) + 1;
        }
        
        return result;
    }
}