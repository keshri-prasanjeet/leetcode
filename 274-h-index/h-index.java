class Solution {
    public int hIndex(int[] citations) {
        // int[] sortedArray = Arrays.stream(citations)
        //                     .boxed()
        //                     .sorted((a,b) -> b-a)
        //                     .mapToInt(Integer::intValue)
        //                     .toArray();
        // int hIndex = 0;
        // for(int i=0;i<citations.length;i++){
        //     if(sortedArray[i] >= i+1) hIndex = i+1;
        //     else break;
        // }

        Arrays.sort(citations);
        int hIndex = 0;
        int len = citations.length;
        for(int i=0;i<len;i++){
            if(len-i <= citations[i]) return len-i;
        }
        return 0;
    }
}