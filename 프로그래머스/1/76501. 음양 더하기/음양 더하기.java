// signs에 따라서 + 할지 - 할지 결정하면 될듯

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int result = 0;
        for(int i=0; i<absolutes.length; i++) {
            if(signs[i] == true) result += absolutes[i];
            else result -= absolutes[i];
        }
        
        return result;
    }
}