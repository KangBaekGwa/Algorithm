import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] map = new int[N];
		for (int i=0; i<N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(map);

		int left = 1;
		int right = map[N-1] - map[0];
		int result = 0;

		while(left <= right) {
			int mid = left + (right - left) / 2;

			// 검증.
			if(valid(mid, map, C)) {
				// 더 길게 거리 두기
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(result);
	}

	// 최소 gap 만큼 벌어지면서 count 만큼 모두 배치가 가능해야함.
	// 첫집에는 항상 공유기 박아두는게 나을꺼같을듯?
	private static boolean valid(int gap, int[] map, int maxCount) {
		int nowCount = 0;
		int before = 0; // 이전에 공유기를 설치한 위치.

		// 첫번째에 공유기 설치
		before = map[0];
		nowCount++;

		for(int idx=1; idx<map.length; idx++) {
			int nowHousePos = map[idx];
			int nowGap = nowHousePos - before;

			if(nowGap >= gap) {
				nowCount++;
				before = nowHousePos;
			}

			if(maxCount <= nowCount) return true; // 공유기 설치가 완료되면 더 이상 볼 필요가 없음
		}

		return maxCount <= nowCount;
	}
}