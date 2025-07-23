// 맨앞이 가장 큰수가 나와야함.
// 그다음도 남은 것 중 가장 큰수
// 숫자를 앞에서부터 넣는데, 이전에 넣은것보다 더 큰 수가 나오면? 이전꺼 삭제
  // 이걸 k 만큼 반복?
  // k만큼 반복하면 안됨. 전부 다 확인해야됨.
//1924, k = 2
//1
//1, 9 => 9
//9, 2
//9, 2, 4 => 9, 4

//1111991, k = 2
//1
//1, 1
//1, 1
//1, 1

public class Solution {
    public String solution(String number, int k) {
        int[] resultArray = new int[number.length()];
        int targetLen = number.length() - k;
        int left = -1;

        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(number.substring(i, i+1));
            while (left >= 0 && k > 0 && resultArray[left] < digit) {
                left--;
                k--;
            }
            resultArray[++left] = digit;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targetLen; i++) {
            sb.append(resultArray[i]);
        }
        return sb.toString();
    }
}