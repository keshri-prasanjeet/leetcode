class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSum(nums, target, 0, 0);
    }

    private int findTargetSum(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = idx + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);

        int result = findTargetSum(nums, target, idx + 1, sum + nums[idx])
                   + findTargetSum(nums, target, idx + 1, sum - nums[idx]);

        memo.put(key, result);
        return result;
    }
}