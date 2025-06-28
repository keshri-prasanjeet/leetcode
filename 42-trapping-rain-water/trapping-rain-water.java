class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMaxHeight = new int[len];
        int[] rightMaxHeight= new int[len];

        leftMaxHeight[0] = height[0];
        rightMaxHeight[len-1] = height[len-1];
        for(int i=1;i<len;i++){
            leftMaxHeight[i] = Math.max(leftMaxHeight[i-1], height[i]);
        }
        for(int j=len-2;j>=0;j--){
            rightMaxHeight[j] = Math.max(rightMaxHeight[j+1], height[j]);
        }
        int totalWater = 0;
        for(int i=0;i<len;i++){
            totalWater += Math.min(rightMaxHeight[i], leftMaxHeight[i]) - height[i];
        }
        return totalWater;
    }
}