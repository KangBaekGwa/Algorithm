// 음 각 item 별 개수를 넣어두고
// discount 또한, map 을 활용해서 chicken:1, apple:1 ... 이런식으로 넣어두고 equals 비교를 하면 되지 않을까?
// 추가적으로 다음 넘어갈때는 discount 의 처음껄 빼서, 새로운걸 넣고?
// 나쁘지는 않을듯?
// 시간도 엄청 오래걸리지는 않을듯
// ===========
// 지문을 잘못 읽어서, 제품을 모두 할인 받을수 있는 날짜의 시작지점을 return 하는걸로 해석해서 자꾸 틀림

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        
        // 원하는 것
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        //1일차 마트 할인 Map
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        //1일차에 매칭된다면!
        int count = 0;
        if (wantMap.equals(discountMap)) count++;

        for (int i = 10; i < discount.length; i++) {
            // 맨 앞 상품 빼기
            String removeItem = discount[i - 10];
            discountMap.put(removeItem, discountMap.get(removeItem) - 1);
            if (discountMap.get(removeItem) == 0) {
                discountMap.remove(removeItem);
            }
            
            // 새 상품 추가
            String addItem = discount[i];
            discountMap.put(addItem, discountMap.getOrDefault(addItem, 0) + 1);

            // 비교
            if (wantMap.equals(discountMap)) count++;
        }
        return count;
    }
}