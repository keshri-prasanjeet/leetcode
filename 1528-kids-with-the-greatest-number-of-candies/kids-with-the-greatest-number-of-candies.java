class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for(int i : candies){
            maxCandy = Math.max(maxCandy, i);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i:candies){
            if(i+extraCandies >= maxCandy) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}