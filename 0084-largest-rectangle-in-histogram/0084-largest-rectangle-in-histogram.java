class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i=0;i<=len;i++){
            int cur = (i==len) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > cur){
                int heightOfPop = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek()-1;
                maxArea = Math.max(maxArea, (heightOfPop * width));
            }
            stack.push(i);
        }
        return maxArea;
    }
}