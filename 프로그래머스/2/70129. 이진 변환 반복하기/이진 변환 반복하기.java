class Solution {
    public int[] solution(String s) {
        // String a = "1111";
        // System.out.print("a : " + a.length());
        // System.out.print("\n");
        // String b = "111";
        // System.out.print("b : " + b.length());
        int[] result = new int[2];
        
        while(!s.equals("1")) {
            int zeroCount = s.length() - s.replace("0", "").length();
            result[1] += zeroCount;
            int oneCount = s.length() - zeroCount;
            s = Integer.toString(oneCount, 2);
            result[0]++;
        }

        
        return result;
    }
}