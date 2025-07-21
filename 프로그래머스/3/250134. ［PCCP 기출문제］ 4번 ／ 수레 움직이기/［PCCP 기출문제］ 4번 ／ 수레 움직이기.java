//bfs 로 찾으면 될듯?

import java.util.*;

class Solution {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public int solution(int[][] maze) {
        int maxY = maze.length;
        int maxX = maze[0].length;
        //x, y 저장
        int redStartX = 0, redStartY = 0;
        int redEndX = 0, redEndY = 0;
        int blueStartX = 0, blueStartY = 0;
        int blueEndX = 0, blueEndY = 0;
        
        // 색상별 시작/도착 지점 확인
        for(int y=0; y<maxY; y++) {
            for(int x=0; x<maxX; x++) {
                if(maze[y][x] == 1) {
                    redStartX = x;
                    redStartY = y;
                } else if(maze[y][x] == 2) {
                    blueStartX = x;
                    blueStartY = y;
                } else if(maze[y][x] == 3) {
                    redEndX = x;
                    redEndY = y;
                } else if(maze[y][x] == 4) {
                    blueEndX = x;
                    blueEndY = y;
                }
            }
        }
        
        Queue<State> q = new LinkedList<>();
        boolean[][] redVisited = new boolean[maxY][maxX];
        boolean[][] blueVisited = new boolean[maxY][maxX];
        redVisited[redStartY][redStartX] = true;
        blueVisited[blueStartY][blueStartX] = true;
        q.offer(new State(redStartX, redStartY, blueStartX, blueStartY, redVisited, blueVisited, 0));
        
        //bfs 를 진행하는데, 한 스텝에 두개의 아이템을 움직여야함.
        //현재 state 에서 움직일 수 있는 모든곳 확인해서 넣기.
        //2중 배열로, red 가 움직일수 있는 한곳 * blue가 움직일 수 있는 곳 으로 여러개 생성
        //중간에, 만약 도착 위치에 있다면, 움직이지 않기
        while(!q.isEmpty()) {
            State now = q.poll();
            
            if(now.nowRedPosX == redEndX && now.nowRedPosY == redEndY &&
               now.nowBluePosX == blueEndX && now.nowBluePosY == blueEndY) {
                return now.depth;
            }
            
            // 빨간 수레가 이동할 수 있는 위치들
            List<int[]> redMoves = new ArrayList<>();
            if(now.nowRedPosX == redEndX && now.nowRedPosY == redEndY) {
                redMoves.add(new int[]{now.nowRedPosX, now.nowRedPosY});
            } else {
                for(int i = 0; i < 4; i++) {
                    int newX = now.nowRedPosX + dx[i];
                    int newY = now.nowRedPosY + dy[i];
                    
                    if(isValidMove(newX, newY, maxX, maxY, maze) && !now.redVisited[newY][newX]) {
                        redMoves.add(new int[]{newX, newY});
                    }
                }
            }
            
            // 파란 수레가 이동할 수 있는 위치들
            List<int[]> blueMoves = new ArrayList<>();
            if(now.nowBluePosX == blueEndX && now.nowBluePosY == blueEndY) {
                blueMoves.add(new int[]{now.nowBluePosX, now.nowBluePosY});
            } else {
                for(int i = 0; i < 4; i++) {
                    int newX = now.nowBluePosX + dx[i];
                    int newY = now.nowBluePosY + dy[i];
                    
                    if(isValidMove(newX, newY, maxX, maxY, maze) && !now.blueVisited[newY][newX]) {
                        blueMoves.add(new int[]{newX, newY});
                    }
                }
            }
            
            for(int[] redMove : redMoves) {
                for(int[] blueMove : blueMoves) {
                    int redNewX = redMove[0], redNewY = redMove[1];
                    int blueNewX = blueMove[0], blueNewY = blueMove[1];
                    
                    if(redNewX == blueNewX && redNewY == blueNewY) continue;
                    
                    if(redNewX == now.nowBluePosX && redNewY == now.nowBluePosY &&
                       blueNewX == now.nowRedPosX && blueNewY == now.nowRedPosY) continue;
                    
                    boolean[][] newRedVisited = deepCopy(now.redVisited);
                    boolean[][] newBlueVisited = deepCopy(now.blueVisited);
                    
                    if(!(redNewX == redEndX && redNewY == redEndY)) {
                        newRedVisited[redNewY][redNewX] = true;
                    }
                    if(!(blueNewX == blueEndX && blueNewY == blueEndY)) {
                        newBlueVisited[blueNewY][blueNewX] = true;
                    }
                    
                    State nextState = new State(redNewX, redNewY, blueNewX, blueNewY, 
                                              newRedVisited, newBlueVisited, now.depth + 1);
                    
                    q.offer(nextState);
                }
            }
        }
        
        return 0;
    }
    
    private boolean isValidMove(int x, int y, int maxX, int maxY, int[][] maze) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY && maze[y][x] != 5;
    }
    
    private boolean[][] deepCopy(boolean[][] original) {
        boolean[][] copy = new boolean[original.length][];
        for(int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
    
    private static class State {
        private int nowRedPosX, nowRedPosY;
        private int nowBluePosX, nowBluePosY;
        private boolean[][] redVisited;
        private boolean[][] blueVisited;
        private int depth;
        
        public State(int nowRedPosX, int nowRedPosY, int nowBluePosX, int nowBluePosY, boolean[][] redVisited, boolean[][] blueVisited, int depth) {
            this.nowRedPosX = nowRedPosX;
            this.nowRedPosY = nowRedPosY;
            this.nowBluePosX = nowBluePosX;
            this.nowBluePosY = nowBluePosY;
            this.redVisited = redVisited;
            this.blueVisited = blueVisited;
            this.depth = depth;
        }
    }
}