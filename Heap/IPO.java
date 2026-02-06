class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      PriorityQueue<int[]> minCapitalHeap =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Max heap based on profit
        PriorityQueue<int[]> maxProfitHeap =
                new PriorityQueue<>((a, b) -> b[1] - a[1]);
      for(int i=0;i<profits.length;i++){
        minCapitalHeap.offer(new int[]{capital[i],profits[i]});
      }  
      for(int i=0;i<k;i++){
          while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll());
          }
            // No project can be done
            if (maxProfitHeap.isEmpty()) break;

            // Choose project with max profit
            w += maxProfitHeap.poll()[1];
      }

return w;
    }
}
