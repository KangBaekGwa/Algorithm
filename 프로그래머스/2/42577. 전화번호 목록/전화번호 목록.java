import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {        
        // 정렬해서 되는지 테스트
        // String[] test = new String[]{ "11", "111", "1" };
        // Arrays.sort(test);
        // for(int i=0; i<test.length; i++) {
        //     System.out.print(test[i] + ", ");
        // }
        
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}