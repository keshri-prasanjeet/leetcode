class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for(int candy: candies){
            maxCandy = Math.max(candy,maxCandy);
        }
        List<Boolean> answer = new ArrayList<>();
        for(int candy: candies){
            if(candy+extraCandies >=maxCandy)
                answer.add(true);
            else answer.add(false);
        }
        return answer;
    }
}