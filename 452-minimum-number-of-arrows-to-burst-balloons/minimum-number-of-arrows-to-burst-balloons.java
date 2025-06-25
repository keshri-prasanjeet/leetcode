class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        int len = points.length;
        int prevS = points[0][0];
        int prevE = points[0][1];
        int arrowsReq = 0;
        for(int i=1;i<len;i++){
            if(points[i][0] <= prevE && points[i][1] >= prevS){
                prevS = Math.max(prevS, points[i][0]);
                prevE = Math.min(prevE, points[i][1]);
            }
            else{
                arrowsReq++;
                prevS = points[i][0];
                prevE = points[i][1];
            }
        }
        return arrowsReq+1;
    }
}