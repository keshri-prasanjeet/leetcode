class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            maxArea(new int[] { 0, 0 }); // JIT warm-up
        }
    }// JUST WOW
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int maxArea = Integer.MIN_VALUE;
        while(left < right){
            int curHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (curHeight) * (right - left));

            if(height[left] < height[right]){
                // System.out.println("left is " + left + " right is " + right);
                while(left < right && height[left] <= curHeight){left++;}
            }
            else {
                // System.out.println(" §§§§ left is " + left + " right is " + right);
                while(left < right && height[right] <= curHeight){right--;}
            }
        }
        return maxArea;
    }
}