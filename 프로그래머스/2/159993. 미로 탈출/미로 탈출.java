//가장 빠른 길찾기 인데, 중간에 무조건 들러야 되는 경유지가 있다.
//그럼 경유지까지 가장 빠르게 들리는게 항상 이득인가?
//맞음. 단, 경유지 (레버)가 여러개라면? 조금 다를수도? => 한개만 존재 한다고 한다.
//그럼 bfs 로 레버까지 찾아서 min 계산하고.
//레버 위치에서, 시작지점으로 가는 bfs 계산
//이때, visited 배열은 bfs 마다 초기화해서 사용해야됨. [S O E O L] 이럴때, 끝가지 왔다가 다시 가운데로 가야됨.

import java.util.*;

class Solution {
    private int N, M;
    private final int[] dy = {-1,1,0,0};
    private final int[] dx = {0,0,-1,1};

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        char[][] map = new char[N][M];
        int sy=0, sx=0, ly=0, lx=0, ey=0, ex=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') { sy=i; sx=j; }
                if(map[i][j] == 'L') { ly=i; lx=j; }
                if(map[i][j] == 'E') { ey=i; ex=j; }
            }
        }

        int toL = bfs(map, sy, sx, 'L');
        if(toL == -1) return -1;
        int toE = bfs(map, ly, lx, 'E');
        if(toE == -1) return -1;
        return toL + toE;
    }

    int bfs(char[][] map, int sy, int sx, char target) {
        boolean[][] visited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sy, sx, 0));
        visited[sy][sx] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();
            if(map[p.y][p.x] == target) return p.dist;
            for(int d=0; d<4; d++) {
                int ny = p.y + dy[d];
                int nx = p.x + dx[d];
                if(ny<0||nx<0||ny>=N||nx>=M) continue;
                if(map[ny][nx]=='X' || visited[ny][nx]) continue;
                visited[ny][nx]=true;
                q.add(new Point(ny, nx, p.dist+1));
            }
        }
        return -1;
    }
    
    private static class Point {
        int y, x, dist;
        Point(int y, int x, int dist) {
            this.y = y; this.x = x; this.dist = dist;
        }
    }
}