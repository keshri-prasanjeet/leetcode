class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len==0) return intervals;
        List<int[]> answerList = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int prevI = intervals[0][0];
        int prevJ = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= prevJ && intervals[i][1] >= prevI){
                prevI = Math.min(prevI,intervals[i][0]);
                prevJ = Math.max(prevJ,intervals[i][1]);
            }
            else{
                answerList.add(new int[]{prevI, prevJ});
                prevI = intervals[i][0];
                prevJ = intervals[i][1];
            }
        }
        answerList.add(new int[]{prevI, prevJ});
        return answerList.toArray(new int[answerList.size()][]);
    }
}