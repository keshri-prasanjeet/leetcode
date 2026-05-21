class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxL = new int[len];
        int[] maxR = new int[len];
        maxL[0] = height[0];
        maxR[len-1] = height[len-1];
        for(int i = 1;i<len;i++){
            maxL[i] = Math.max(maxL[i-1], height[i]);
        }

        for(int i = len-2;i>=0;i--){
            maxR[i] = Math.max(maxR[i+1], height[i]);
        }
        int trappedWater = 0;
        for(int i=0;i<len;i++){
            int water = Math.min(maxL[i], maxR[i]) - height[i];
            trappedWater += water > 0 ? water : 0;
        }
        return trappedWater;
    }
}