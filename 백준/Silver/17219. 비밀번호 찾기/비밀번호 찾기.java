import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            String[] infoArray = br.readLine().split(" ");
            map.put(infoArray[0], infoArray[1]);
        }
        
        for(int i=0; i<M; i++) {
            String findSite = br.readLine();
            System.out.println(map.get(findSite));
        }
    }
}