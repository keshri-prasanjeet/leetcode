class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len==0) return intervals;
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int prevI = intervals[0][0];
        int prevJ = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= prevJ && intervals[i][1] >= prevI){
                //overlap
                prevI = Math.min(prevI,intervals[i][0]);
                prevJ = Math.max(prevJ,intervals[i][1]);
            }
            else{
                answer.add(Arrays.asList(prevI, prevJ));
                prevI = intervals[i][0];
                prevJ = intervals[i][1];
            }
        }
        answer.add(Arrays.asList(prevI, prevJ));
        int[][] answerArr = new int[answer.size()][2];
        for(int i=0;i<answer.size();i++){
            for(int j=0;j<2;j++){
                answerArr[i][j] = answer.get(i).get(j);
            }
        }
        // System.out.println(answer);
        return answerArr;
    }
}