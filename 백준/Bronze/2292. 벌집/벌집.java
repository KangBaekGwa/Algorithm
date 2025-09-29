import java.util.Scanner;

// 입력값에 따라서 범위가 지정됨
// 1 -> 2 ~ 7 -> 8 ~ 19 ...
// 1 -> 6개 -> 12개 -> 18개 ... 6개씩 늘어남
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		sc.close();

		long cnt = 1;
		long now = 1;
		while(now < N) {
			now += cnt * 6;
			cnt++;
		}

		System.out.println(cnt);
	}
}