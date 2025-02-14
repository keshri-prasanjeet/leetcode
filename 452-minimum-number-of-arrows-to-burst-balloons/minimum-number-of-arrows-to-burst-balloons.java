class Solution {
    public int findMinArrowShots(int[][] points) {
        //will check if my current interval and next interval have some common area
        //if yes then i will just keep the intersection of it.
        //this new intersection ballon is new balloon at this point that i will compare with the next
        int len = points.length;
        if(len==1) return 1;
        int[] prevBalloon = new int[2];
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        prevBalloon[0] = points[0][0];
        prevBalloon[1] = points[0][1];
        int rougueBalloons = 0;
        for(int i=1;i<len;i++){
            int currL = points[i][0];
            int currR = points[i][1];
            // System.out.println("The current balloon is " + currL + " " + currR);
            // System.out.println("Previous is " + prevBalloon[0] + " " + prevBalloon[1]);
            if(currL <= prevBalloon[1] && currR >= prevBalloon[0]){
                //overlap exists
                prevBalloon[0] = Math.max(prevBalloon[0],currL);
                prevBalloon[1] = Math.min(prevBalloon[1],currR);
                // System.out.println("overlap found " + prevBalloon[0] + " " + prevBalloon[1]);
            }
            else{
                rougueBalloons++;
                prevBalloon[0] = currL;
                prevBalloon[1] = currR;
            }
        }
        return rougueBalloons+1;
    }
}