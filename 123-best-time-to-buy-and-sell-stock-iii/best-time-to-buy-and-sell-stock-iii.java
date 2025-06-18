class Solution {
    public int maxProfit(int[] prices) {
        int sz = prices.length;
        int[] rightProfit= new int[sz];
        int[] leftProfit = new int[sz];
        
        int lMin = prices[0];
        for(int i=1;i<sz;i++){
            lMin = Math.min(lMin, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i]-lMin);
        }

        int rMax = prices[sz-1];
        for(int i=sz-2;i>=0;i--){
            rMax= Math.max(rMax, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i+1], rMax-prices[i]);
        }
        int maxProfit = 0;
        for(int i=0;i<sz;i++){
            int left = i==0 ? 0 : leftProfit[i-1];
            maxProfit = Math.max(maxProfit, left+rightProfit[i]);
        }
        return maxProfit;
    }
}