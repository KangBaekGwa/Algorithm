// 간격으로 확인?
// 그냥 설치를 하면서, 이번에 설치한 부분이, 기존 설치된 기지국에 영향을 받는곳에 있다면 스킵?
// 빈 구간을 확인해야함.
// 이걸 List 로 정리해서 각 구간별로 추가로 설치해야될껄 계산하면 될듯?

import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        // 전파 된 범위 확인
        int start = 1;
        int result = 0;
        int cover = w * 2 + 1;
        
        List<Point> emptyList = new ArrayList<>();
        
        for(int station : stations) { 
            int left = start;
            int right = station - w - 1;

            if (left <= right) {
                int gap = right - left + 1;
                result += (gap + cover - 1) / cover;  // ceil 대신 정수 계산
            }

            start = station + w + 1;
        }
        
        //만약 끝까지 가지 못하면, 빈곳 한번 더 처리해야함.
        // start ~ 끝까지
        if(start <= n) {
            int gap = n - start + 1;
            result += (gap + cover - 1) / cover;
        }
        // System.out.println(emptyList.toString());
        
        return result;
    }
    
    private class Point {
        private int start;
        private int end;
        
        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public String toString() {
            return "start:" + this.start + " end:" + this.end;
        }
    }
}