class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = buy;
        int maxProfit = 0;
        for(int stock: prices){
            if(stock <= buy){
                buy = stock;
                sell= buy;
            }
            else{
                sell = stock;
                maxProfit = Math.max(maxProfit, sell-buy);
            }
        }
        return maxProfit;
    }
}