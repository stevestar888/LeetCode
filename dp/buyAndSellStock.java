class Solution {
    public int maxProfit(int K, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //when k >= half of the prices, we are essentially able to buy and sell every other day 
        //in which case we sell everytime it's greater than teh prev prices
        if (K >= prices.length / 2) 
            return quickSolve(prices);
        
        int[] even = new int[prices.length];
        int[] odd = new int[prices.length];
        
        for (int k = 1; k <= K; k++) {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < prices.length; i++) {
                if (k % 2 == 0) {
                    max = Math.max(max, odd[i-1] - prices[i-1]);
                    even[i] = Math.max(even[i-1], prices[i] + max);
                } else {
                    max = Math.max(max, even[i-1] - prices[i-1]);
                    odd[i] = Math.max(odd[i-1], prices[i] + max);
                }
            }
        }
        
        return K % 2 == 0? even[prices.length-1] : odd[prices.length-1] ;
    }
    
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
} 