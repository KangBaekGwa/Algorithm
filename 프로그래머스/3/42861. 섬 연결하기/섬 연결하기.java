// 전부 다 확인하기에는 너무 많음 ㅠ
// 그래프?
// union-find 까지는 굳이?
// 가장 비용이 적은 것 대로 정렬을 해서 나열을 한다면?
// 그리고 초기에는 다리는 0 이니깐, 연결 된 대로, list 로 관리해서 그걸 넣는다면?
// 근데 그게 과연 항상 옳은 방법?
// 그게 맞는거 아냐?
// N개가 있으면 다리는 최소 N개는 놔야함.
// 쭉 반복해서 넣다가 list 에 N개만큼 차는 순간 다 연결된거 아냐?
// 이렇게 되면, 섬이 전체 하나로 연결됬는지 유무는 확인이 불가능하네.
// 결국 union-find 해야할듯?

import java.util.*;

class Solution {
        class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int solution(int n, int[][] costs) {

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] c : costs) {
            int from = c[0];
            int to = c[1];
            int cost = c[2];

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost
        );

        pq.add(new Edge(0, 0));
        int answer = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            answer += cur.cost;

            for (Edge next : graph[cur.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        return answer;
    }
}
    
//     public int solution(int n, int[][] costs) {
//         PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getCost(), b.getCost()));
//         boolean[] isConnected = new boolean[n];
//         int connectCount = 0;
//         int totalCost = 0;
        
//         for(int[] cost : costs) {
//             pq.offer(new Edge(cost));
//         }
        
//         while(true) {
//             Edge nowEdge = pq.poll();
//             int start = nowEdge.getStart();
//             int end = nowEdge.getEnd();
            
//             // 이미 두개 다 섬이 연결된 상태면 굳이 할 필요가 없음 여기는
//             if(isConnected[start] && isConnected[end]) continue;
            
//             // 이제 섬 연결하기.
//             if(!isConnected[start]) {
//                 connectCount++;
//                 isConnected[start] = true;
//             }
            
//             if(!isConnected[end]) {
//                 connectCount++;
//                 isConnected[end] = true;
//             }
            
//             totalCost += nowEdge.getCost();
            
//             if(connectCount == n) break;
//         }
        
//         return totalCost;
//     }
    
//     private class Edge { 
//         private int start;
//         private int end;
//         private int cost;
        
//         public Edge(int[] info) {
//             this.start = info[0];
//             this.end = info[1];
//             this.cost = info[2];
//         }
        
//         public int getStart() { return this.start; }
//         public int getEnd() { return this.end; }
//         public int getCost() { return this.cost; }
//     }
// }