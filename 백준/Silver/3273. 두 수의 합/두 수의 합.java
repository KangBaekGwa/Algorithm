import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(br.readLine());
		int[] arr = new int[cnt];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int left = 0;
		int right = cnt - 1;
		int result = 0;

		while(left < right) {
			int value = arr[left] + arr[right];

			if(value == target) {
				result++;
				left++;
				right--;
			}
			else if(value > target) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(result);
	}
}