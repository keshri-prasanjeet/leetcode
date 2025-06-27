class NumArray {
    int[] arr;
    int sum = 0;
    Map<Integer, Integer> prefixSumMap;
    public NumArray(int[] nums) {
        this.arr = nums;
        prefixSumMap = new HashMap<>();
        prefixSumMap.put(-1,0);
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            sum+=num;
            prefixSumMap.put(i, sum);
            // System.out.println("i  " + i + " sum " + sum);
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixSumMap.get(right) - prefixSumMap.get(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */