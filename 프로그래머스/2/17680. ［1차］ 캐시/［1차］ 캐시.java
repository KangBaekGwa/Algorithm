import java.util.*;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		Map<String, Integer> map = new LinkedHashMap<>(cacheSize);

		int runningTime = 0;
		for(String city : cities) {
			city = city.toLowerCase();

			//캐시 히트 확인
			if(map.containsKey(city)) {
				runningTime += 1;
				map.remove(city); //지우고 다시 넣기
				map.put(city, 0);
			} else { // 캐시 미스
				runningTime += 5;
				map.put(city, 0);
                // 크기가 더 크면 삭제
				if (map.size() > cacheSize) {
					String firstKey = map.keySet().iterator().next();
					map.remove(firstKey);
				}
			}
		}

		return runningTime;
	}
}