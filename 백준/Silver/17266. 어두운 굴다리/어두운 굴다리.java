import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : baekgwa
 * FileName    : ${NAME}
 * Author      : Baekgwa
 * Date        : 2025-09-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-11     Baekgwa               Initial creation
 */

public class Main {
	static int N, M;
	static int[] pos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		pos = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N;
		int mid;

		while (left < right) {
			mid = (left + right) / 2;

			// 가능 여부 확인
			if (check(mid)) { //가능
				right = mid;
			} else { // 불가능
				left = mid + 1;
			}
		}

		System.out.println(left);
	}

	private static boolean check(int h) {
		int reach = 0;

		for (int x : pos) {
			if (x - h > reach)
				return false;
			reach = x + h; // 현재 높이 + 포지션 만큼 커버 가능
			if (reach >= N)
				return true;
		}

		return reach >= N;
	}
}