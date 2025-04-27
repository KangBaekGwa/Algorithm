class Solution {
    
    public static final String ODD = "Odd";
    public static final String EVEN = "Even";
    
    public String solution(int num) {
        return num%2 == 0 ? EVEN : ODD;
    }
}