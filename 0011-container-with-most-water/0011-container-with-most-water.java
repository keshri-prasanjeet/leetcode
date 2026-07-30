class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int curMin= Math.min(height[left], height[right]);
            int curMaxArea = curMin * (right - left);
            maxArea = Math.max(curMaxArea, maxArea);
            if(height[left] <= height[right]) left++;
            else right --;
        }

        return maxArea;
    }
}