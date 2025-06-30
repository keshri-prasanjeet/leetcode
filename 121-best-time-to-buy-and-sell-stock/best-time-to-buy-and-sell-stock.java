class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for(int sell:prices){
            if(sell < buy) buy = sell;
            else profit = Math.max(profit, sell-buy);
        }
        return profit == Integer.MIN_VALUE ? 0 : profit;
    }
}