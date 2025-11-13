import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Lecture[] lectures = new Lecture[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			lectures[i] = new Lecture(s, t);
		}
		Arrays.sort(lectures, (a, b) -> a.getStartTime() - b.getStartTime());

		PriorityQueue<Lecture> pq = new PriorityQueue<>((a, b) -> a.getEndTime() - b.getEndTime());
		pq.offer(lectures[0]);

		for (int i = 1; i < N; i++) {
			if (pq.peek().getEndTime() <= lectures[i].getStartTime()) {
				pq.poll();
			}
			pq.offer(lectures[i]);
		}

		System.out.println(pq.size());
	}

	private static class Lecture {
		private int startTime;
		private int endTime;

		public Lecture(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public int getEndTime() {
			return endTime;
		}
	}
}