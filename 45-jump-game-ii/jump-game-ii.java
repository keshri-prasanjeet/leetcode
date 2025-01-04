class Solution {
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+nums[i];j++){
                if(j==nums.length) break;
                if(jumps[j]==0){
                    jumps[j] = jumps[i]+1;
                }
                else{
                    jumps[j] = Math.min(jumps[j], jumps[i]+1);
                }
                if(j==nums.length-1) break;
            }
        }
        return jumps[nums.length-1];
    }
}