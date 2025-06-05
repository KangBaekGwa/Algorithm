// 3개 일때는?
// 2개짜리 탑을 2번에 세워야함
// 1개를 3번탑에 그리고, 2개를 3번 탑에

import java.util.*;

class Solution {
    List<int[]> answer = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        // List<int[]> → int[][]
        int[][] result = new int[answer.size()][2];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
    
    private void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, via, to);
        answer.add(new int[]{from, to});
        hanoi(n - 1, via, to, from);
    }
}