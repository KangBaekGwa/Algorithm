import java.util.*;
import java.io.*;

public class Main {
    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //물품 수
        int maxWeight = Integer.parseInt(st.nextToken()); //최대 무게 maxWeight까지는 허용
        
        int[] dp = new int[maxWeight + 1]; //무슨dp? i에 대해, 최대 달성 가능한 가치를 가지고 있는 메모리
        // dp[1] 에는, 1무게 제한으로 가능한 최대 가치가 들어가있음.
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nowWeight = Integer.parseInt(st.nextToken()); //해당 아이템 무게
            int nowValue = Integer.parseInt(st.nextToken()); //해당 아이템 가치
            
            for(int targetW = maxWeight; targetW >= nowWeight; targetW--) {
                dp[targetW] = Math.max(dp[targetW], dp[targetW - nowWeight] + nowValue);
            }
        }
        
        System.out.println(dp[maxWeight]);
    }
}