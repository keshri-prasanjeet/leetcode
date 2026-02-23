class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> permuteUnique(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        findPermutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return answer;
    }

    private void findPermutations(int[] nums, List<Integer> permutation, boolean[] numSet){
        if(permutation.size() == nums.length){
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!numSet[i]){
                permutation.add(nums[i]);
                numSet[i] = true;
                findPermutations(nums, permutation, numSet);
                permutation.remove(permutation.size()-1);
                numSet[i] = false;
                //after i have removed the element that was used
                //i am looking at a future possible element 
                //if this i+1 element is going to start same tree as this current element
                //skip that
                while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
            }
        }
    }
}