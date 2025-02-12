class Solution {
    public List<String> summaryRanges(int[] nums) {
        //start from the first
        //if next item is +1 then continue range
        // if next item is not +1 then stop range and start a new range
        List<String> answer = new ArrayList<>();
        if(nums.length==0) return answer;
        int startRange = nums[0];
        int prevNum = startRange;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1 == prevNum){
                prevNum = nums[i];
            }
            else{
                if(startRange == prevNum){
                    answer.add(String.valueOf(prevNum));
                }
                else{
                    StringBuilder sb = new StringBuilder();
                    sb.append(startRange);
                    sb.append("->");
                    sb.append(prevNum);
                    answer.add(sb.toString());
                    sb.setLength(0);
                }
                startRange = nums[i];
                prevNum = startRange;
            }
        }
        if(startRange == prevNum){
            answer.add(String.valueOf(prevNum));
        }
        else{
            StringBuilder sb = new StringBuilder();
            sb.append(startRange);
            sb.append("->");
            sb.append(prevNum);
            answer.add(sb.toString());
            sb.setLength(0);
        }
        return answer;
    }
}