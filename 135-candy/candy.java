class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyArray = new int[len];
        for(int i=0;i<len;i++){
            candyArray[i] = 1;
        }
        int prevCandy = 0;
        int prevRating = 0;
        for(int i=0;i<len;i++){
            if(i-1<0){
                prevRating = ratings[i];
                prevCandy = 1;
            }
            else{
                prevCandy = candyArray[i-1];
                prevRating= ratings[i-1];
            }

            if(ratings[i] > prevRating && candyArray[i] <= prevCandy){
                candyArray[i] = prevCandy+1;
            }
        }

        for(int i=len-1;i>=0;i--){
            if(i+1==len){
                prevRating = ratings[i];
                prevCandy = 1;
            }
            else{
                prevCandy = candyArray[i+1];
                prevRating= ratings[i+1];
            }

            if(ratings[i] > prevRating && candyArray[i] <= prevCandy){
                candyArray[i] = prevCandy+1;
            }
        }

        int ans = 0;
        for(var i:candyArray){
            ans+=i;
        }
        return ans;

    }
}