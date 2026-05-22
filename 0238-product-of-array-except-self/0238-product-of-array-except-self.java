class Solution {
    public int[] productExceptSelf(int[] nums) {
        //this question is a very common question to me
        //make auxillaries
        // temp = 1
        // 1 2 3 4
        // 1 1  2  6
        // 24  12  8  6
        int len = nums.length;
        int[] aux = new int[len];
        int temp = 1;

        for(int i=0;i<len;i++){
            aux[i] = temp;
            temp*=nums[i];
        }
        temp = 1;
        for(int i=len-1;i>=0;i--){
            aux[i]*=temp;
            temp*=nums[i];
        }

        return aux;
    }
}