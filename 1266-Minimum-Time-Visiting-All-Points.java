class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x = points[0][0];
        int y = points[0][1];
        int time = 0;
        for(int i=1;i<points.length;i++){
            int a = points[i][0];
            int b = points[i][1];

            time+= Math.max(Math.abs(x-a), Math.abs(y-b));
            x = a;
            y = b;
        }
        return time;
    }
}