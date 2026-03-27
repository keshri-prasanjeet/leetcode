class Solution {
    Integer memo[];
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        memo = new Integer[n+1];
        int first = houseRobber(nums, 0, n-2);
        memo = new Integer[n+1];
        return Math.max(first, houseRobber(nums, 1, n-1));
    }

    private int houseRobber(int[] houses, int index, int endIdx){
        if(index > endIdx) return 0;
        if(memo[index]!=null) return memo[index];
        int currentHouse = houses[index];
        memo[index] = Math.max(houseRobber(houses, index+1, endIdx), (currentHouse + houseRobber(houses, index+2, endIdx)));
        return memo[index];
    }
}