class Solution {
    Map<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return findSumWays(nums, target, 0, 0);
    }

    private int findSumWays(int[] nums, int target, int sum, int idx){
        if(idx == nums.length){
            return target == sum ? 1 : 0;
        }
        String key = idx + "," + sum;
        if(memo.containsKey(key)) return memo.get(key);
        int ways = findSumWays(nums, target, sum+nums[idx], idx+1) + 
                    findSumWays(nums, target, sum-nums[idx], idx+1);
        memo.put(key, ways);
        return ways;
    }
}