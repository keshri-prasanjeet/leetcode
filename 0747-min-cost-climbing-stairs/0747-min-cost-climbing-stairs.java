class Solution {
    Integer[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new Integer[cost.length+1];
        return Math.min(findMinCost(cost, 0), findMinCost(cost, 1));
    }

    private int findMinCost(int[] cost, int index){
        if(index >= cost.length){
            return 0;
        }

        if(memo[index]!=null){
            return memo[index];
        }

        int cur = cost[index];
        cur+=(Math.min(findMinCost(cost, index+1), findMinCost(cost, index+2)));
        memo[index] = cur;
        return cur;
    }
}