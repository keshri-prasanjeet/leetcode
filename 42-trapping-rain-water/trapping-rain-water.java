class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMaxArray = new int[len];
        int[] rightMaxArray = new int[len];

        leftMaxArray[0] = height[0];
        for(int i=1;i<len;i++){
            leftMaxArray[i] = Math.max(leftMaxArray[i-1], height[i]);
        }

        rightMaxArray[len-1] = height[len-1];
        for(int i=len-2;i>=0;i--){
            rightMaxArray[i] = Math.max(rightMaxArray[i+1], height[i]);
        }

        int water = 0;

        for(int i=1;i<len-1;i++){
            water+= (Math.min(leftMaxArray[i], rightMaxArray[i])) - height[i];
        }

        return water;
        
    }
}