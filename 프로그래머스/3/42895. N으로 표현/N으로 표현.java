import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

        for (int cnt = 1; cnt <= 8; cnt++) {
            Set<Integer> cur = dp.get(cnt);

            // 1) cnt개 연속 N (예: 5, 55, 555 ...)
            int concat = 0;
            for (int k = 0; k < cnt; k++) concat = concat * 10 + N;
            cur.add(concat);

            // 2) 분할 결합: cnt = left + right
            for (int left = 1; left < cnt; left++) {
                int right = cnt - left;
                Set<Integer> A = dp.get(left);
                Set<Integer> B = dp.get(right);

                for (int a : A) {
                    for (int b : B) {
                        cur.add(a + b);
                        cur.add(a - b);
                        cur.add(b - a);
                        cur.add(a * b);
                        if (b != 0) cur.add(a / b);
                        if (a != 0) cur.add(b / a);
                    }
                }
            }

            if (cur.contains(number)) return cnt;
        }
        return -1;
    }
}
