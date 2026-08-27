class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int len = prices.length;
        int maxProfit = 0;
        for(int i=1;i<len;i++){
            int curr = prices[i];
            if(curr >= buy){
                maxProfit = Math.max(maxProfit, curr-buy);
            }
            else{
                buy = curr;
            }
        }
        return maxProfit;
    }
}