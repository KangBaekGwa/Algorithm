import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
        }
        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int value = r[2];
            if (value < map[from][to]) {
                // 양방향 간선
                map[from][to] = value;
                map[to][from] = value;
            }
        }

        // 2. 다익스트라 (배열 스캔 방식 O(N^2))
        int[] dist = new int[N + 1];
        boolean[] vis = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int iter = 1; iter <= N; iter++) {
            int u = -1, best = Integer.MAX_VALUE;
            for (int v = 1; v <= N; v++) {
                if (!vis[v] && dist[v] < best) {
                    best = dist[v];
                    u = v;
                }
            }
            if (u == -1) break; // 더 이상 갱신 없음
            vis[u] = true;

            for (int v = 1; v <= N; v++) {
                if (map[u][v] == Integer.MAX_VALUE) continue;
                int nd = dist[u] + map[u][v];
                if (nd < dist[v]) dist[v] = nd;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) if (dist[i] <= K) cnt++;
        return cnt;
    }
}
