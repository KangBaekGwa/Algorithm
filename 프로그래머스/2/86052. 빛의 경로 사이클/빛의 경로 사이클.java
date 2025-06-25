import java.util.*;

class Solution {
    private final int[] dy = {-1, 0, 1, 0};
    private final int[] dx = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        int h = grid.length;
        int w = grid[0].length();
        Set<Light> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                for (int dir = 0; dir < 4; dir++) {
                    Light start = new Light(y, x, dir);
                    if (visited.contains(start)) continue;

                    int cnt = 0;
                    int cy = y, cx = x, cd = dir;

                    while (true) {
                        Light current = new Light(cy, cx, cd);
                        if (visited.contains(current)) break;

                        visited.add(current);
                        cnt++;

                        cy = (cy + dy[cd] + h) % h;
                        cx = (cx + dx[cd] + w) % w;

                        char command = grid[cy].charAt(cx);
                        if (command == 'L') {
                            cd = (cd + 3) % 4;
                        } else if (command == 'R') {
                            cd = (cd + 1) % 4;
                        }

                        if (cy == y && cx == x && cd == dir) break;
                    }

                    if (cnt > 0) result.add(cnt);
                }
            }
        }

        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    private static class Light {
        private final int y;
        private final int x;
        private final int dir;

        Light(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Light)) return false;
            Light l = (Light) o;
            return y == l.y && x == l.x && dir == l.dir;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x, dir);
        }
    }
}