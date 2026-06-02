class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int maxWater = 0;
        while(left < right){
            int curWater = Math.min(height[left], height[right]) * (right-left);
            maxWater = Math.max(maxWater, curWater);
            if(height[left]>=height[right]){
                right--;
            }
            else left++;
        }
        return maxWater;
    }
}