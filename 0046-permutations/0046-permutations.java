class Solution {
    List<List<Integer>> answer;
    boolean[] usedNums;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        usedNums=new boolean[nums.length];
        findPermutations(nums, new ArrayList<>(), 0);
        return answer;
    }

    private void findPermutations(int[] nums, ArrayList<Integer> permutation, int idx){
        if(idx  == nums.length){
            answer.add(new ArrayList<>(permutation));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!usedNums[i]){
                usedNums[i] = true;
                permutation.add(nums[i]);
                findPermutations(nums, permutation, idx+1);
                usedNums[i] = false;
                permutation.remove(permutation.size()-1);
            }
        }
    }
}