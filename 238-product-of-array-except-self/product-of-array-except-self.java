class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] aux = new int[len];
        aux[0] = 1;
        for(int i=1;i<len;i++){
            aux[i] = aux[i-1] * nums[i-1];
        }
        
        int mul = 1;
        for(int i=len-2;i>=0;i--){
            mul = mul * nums[i+1];
            aux[i] = aux[i] * mul;
        }
        return aux;
    }
}