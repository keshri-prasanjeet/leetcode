class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverser(0, len-1, nums);
        reverser(0, k-1, nums);
        reverser(k, len-1, nums);
        return;
    }
    private void reverser(int start, int end, int[] array){
        while(start<=end){
            int temp;
            temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }
}