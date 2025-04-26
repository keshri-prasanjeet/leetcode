class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1;
        int max = 0;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * min);

            while (left < right && height[left] <= min) {
                left++;
            }
            while (left < right && height[right] <= min) {
                right--;
            }
            
        }

        return max;
    }
}