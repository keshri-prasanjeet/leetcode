class Solution {
    int[] memo;
    boolean[] seen;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length+1];
        seen = new boolean[cost.length+1];
        return Math.min(findMinCost(cost, 0), findMinCost(cost, 1));
    }

    private int findMinCost(int[] cost, int index){
        if(index >= cost.length){
            return 0;
        }

        if(seen[index]==true){
            return memo[index];
        }

        int cur = cost[index];
        cur+=(Math.min(findMinCost(cost, index+1), findMinCost(cost, index+2)));
        memo[index] = cur;
        seen[index] = true;
        return cur;
    }
}