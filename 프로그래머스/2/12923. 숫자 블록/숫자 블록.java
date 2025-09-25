// 각 자리수는 end 까지 중, 각자의 자신을 제외한 최대약수 아냐?
// 10까지 있을때
// 

class Solution {
    private static final int LIMIT = 10_000_000;

    public int[] solution(long begin, long end) {
        int range = (int) (end - begin + 1);
        int[] result = new int[range];

        for (int idx = 0; idx < range; idx++) {
            int x = (int)begin + idx;

            if (x == 1) {
                result[idx] = 0;
            } else {
                result[idx] = calc(x);
            }
        }
        return result;
    }

    private int calc(int x) {
        int best = 1;
        int r = (int) Math.sqrt(x);

        for (int i = 2; i <= r; i++) {
            if (x % i != 0) continue;
            int pair = x / i;
            if (pair <= LIMIT) return pair;
            if (i <= LIMIT && i > best) best = i;
        }
        return best;
    }
}
