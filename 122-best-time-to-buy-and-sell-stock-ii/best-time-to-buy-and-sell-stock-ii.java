class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        int profit = 0;
        for(int stock: prices){
            if(stock <= buy){
                buy = stock;
                sell= buy;
            }
            else{
                sell = stock;
                profit += (sell-buy);
                buy = stock;
            }
        }
        return profit;
    }
}