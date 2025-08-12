import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxSave = 0;
        int sum = 0;
        int maxIdx = 0;

        int[][] map = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            int nowDistance = calDistance(map[i], map[i + 1]);
            sum += nowDistance;

            // 처음과 마지막 체크포인트는 건너뛰기 불가
            if (i == 0 || i == n - 1) continue;

            // 절약 거리 계산
            int save = calDistance(map[i - 1], map[i]) 
                     + calDistance(map[i], map[i + 1]) 
                     - calDistance(map[i - 1], map[i + 1]);

            if (save > maxSave) {
                maxSave = save;
                maxIdx = i;
            }
        }

        System.out.println(sum - maxSave);
        // 필요 시 건너뛴 인덱스 확인
        // System.out.println("건너뛴 체크포인트 인덱스: " + maxIdx);
    }

    private static int calDistance(int[] from, int[] to) {
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }
}
