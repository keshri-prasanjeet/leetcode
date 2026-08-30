class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> negNums = new ArrayList<>();
        List<Integer> posNums = new ArrayList<>();
        for(int num:nums){
            if(num<=0) negNums.add(num*num);
            else posNums.add(num*num);
        }
        int idx1 = negNums.size()-1;
        int idx2 = 0;
        int i = 0;

        while(idx1 >= 0 && idx2 < posNums.size()){
            if(negNums.get(idx1)<=posNums.get(idx2)) nums[i++] = negNums.get(idx1--);
            else nums[i++] = posNums.get(idx2++);
        }

        while(idx1 >= 0){
            nums[i++] = negNums.get(idx1--);
        }

        while(idx2 < posNums.size()){
            nums[i++] = posNums.get(idx2++);
        }
        return nums;
    }
}