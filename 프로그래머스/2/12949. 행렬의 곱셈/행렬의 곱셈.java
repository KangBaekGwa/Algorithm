class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int X = arr1.length;
        int K = arr1[0].length;
        int Y = arr2[0].length;

        int[][] answer = new int[X][Y];

        for (int x = 0; x < X; x++) {
            int[] aRow = arr1[x];
            int[] cRow = answer[x];
            for (int k = 0; k < K; k++) {
                int a = aRow[k];
                int[] bRow = arr2[k];
                for (int y = 0; y < Y; y++) {
                    cRow[y] += a * bRow[y];
                }
            }
        }
        return answer;
    }
}