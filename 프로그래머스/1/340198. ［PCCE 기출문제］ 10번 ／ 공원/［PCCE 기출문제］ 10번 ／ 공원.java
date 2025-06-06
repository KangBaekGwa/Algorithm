import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;

        Integer[] matsObj = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(matsObj, Collections.reverseOrder());

        for (int i = 0; i < matsObj.length; i++) {   // 0부터 시작, 내림차순
            int size = matsObj[i];

            for (int y = 0; y <= n - size; y++) {
                for (int x = 0; x <= m - size; x++) {
                    if (possible(park, y, x, size)) {
                        return size;
                    }
                }
            }
        }
        return -1;
    }

    private boolean possible(String[][] park, int y, int x, int size) {
        for (int dy = 0; dy < size; dy++) {
            for (int dx = 0; dx < size; dx++) {
                if (!park[y + dy][x + dx].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}
