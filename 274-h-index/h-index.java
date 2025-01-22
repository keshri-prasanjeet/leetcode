class Solution {
    public int hIndex(int[] citations) {
        int count;
        int maxH = 0;
        for(int i=1;i<=citations.length;i++){
            count = 0;
            for(int j=0;j<citations.length;j++){
                if(citations[j] >= i) count++;
            }
            if(count >= i){
                maxH = Math.max(maxH, i);
            }
        }
        return maxH;
    }
}