class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        // Arrays.fill(candy, 1);
        for(int i=1;i<len;i++){
            if(ratings[i] > ratings[i-1] && candy[i] <= candy[i-1]){
                candy[i] = candy[i-1]+1;
            }
        }
        for(int i=len-2;i>=0;i--){
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]){
                candy[i] = candy[i+1]+1;
            }
        }
        // return Arrays.stream(candy).sum() + len; // adding len because did not fill with 1 so adding 1 candy for each kid
        int totalCandy = 0;
        for(int i:candy) totalCandy+=i;
        return totalCandy + len;
    }
}