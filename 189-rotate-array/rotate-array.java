class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        arrayReverser(nums, 0, size-1);
        arrayReverser(nums, 0, k-1);
        arrayReverser(nums, k, size-1);
    }

    private void arrayReverser(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}