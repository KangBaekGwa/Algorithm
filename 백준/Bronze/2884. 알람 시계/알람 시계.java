import java.util.*;
import java.io.*;
import java.time.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		LocalTime nowTime = LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		LocalTime alramTime = nowTime.minusMinutes(45L);

		System.out.println(alramTime.getHour() + " " + alramTime.getMinute());
	}
}