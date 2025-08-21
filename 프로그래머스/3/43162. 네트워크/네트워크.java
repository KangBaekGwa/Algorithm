class Solution {
    public int solution(int n, int[][] computers) {
        
        UnionFind uf = new UnionFind(n);
        
        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<computers[i].length; j++) {
                if(computers[i][j] == 1) uf.union(i, j);
            }
        }        
        return uf.countRoot();
    }
    
    private static class UnionFind {
        private int[] board;
        
        public UnionFind(int n) {
            this.board = new int[n];
            
            //자기 자신을 루트 노드로 기본 셋팅
            for(int i=0; i<n; i++) {
                board[i] = i;
            }
        }
        
        //n의 루트 노드를 찾는 것.
        //루트 노드는, 집합의 대표 번호
        public int find(int n) {
            if(board[n] == n) return n;
            return find(board[n]);
        }
        
        // a와 b를 같은 집합으로 묶는 작업
        // a를 루트로
        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            
            if(aRoot != bRoot) {
                board[bRoot] = aRoot;
            }
        }
        
        public void print() {
            System.out.print("board: ");
            for(int i=0; i<board.length; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
        }
        
        public int countRoot() {
            int cnt = 0;
            
            for(int i=0; i<board.length; i++) {
                int iRoot = find(i);
                if(iRoot == i) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
