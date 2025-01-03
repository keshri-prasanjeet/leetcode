class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int max_profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }
            else if(prices[i] > buyPrice){
                max_profit = Math.max(max_profit, prices[i] - buyPrice);
            }
        }
        return max_profit;
    }
}