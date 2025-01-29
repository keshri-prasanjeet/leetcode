class Solution {
    public int trap(int[] height) {
        int start = -1;
        int end = -1;
        int blocks = 0;
        int water = 0;
        int len = height.length;
        for(int i=0;i<len;i++){
            if(height[i]>0 && start==-1){
                start = i;
            }
            else if(start != -1 && height[i] > height[start]){
                water += Math.min(height[start], height[i]) * (i-start-1);
                water -= blocks;
                start = i;
                blocks = 0;
            }
            else{
                blocks += height[i];
            }
        }

        start = -1;
        end = -1;
        blocks = 0;

        for(int i = len-1;i>=0;i--){
            if(height[i]>0 && start==-1){
                start = i;
            }
            else if(start != -1 && height[i] >= height[start]){
                water += Math.min(height[start], height[i]) * (start-i-1);
                water -= blocks;
                start = i;
                blocks = 0;
            }
            else{
                blocks += height[i];
            }
        }

        return water;
    }
}