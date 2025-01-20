class Solution {
    public int maximumProduct(int[] nums, int k) {
    PriorityQueue<Integer> numPQ = new PriorityQueue<>();
    int mod = 1000000007;

    
    for (int num : nums)
      numPQ.offer(num);

    for (int i = 0; i < k; i++) {
      
      int minElement = numPQ.remove();
      minElement++;

      
      numPQ.offer(minElement);
    }

    
    long result = 1;
    while (!numPQ.isEmpty()) {
      result *= numPQ.poll();
      result %= mod;
    }

    return (int) result;
  }

}
