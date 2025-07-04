import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length == 1) return new int[]{-1};
        
        int min = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        
        int index = 0;
        int[] result = new int[arr.length-1];
        for(int i=0; i<arr.length; i++) {
            if(i == minIndex) continue;
            result[index++] = arr[i];
        }
        return result;
    }
}