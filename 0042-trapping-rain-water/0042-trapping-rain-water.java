class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxHFromLeft = new int[len];
        int[] maxHFromRight= new int[len];
        maxHFromLeft[0] = height[0];
        maxHFromRight[len-1] = height[len-1];

        for(int i=1;i<len;i++){
            maxHFromLeft[i] = Math.max(maxHFromLeft[i-1], height[i]);
        }

        for(int j=len-2;j>=0;j--){
            maxHFromRight[j]= Math.max(maxHFromRight[j+1], height[j]);
        }

        int totalWater = 0;
        for(int i=0;i<len;i++){
            totalWater += Math.abs(Math.min(maxHFromLeft[i],maxHFromRight[i]) - height[i]);
        }
        return totalWater;
    }
}