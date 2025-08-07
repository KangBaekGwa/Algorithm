class Solution {
    private final int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        divDfs(arr, 0, 0, arr[0].length, arr.length);
        return answer;
    }

    private void divDfs(int[][] a, int sx, int sy, int ex, int ey) {
        if (isSame(a, sx, sy, ex, ey)) {
            answer[a[sx][sy]]++;
            return;
        }
        int mx = (sx + ex) / 2;
        int my = (sy + ey) / 2;

        divDfs(a, sx, sy, mx, my);
        divDfs(a, sx, my, mx, ey);
        divDfs(a, mx, sy, ex, my);
        divDfs(a, mx, my, ex, ey);
    }

    private boolean isSame(int[][] a, int sx, int sy, int ex, int ey) {
        int v = a[sx][sy];
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if (a[i][j] != v) return false;
            }
        }
        return true;
    }
}