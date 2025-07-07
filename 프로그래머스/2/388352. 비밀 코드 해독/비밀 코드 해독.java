// 조합 생성해서, contains 로 비교?
// 최대 30 개중, 5개를 뽑는 조합
// 최대 몇개? 모르는디? 이건 검색

import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> combList = makeCombinations(n, 5, 1, 0, new int[5]);

        int answer = 0;
        for (int[] comb : combList) {
            if (isValid(comb, q, ans)) answer++;
        }
        return answer;
    }

    private List<int[]> makeCombinations(int n, int k, int start, int depth, int[] picked) {
        List<int[]> result = new ArrayList<>();
        if (depth == k) {
            result.add(Arrays.copyOf(picked, k));
            return result;
        }
        int remain = k - depth;
        for (int i = start; i <= n - remain + 1; i++) {
            picked[depth] = i;
            result.addAll(makeCombinations(n, k, i + 1, depth + 1, picked));
        }
        return result;
    }

    private boolean isValid(int[] picked, int[][] q, int[] ans) {
        Set<Integer> pickedSet = new HashSet<>();
        for (int x : picked) pickedSet.add(x);

        for (int i = 0; i < q.length; i++) {
            int count = 0;
            for (int y : q[i]) {
                if (pickedSet.contains(y)) count++;
            }
            if (count != ans[i]) return false;
        }
        return true;
    }
}

