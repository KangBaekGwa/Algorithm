import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int numbers[] = new int[count];
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<count; i++) {
            int now = Integer.parseInt(br.readLine());
            max = Math.max(max, now);
            numbers[i] = now;
        }
        
        int[] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i = 4; i < max+1; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        //출력
        for(int i=0; i<count; i++) {
            System.out.println(dp[numbers[i]]);
        }
	}
}