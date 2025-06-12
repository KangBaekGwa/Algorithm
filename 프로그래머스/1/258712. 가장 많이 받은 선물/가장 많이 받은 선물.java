//알고리즘이 없는 그냥 구현문제 인듯?
//선물을 주고 받기 위해, 알아야 될 정보는?
//상대방이 나에게 얼만큼 선물을 줬는가? 내가 상대방에게 얼만큼 선물을 줬는가?
//상대방과 나의 선물 점수는 얼마인가?

// A -> B 2개 선물을 어떻게 저장할까?
    // A = 1, B=2 라고 인덱스를 주어주고, gitfCount[to][from] 2차원 배열에 저장.
    // 즉, gitfCount[1][2] == 2 라면, 1번인덱스 a가, 2번인덱스 b에게 2개 선물

// 나의 선물 지수는 배열로 관리. index 알고있으니 ㄱㅊ을듯
// 나의 index 번호도 map 으로 관리. (key-value 가 매칭하기 편할듯)

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> nameToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) nameToIdx.put(friends[i], i);

        int[][] giftCount = new int[n][n];
        int[] giftScore = new int[n];

        for (String gift : gifts) {
            String[] arr = gift.split(" ");
            int from = nameToIdx.get(arr[0]);
            int to = nameToIdx.get(arr[1]);
            giftCount[from][to]++;
            giftScore[from]++;  // 보낸 사람 +1
            giftScore[to]--;    // 받은 사람 -1
        }

        int[] nextMonthGifts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (giftCount[i][j] > giftCount[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftCount[i][j] == giftCount[j][i] && giftScore[i] > giftScore[j]) {
                    nextMonthGifts[i]++;
                }
            }
        }

        int answer = 0;
        for (int v : nextMonthGifts) answer = Math.max(answer, v);
        return answer;
    }
}
