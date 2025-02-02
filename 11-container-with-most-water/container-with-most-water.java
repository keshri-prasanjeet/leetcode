class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int curWater = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            curWater = (right-left) * Math.min(height[left], height[right]);
            maxWater = Math.max(curWater, maxWater);
            if(height[left] > height[right]){
                right--;
            }
            else left++;
        }

        while(left < right){
            curWater = (right-left) * Math.min(height[left], height[right]);
            maxWater = Math.max(curWater, maxWater);
            if(height[left] < height[right]){
                left++;
            }
            else right++;
        }

        return maxWater;

    }
}