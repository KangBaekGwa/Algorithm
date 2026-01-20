import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		while(testCase-- > 0) {
			int K = Integer.parseInt(br.readLine());
			int[][] dp = new int[K+1][K+1];
			int[] map = new int[K+1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= K; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			int[] prefix = new int[K+1];
			for (int i = 1; i <= K; i++) {
				prefix[i] = prefix[i-1] + map[i];
			}

			for(int length=2; length <= K; length++) {
				for(int start=1; start + length -1 <= K; start++) {
					int end = start + length - 1;
					dp[start][end] = Integer.MAX_VALUE;

					for(int k=start; k<end; k++) {
						dp[start][end] = Math.min(
							dp[start][end],
							dp[start][k] + dp[k+1][end] + (prefix[end] - prefix[start-1])
						);
					}
				}
			}

			sb.append(dp[1][K]).append("\n");
		}

		System.out.println(sb.toString());
	}
}
