class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] table = new int[len+1];
        table[0] = cost[0];
        table[1] = cost[1];
        for(int i=2;i<len;i++){
            table[i] = Math.min(table[i-1], table[i-2]);
            table[i]+=cost[i];
        }
        return Math.min(table[len-2], table[len-1]);
    }
}