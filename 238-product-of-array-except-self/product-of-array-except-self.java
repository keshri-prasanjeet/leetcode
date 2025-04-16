class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] aux = new int[len];
        int multi = 1;
        for(int i=0;i<len;i++){
            aux[i] = multi;
            multi *= nums[i];
        }
        multi = 1;
        for(int i=len-1;i>=0;i--){
            aux[i]*=multi;
            multi *= nums[i];
        }
        return aux;
    }
}