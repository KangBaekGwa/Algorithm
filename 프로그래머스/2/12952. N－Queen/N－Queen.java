import java.util.*;

class Solution {
    
    private static int count = 0;
    
    public int solution(int n) {
        boolean[][] map = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], true);
        }
        
        dfs(0, n, map);
        return count;
    }
    
    private void dfs(int y, int n, boolean[][] map) {
        if(y == n) {
            count++;
            return;
        }
        
        for(int x = 0; x < n; x++) {
            if(!map[y][x]) continue;
            
            boolean[][] nextMap = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                nextMap[i] = map[i].clone();
            }
            
            updateMap(nextMap, x, y, n);
            dfs(y + 1, n, nextMap);
        }
    }
    
    private void updateMap(boolean[][] map, int x, int y, int n) {
        for (int ny = y + 1; ny < n; ny++) {
            map[ny][x] = false;

            int diff = ny - y;

            if (x - diff >= 0) {
                map[ny][x - diff] = false;
            }

            if (x + diff < n) {
                map[ny][x + diff] = false;
            }
        }
    }
}