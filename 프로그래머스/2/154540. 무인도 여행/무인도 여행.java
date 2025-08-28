// 맵 돌아가면서, 검사
// 땅찾으면 bfs 실시
// visisted 는 전역적으로 사용할 것.

import java.util.*;

class Solution {
    public static final int[] dx = {-1, 0, 1, 0};
    public static final int[] dy = {0, -1, 0, 1};
    public static int maxX = 0;
    public static int maxY = 0;
        
    public int[] solution(String[] maps) {
        maxX = maps[0].length();
        maxY = maps.length;
        char[][] map = new char[maxY][maxX];
        boolean[][] visited = new boolean[maxY][maxX];
        
        for(int y=0; y<maxY; y++) {
            char[] mapCharArray = maps[y].toCharArray();
            for(int x=0; x < maxX; x++) {
                map[y][x] = mapCharArray[x];
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int y=0; y<maxY; y++) {
            for(int x=0; x < maxX; x++) {
                if(map[y][x] != 'X' && !visited[y][x]) {
                    result.add(dfs(x, y, visited, map));
                }
            }
        }
        
        if(result.size() == 0) return new int[]{-1};
        
        Collections.sort(result);
        int[] r = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            r[i] = result.get(i);
        }
        
        return r;
    }
    
    public int dfs(int nowX, int nowY, boolean[][] visited, char[][] map) {
        visited[nowY][nowX] = true;
        int result = map[nowY][nowX] - '0';
        
        for(int i=0; i<4; i++) {
            int ny = nowY + dy[i];
            int nx = nowX + dx[i];
            
            if(nx < 0 || nx >= maxX || ny < 0 || ny >= maxY) continue;
            if(visited[ny][nx] || map[ny][nx] == 'X') continue;
            
            result += dfs(nx, ny, visited, map);
        }
        
        return result;
    }
}