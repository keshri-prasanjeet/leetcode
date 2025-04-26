class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int maxArea = 0;
        while(left < right && left < len && right >= 0){
            maxArea = Math.max(maxArea, (Math.min(height[left],height[right]) * (right-left)));
            if(height[left] < height[right]){
                left++;
            }
            else right--;
        }
        return maxArea;
    }
}