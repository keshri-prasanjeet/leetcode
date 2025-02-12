class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            intervalList.add(intervals[i]);
        }
        intervalList.add(newInterval);
        Collections.sort(intervalList, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> answer = new ArrayList<>();
        int[] prev = intervalList.get(0);
        for(int i=0;i<intervalList.size();i++){
            int[] curInterval = intervalList.get(i);
            if(prev[1]>=curInterval[0]){
                // prev[0] = Math.min(prev[0], curInterval[0]);
                prev[1] = Math.max(prev[1], curInterval[1]);
            }
            else{
                answer.add(prev);
                prev = curInterval;
            }
        }
        answer.add(prev);
        return answer.toArray(new int[answer.size()][]);
    }
}