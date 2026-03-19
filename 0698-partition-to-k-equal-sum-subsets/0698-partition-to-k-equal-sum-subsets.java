class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums) sum+=num;
        if(sum%k != 0) return false;
        Arrays.sort(nums);
        int i=0;
        int len = nums.length-1;
        int temp = 0;
        while(i <= len){
            temp = nums[i];
            nums[i] = nums[len];
            nums[len] = temp;
            i++;
            len--;
        }
        int subsetSum = sum/k;
        for(int num: nums) if(num > subsetSum) return false;

        return kPartitionPossible(0, new int[k], subsetSum, nums);
    }

    private boolean kPartitionPossible(int index, int[] partitions, int subsetSum, int[] nums){
        if(index == nums.length) return true;
        int num = nums[index];
        for(int i=0;i<partitions.length;i++){
            if(partitions[i]+num <= subsetSum){
                partitions[i]+=num;
                if(kPartitionPossible(index+1, partitions, subsetSum, nums)) return true;
                partitions[i]-=num;
                if(partitions[i] == 0) break;
            }
        }

        return false;
    }
}