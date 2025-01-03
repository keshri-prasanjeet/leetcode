class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buyPrice){
                maxProfit += prices[i] - buyPrice;
                buyPrice = prices[i];
            }
            else if(prices[i]<buyPrice){
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}