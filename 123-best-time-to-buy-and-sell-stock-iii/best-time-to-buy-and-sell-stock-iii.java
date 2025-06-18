class Solution {
    public int maxProfit(int[] prices) {
        int sz = prices.length;
        int[] leftProfit = new int[sz];
        int[] rightProfit= new int[sz];
        int lMin = prices[0];
        for(int i=1;i<sz;i++){
            lMin = Math.min(lMin, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i]-lMin);
        }

        int rMax = prices[sz-1];
        for(int j=sz-2;j>=0;j--){
            rMax = Math.max(rMax, prices[j + 1]);
            rightProfit[j] = Math.max(rightProfit[j+1], rMax - prices[j]);
        }

        int maxProfit = 0;
        for(int i=0;i<sz;i++){
            int left = (i>0) ? leftProfit[i-1] : 0;
            int right= (i< sz) ? rightProfit[i]: 0;
            maxProfit = Math.max(maxProfit, left + right);
        }

        return maxProfit;
    }
}