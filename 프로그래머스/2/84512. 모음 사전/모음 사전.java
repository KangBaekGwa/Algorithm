class Solution {
    
    private static final String words[] = {"A", "E", "I", "O", "U"};
    private int result = 0;
    private boolean isFind = false;
    
    public int solution(String word) {
        search(word, "", 0);
        return result - 1;
    }
    
    private void search(String target, String currentStr, int depth) {
        if(depth > 5 || isFind) return;
        
        result++;
        if(target.equals(currentStr)) {
            isFind = true;
            return;
        }
        
        for(String word : words) {
            search(target, currentStr + word, depth + 1);
        }
    }
}