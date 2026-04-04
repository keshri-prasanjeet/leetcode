class Solution {
    Integer[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[days.length + 1];
        return findMinCost(days, costs, 0);
    }

    private int findMinCost(int[] days, int[] costs, int idx){
        if(idx == days.length){
            return 0;
        }

        if(dp[idx] != null) return dp[idx];

        //one day pass
        int oneDay = costs[0] + findMinCost(days, costs, idx+1);

        int j = idx;
        while(j < days.length && days[j] < days[idx]+7)j++;
        int sevDay = costs[1] + findMinCost(days, costs, j);

        j = idx;
        while(j < days.length && days[j] < days[idx]+30)j++;
        int ttyDay = costs[2] + findMinCost(days, costs, j);
        
        return dp[idx] = Math.min(oneDay, Math.min(sevDay, ttyDay));
    }
}