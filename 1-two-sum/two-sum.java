class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> nMap = new HashMap<>();
        int[] answer = new int[2];
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(nMap.containsKey(target - num)){
                if(nMap.get(target-num) == i) continue;
                answer[0] = i;
                answer[1] = nMap.get(target-num);
                return answer;
            }
            nMap.put(num, i);
        }
        return answer;
    }
}