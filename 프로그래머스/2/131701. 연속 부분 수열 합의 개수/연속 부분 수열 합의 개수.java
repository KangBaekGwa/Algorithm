import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sumSet = new HashSet<>();

        // 모든 시작점에 대해
        for (int start = 0; start < n; start++) {
            int sum = 0;

            // 길이 1부터 n까지
            for (int len = 1; len <= n; len++) {
                int idx = (start + len - 1) % n;
                sum += elements[idx];
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}
