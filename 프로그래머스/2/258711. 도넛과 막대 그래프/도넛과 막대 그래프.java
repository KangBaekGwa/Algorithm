import java.util.*;

class Solution {
    public static int[] solution(int[][] edges) {
        int donutCnt = 0, stickCnt = 0, eightCnt = 0, makedNode = 0;
        int N = 0;
        for (int i = 0; i < edges.length; i++) {
            N = Math.max(N, Math.max(edges[i][0], edges[i][1]));
        }

        ArrayList<Integer>[] map = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            map[edges[i][0]].add(edges[i][1]);
        }

        int[][] inOut = new int[N + 1][2];
        boolean[] nodes = new boolean[N + 1];

        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i][0]] = true;
            nodes[edges[i][1]] = true;
            inOut[edges[i][0]][0]++;
            inOut[edges[i][1]][1]++;
        }

        for (int i = 1; i <= N; i++) {
            if (inOut[i][1] == 0 && inOut[i][0] > 1) {
                makedNode = i;
                break;
            }
        }

        inOut[makedNode][1] = -1;
        inOut[makedNode][0] = -1;

        for (int i = 1; i <= N; i++) {
            if (inOut[i][0] == 2) {
                eightCnt++;
            } else if (inOut[i][1] > 0 && inOut[i][0] == 0) {
                stickCnt++;
            }
        }

        //나머지 하나는, 만들어진 node에서 연결된거 뺴기 8자, 막대 수량.
        donutCnt = map[makedNode].size() - eightCnt - stickCnt;

        return new int[] { makedNode, donutCnt, stickCnt, eightCnt };
    }
}