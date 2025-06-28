class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> histogram = new Stack<>();
        int area = 0;
        for(int i=0;i<heights.length;i++){
            if(histogram.isEmpty()){
                histogram.push(new Pair(heights[i],i));
            }
            else{
                if(heights[i]>histogram.peek().val){
                    histogram.push(new Pair(heights[i], i));
                }
                else{
                    Pair pop = null;
                    while(!histogram.isEmpty() && heights[i] <= histogram.peek().val){
                        pop = histogram.pop();
                        area = Math.max(area, (i-pop.index) * pop.val);
                    }
                    histogram.push(new Pair(heights[i],pop.index));
                }
            }
        }
        while(!histogram.isEmpty()){
            Pair pop = histogram.pop();
            area = Math.max(area, pop.val * (heights.length-pop.index));
        }
        return area;
    }
}

class Pair{
    int val;
    int index;
    public Pair(int val, int index){
        this.val = val;
        this.index=index;
    }
}