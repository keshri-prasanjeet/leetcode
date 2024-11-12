class Solution {
    int[] climbCost;
    public int minCostClimbingStairs(int[] cost) {
        this.climbCost = new int[cost.length];
        return Math.min(findMinCost(cost, 0), findMinCost(cost, 1));
    }

    private int findMinCost(int[] cost, int index){
        if(index >= cost.length) return 0;

        if(climbCost[index] != 0) return climbCost[index];

        int oneStep = findMinCost(cost, index+1);
        int twoStep = findMinCost(cost, index+2);

        int costHere = cost[index] + Math.min(oneStep, twoStep);

        climbCost[index] = costHere;

        return costHere;

    }
}