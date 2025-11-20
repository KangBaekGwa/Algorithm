class Solution {
    public int[] solution(int n, int s) {
        //균등하게 분배
        int[] result = new int[n];
        
        int div = s/n;
        int rem = s%n; //나머지
        
        if(div == 0) return new int[]{-1}; //불가능
        
        for(int i=n-1; i>=0; i--) {
            result[i] = div;
            if(rem > 0) {
                result[i]++;
                rem--;
            }
        }
        
        return result;
    }
}