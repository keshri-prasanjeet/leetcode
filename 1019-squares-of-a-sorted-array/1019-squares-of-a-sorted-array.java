class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            int leftCandidate = nums[left]*nums[left];
            int rightCandidate= nums[right]*nums[right];

            if(leftCandidate>=rightCandidate){
                answer[i] = leftCandidate;
                left++;
            }
            else{
                answer[i] = rightCandidate;
                right--;
            }
        }
        return answer;
    }
}