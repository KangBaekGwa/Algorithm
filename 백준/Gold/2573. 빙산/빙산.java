//빙산이 두덩이로 갈라진걸 어떻게 확인하면 좋을까?
//빙산이 녹지 않고 현재 있는곳 기준으로 bfs/dfs 를 해서, 총 갯수를 체크.
//빙산이 녹지 않고 현재 있는곳의 총 count 와 비교
    //같으면 아직 한덩이
    //같지 않으면 2덩이 이상
//같으면, 녹여버리기

//필요한거
    // 현재 빙산의 맵
    // 빙산의 위치를 확인할 수 있는 변수

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private static int[][] map;
    private static Queue<Position> bingInfo = new LinkedList<>();
    private static int maxY; //y
    private static int maxX; //x
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        maxY = sc.nextInt();
        maxX = sc.nextInt();

        initBingMap();
        System.out.println(findDivideYear());
    }

    private static int findDivideYear() {
        if(isDivided()) return 0;
        int year = 1;

        while(true) {
            if(bingInfo.isEmpty()) return 0;
            meltingBing();
            if(isDivided()) return year;
            year++;
        }
    }

    private static boolean isDivided() {
        Position position = bingInfo.peek();
        if(position == null) return false;
        long totalCount = bingInfo.size();
        long findCount = 0;
        boolean[][] visited = new boolean[maxY][maxX];
        Queue<Position> q = new LinkedList<>();

        q.add(position);
        visited[position.getY()][position.getX()] = true;
        findCount++;

        while(!q.isEmpty()) {
            Position nowPos = q.poll();

            for(int dir=0; dir<4; dir++) {
                int nextY = nowPos.getY() + dy[dir];
                int nextX = nowPos.getX() + dx[dir];

                if(nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY) continue;
                if(visited[nextY][nextX]) continue;
                if(map[nextY][nextX] <= 0) continue;

                visited[nextY][nextX] = true;
                findCount++;
                q.add(new Position(nextX, nextY));
            }
        }

        return findCount != totalCount;
    }

    private static void meltingBing() {
        //bingInfo, map 초기화 진행 녹은상태로
        Queue<Position> bingInfoCopy = new LinkedList<>(bingInfo);
        int[][] mapCopy = new int[maxY][maxX];
        for (int i = 0; i < maxY; i++) {
            mapCopy[i] = Arrays.copyOf(map[i], maxX);
        }

        for (Position position : bingInfoCopy) {
            int x = position.getX();
            int y = position.getY();

            int meltingCount = 0;
            for(int dir=0; dir<4; dir++) {
                int nextX = x + dx[dir];
                int nextY = y + dy[dir];
                if(nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY) continue;
                if(mapCopy[nextY][nextX] > 0) continue;
                meltingCount++;
            }
            map[y][x] -= meltingCount; //1년 지나서, 차감
            if(map[y][x] <= 0) bingInfo.remove(position);
        }
    }

    private static void initBingMap() {
        map = new int[maxY][maxX];

        for(int y=0; y<maxY; y++) {
            for(int x=0; x<maxX; x++) {
                map[y][x] = sc.nextInt();
                if(map[y][x] != 0) bingInfo.add(new Position(x, y));
            }
        }
    }

    private static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
