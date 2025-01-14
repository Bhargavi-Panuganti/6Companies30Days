class Solution {
    // 139 ms. 26.61%
public int stoneGameVI(int[] aliceValues, int[] bobValues) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));
    for(int i = 0; i < aliceValues.length; i++) {
    	pq.add(new int[] { aliceValues[i], bobValues[i] });
    }
    int[] score = new int[2];
    for(int i = 0; i < aliceValues.length; i++) {
    	score[i & 1] += pq.poll()[i & 1];
    }
    return Integer.compare(score[0], score[1]);
}
}
