// class Solution {
//     public String solution(int n, int t, int m, int p) {
//         StringBuilder sb = new StringBuilder();
//         StringBuilder result = new StringBuilder();
        
//         for(int number=0; number<=t; number++) {
//             sb.append(Integer.toString(number, n).toUpperCase());
//         }
        
//         int loopCnt = (sb.length() / m);
//         if(sb.length() % m >= p) loopCnt++;
        
//         for(int i = 0; i<loopCnt; i++) {
//             int idx = (i * m) + p - 1;
//             result.append(sb.toString().charAt(idx));
//         }
        
//         return result.toString();
//     }
// }

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        int num = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(num++, n).toUpperCase());
        }
        
        for (int i = 0; i < t; i++) {
            result.append(sb.charAt(i * m + p - 1));
        }
        return result.toString();

    }
}