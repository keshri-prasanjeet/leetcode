class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        // for(int[] a:intervals){
        //     for(int i: a){
        //         System.out.print(i + " ");
        //     }
        //     System.out.println("");
        // }
        int prevS = intervals[0][0];
        int prevE = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prevE){
                // prevE = intervals[i][1];
                count++;
            }
            else{
                prevS = intervals[i][0];
                prevE = intervals[i][1];
            }
        }
        return count;
    }
}