import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        // dp[j] = A 도둑이 j개의 흔적을 남겼을 때, B 도둑이 남긴 흔적의 최솟값
        int[] dp = new int[n];

        // 도달할 수 없는 상태를 표현하기 위해 아주 큰 값을 사용 (무한대)
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 초기 상태: A 흔적이 0개일 때 B 흔적도 0개
        // dp[10] = 20; A 흔적이 10일때 최소 B 흔적은 20;
        dp[0] = 0;

        // 각 물건을 순회하며 누가 훔칠지 결정
        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];
            
            // 다음 상태를 저장할 배열. Integer.MAX_VALUE 초기화하여 이전 상태와 완전히 분리
            int[] nextDp = new int[n];
            Arrays.fill(nextDp, Integer.MAX_VALUE);
            
            // 0부터 n-1까지 모든 가능한 A의 이전 흔적 상태를 확인
            for (int j = 0; j < n; j++) {
                // 이전 상태(dp[j])가 도달 가능할 때만 다음 상태로 전이 가능
                if (dp[j] == Integer.MAX_VALUE) {
                    continue;
                }
                
                // 경우 1: B가 현재 물건을 훔치는 경우
                int bIfBSteals = dp[j] + bTrace;
                nextDp[j] = Math.min(nextDp[j], bIfBSteals);
                
                // 경우 2: A가 현재 물건을 훔치는 경우
                int newATrace = j + aTrace;
                if (newATrace < n) {
                    int bIfASteals = dp[j];
                    nextDp[newATrace] = Math.min(nextDp[newATrace], bIfASteals);
                }
            }
            dp = nextDp;
        }

        for (int j = 0; j < n; j++) {
            if (dp[j] < m) {
                return j;
            }
        }

        return -1;
    }
}


// 테스트 케이스 #1 추적
// 입력: info = [[1, 2], [2, 3], [2, 1]], n = 4, m = 4

// 1. 초기 상태
// 코드가 시작되면 dp 배열이 n의 크기인 4로 생성되고 초기화됩니다.

// dp[0] = 0 : 아무것도 훔치기 전, A 흔적 0개일 때 B 흔적도 0개입니다.

// dp[1], dp[2], dp[3]는 Integer.MAX_VALUE (편의상 INF로 표기) : 아직 불가능한 상태입니다.

// 시작 dp 배열: [0, INF, INF, INF]

// 2. 첫 번째 물건 [1, 2] 처리 (aTrace=1, bTrace=2)
// 새로운 상태를 기록할 nextDp 배열을 [INF, INF, INF, INF]로 만듭니다. 이제 이전 dp 배열을 보며 nextDp를 채웁니다.

// for 루프에서 j = 0일 때: (dp[0]은 0이므로 실행)

// B가 훔칠 경우: A 흔적은 j=0 그대로, B 흔적은 dp[0] + 2 = 2가 됩니다.

// nextDp[0]에 2를 기록합니다. nextDp는 [2, INF, INF, INF]가 됩니다.

// A가 훔칠 경우: A 흔적은 j+1=1, B 흔적은 dp[0]=0 그대로입니다.

// nextDp[1]에 0을 기록합니다. nextDp는 [2, 0, INF, INF]가 됩니다.

// j = 1, 2, 3일 때는 dp[j]가 INF이므로 아무 일도 일어나지 않습니다.

// 첫 번째 물건 처리가 끝나고, dp는 nextDp 값으로 업데이트됩니다.

// dp 배열 상태: [2, 0, INF, INF]

// 해석: 물건 하나를 훔친 뒤, A 흔적이 0개이면(B가 훔침) B 흔적은 2, A 흔적이 1개이면(A가 훔침) B 흔적은 0이 됩니다.

// 3. 두 번째 물건 [2, 3] 처리 (aTrace=2, bTrace=3)
// 다시 nextDp 배열을 [INF, INF, INF, INF]로 준비합니다. 이제 dp = [2, 0, INF, INF]를 보며 nextDp를 채웁니다.

// j = 0일 때: (dp[0]은 2이므로 실행)

// B가 훔칠 경우: A 흔적 0, B 흔적은 dp[0] + 3 = 2 + 3 = 5가 됩니다.

// nextDp[0]에 5를 기록합니다. nextDp는 [5, INF, INF, INF]가 됩니다.

// A가 훔칠 경우: A 흔적 0+2=2, B 흔적은 dp[0]=2 그대로입니다.

// nextDp[2]에 2를 기록합니다. nextDp는 [5, INF, 2, INF]가 됩니다.

// j = 1일 때: (dp[1]은 0이므로 실행)

// B가 훔칠 경우: A 흔적 1, B 흔적은 dp[1] + 3 = 0 + 3 = 3이 됩니다.

// nextDp[1]에 3을 기록합니다. nextDp는 [5, 3, 2, INF]가 됩니다.

// A가 훔칠 경우: A 흔적 1+2=3, B 흔적은 dp[1]=0 그대로입니다.

// nextDp[3]에 0을 기록합니다. nextDp는 [5, 3, 2, 0]이 됩니다.

// 두 번째 물건 처리가 끝나고 dp가 업데이트됩니다.

// dp 배열 상태: [5, 3, 2, 0]

// 해석: 물건 두 개를 훔친 뒤, 가능한 (A흔적, B최소흔적) 조합은 (0, 5), (1, 3), (2, 2), (3, 0) 입니다.

// 4. 세 번째 물건 [2, 1] 처리 (aTrace=2, bTrace=1)
// 마지막으로 nextDp를 [INF, INF, INF, INF]로 준비하고, dp = [5, 3, 2, 0]를 보며 채웁니다.

// j = 0일 때 (dp[0]=5):

// B가 훔치면 (A:0, B: 5+1=6) -> nextDp[0] = 6

// A가 훔치면 (A:2, B: 5) -> nextDp[2]에 5 기록. nextDp는 [6, INF, 5, INF]

// j = 1일 때 (dp[1]=3):

// B가 훔치면 (A:1, B: 3+1=4) -> nextDp[1] = 4

// A가 훔치면 (A:3, B: 3) -> nextDp[3]에 3 기록. nextDp는 [6, 4, 5, 3]

// j = 2일 때 (dp[2]=2):

// B가 훔치면 (A:2, B: 2+1=3) -> nextDp[2]는 min(5, 3) = 3으로 갱신! (더 좋은 방법 발견)

// A가 훔치면 (A:2+2=4) -> n보다 작지 않으므로 무시.

// j = 3일 때 (dp[3]=0):

// B가 훔치면 (A:3, B: 0+1=1) -> nextDp[3]는 min(3, 1) = 1으로 갱신!

// A가 훔치면 (A:3+2=5) -> n보다 작지 않으므로 무시.

// 모든 물건 처리가 끝났습니다.

// 최종 dp 배열 상태: [6, 4, 3, 1]

// 5. 결과 반환
// 이제 마지막 for 루프가 최종 dp 배열을 확인하며 답을 찾습니다. m은 4입니다.

// j = 0: dp[0]은 6. 6 < 4는 거짓.

// j = 1: dp[1]은 4. 4 < 4는 거짓.

// j = 2: dp[2]은 3. 3 < 4는 참!

// 조건을 만족하는 가장 작은 j를 찾았으므로, 즉시 j 값인 **2**를 반환하고 함수가 종료됩니다.

// 이처럼 DP는 모든 경우의 수를 체계적으로 탐색하면서 각 단계별 최적의 값(B의 최소 흔적)만을 기록해 나가는 방식입니다. 이 과정을 통해 최종적으로 A의 흔적(j)에 따른 B의 최소 흔적 결과를 얻고, 그중에서 문제의 조건을 만족하는 가장 작은 A의 흔적을 찾아내는 것입니다.