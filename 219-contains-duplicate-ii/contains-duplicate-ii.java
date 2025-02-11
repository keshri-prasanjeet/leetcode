class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(indexMap.containsKey(nums[i])){
                if(Math.abs(indexMap.get(nums[i]) - i) <=k) {
                    // System.out.println("index " + indexMap.get(nums[i]) + " and index " + i );
                    return true;
                }
                indexMap.put(nums[i], i);
            }
            else{
                indexMap.put(nums[i], i);
            }
        }
        return false;
    }
}