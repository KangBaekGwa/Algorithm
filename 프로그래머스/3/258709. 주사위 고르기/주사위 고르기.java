//음.. 아이디어가 안떠올라 ㅠ 규칙이 없음
//결국, 모든 케이스에 대해서 확인을 해봐야 한다.. 라는 사실
//완탐을 해야됨.

//시간복잡도...
//주사위 최대 10개, 눈금 6개씩
//10개 5개 조합은, 252개
//5개의 주사위 값 경우 : 6^5 : 6천만
//두개 곱하면, 100억 넘음. 줄어야함.

//A, B 따로 구하고, 두개 combinations 구한다음
//둘을 비교해서, A 승리 횟수를 구함
//미리 가지고있어야될 거, 경우에 따른, a조합 b조합, 그리고 최적의 a조합 유지
//최대 주사위 갯수


import java.util.*;

class Solution {

    int maxDiceCount;
    int[] sol;
    int maxAWins;
    int[] aDice, bDice;
    List<Integer> aSumCombi, bSumCombi;
    boolean[] visit;

    public int[] solution(int[][] dice) {
        maxDiceCount = dice.length;
        sol = new int[maxDiceCount / 2];
        visit = new boolean[maxDiceCount];

        List<List<Integer>> allCase = makeAllCase(0, 0);

        divideAndPlay(dice, allCase);

        return sol;
    }

    public List<List<Integer>> makeAllCase(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        
        if (n == maxDiceCount / 2) {
            List<Integer> combination = new ArrayList<>();
            for (int i = 0; i < maxDiceCount; i++) {
                if (visit[i]) {
                    combination.add(i);
                }
            }
            combinations.add(combination);
            return combinations;
        }

        for (int i = k; i < maxDiceCount; i++) {
            visit[i] = true;
            combinations.addAll(makeAllCase(n + 1, i + 1));
            visit[i] = false;
        }
        
        return combinations;
    }

    public void divideAndPlay(int[][] dice, List<List<Integer>> combinations) {
        for (List<Integer> combination : combinations) {
            aDice = new int[maxDiceCount / 2];
            bDice = new int[maxDiceCount / 2];

            int aIndex = 0, bIndex = 0;
            for (int i = 0; i < maxDiceCount; i++) {
                if (combination.contains(i)) {
                    aDice[aIndex++] = i;
                } else {
                    bDice[bIndex++] = i;
                }
            }

            aSumCombi = new ArrayList<>();
            bSumCombi = new ArrayList<>();
            calculateSumCombinations(0, 0, aDice, dice, aSumCombi);
            calculateSumCombinations(0, 0, bDice, dice, bSumCombi);

            int aWins = calculateAWins(aSumCombi, bSumCombi);

            if (aWins > maxAWins) {
                maxAWins = aWins;
                for (int i = 0; i < maxDiceCount / 2; i++) {
                    sol[i] = aDice[i] + 1;
                }
            }
        }
    }

    public void calculateSumCombinations(int n, int sum, int[] nowDice, int[][] dice, List<Integer> sumCombi) {
        if (n == maxDiceCount / 2) {
            sumCombi.add(sum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            calculateSumCombinations(n + 1, sum + dice[nowDice[n]][i], nowDice, dice, sumCombi);
        }
    }

    public int calculateAWins(List<Integer> aSumCombi, List<Integer> bSumCombi) {
        //이진탐색위해서 미리 오름차순 정렬
        Collections.sort(bSumCombi);
        int aWinCount = 0;

        for (Integer aSum : aSumCombi) {
            aWinCount += binarySearch(bSumCombi, aSum);
        }

        return aWinCount;
    }

    //2진탐색해서, a합이 이기는 횟수를 반환
    //미리 정렬해서 넘겨야됨.
    public int binarySearch(List<Integer> arr, int target) {
        int start = 0, end = arr.size();
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}