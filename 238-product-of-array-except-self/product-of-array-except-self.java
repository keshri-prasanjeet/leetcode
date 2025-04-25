class Solution {
    public int[] productExceptSelf(int[] nums) {
        //keep an aux that will store the sum before that point
        //do it from left side and right side
        int aux = 1;
        int len = nums.length;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = aux;
            aux*=nums[i];
        }
        aux = 1;
        for(int i=len-1;i>=0;i--){
            arr[i] *= aux;
            aux*=nums[i];
        }
        return arr;
    }
}