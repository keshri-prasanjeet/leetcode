class Solution {
    Integer[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[days.length];
        return dfs(days, costs, 0);
    }

    private int dfs(int[] days, int[] costs, int i) {
        if (i >= days.length) return 0;

        if (dp[i] != null) return dp[i];

        // 1-day pass
        int cost1 = costs[0] + dfs(days, costs, i + 1);

        // 7-day pass
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) j++;
        int cost7 = costs[1] + dfs(days, costs, j);

        // 30-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 30) j++;
        int cost30 = costs[2] + dfs(days, costs, j);

        return dp[i] = Math.min(cost1, Math.min(cost7, cost30));
    }
}