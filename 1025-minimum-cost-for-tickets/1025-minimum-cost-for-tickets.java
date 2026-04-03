class Solution {
    Integer[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[days.length+1];
        return findMinCost(days, costs, 0);
    }

    private int findMinCost(int[] days, int[] cost, int idx){
        if(idx >= days.length) return 0;
        if(dp[idx] != null) return dp[idx];

        int cost1 = cost[0] + findMinCost(days, cost, idx+1);

        int j = idx;
        while(j < days.length && days[j] < days[idx]+7) j++;
        int cost7 = cost[1] + findMinCost(days, cost, j);

        j = idx;

        while(j < days.length && days[j] < days[idx]+30) j++;
        int cost30 = cost[2] + findMinCost(days, cost, j);

        return dp[idx] = Math.min(cost1, Math.min(cost7, cost30));
    }
}