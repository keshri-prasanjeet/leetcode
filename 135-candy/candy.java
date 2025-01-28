class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyArray = new int[len];

        for(int i=1;i<len;i++){

            if(ratings[i] > ratings[i-1] && candyArray[i] <= candyArray[i-1]){
                candyArray[i] = candyArray[i-1]+1;
            }
        }

        for(int i=len-2;i>=0;i--){

            if(ratings[i] > ratings[i+1] && candyArray[i] <= candyArray[i+1]){
                candyArray[i] = candyArray[i+1]+1;
            }
        }

        int ans = 0;
        for(var i:candyArray){
            ans+=i;
        }
        return ans+len;

    }
}