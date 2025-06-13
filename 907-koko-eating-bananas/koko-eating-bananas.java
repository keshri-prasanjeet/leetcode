class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK  = 0;
        for(int pile: piles) maxK = Math.max(maxK, pile);

        int minK = 1;
        int bestK = maxK;
        while(minK <= maxK){
            int midK = minK + (maxK - minK) / 2;
            long totalBananaEatingTime = 0;
            for(int pile: piles){
                totalBananaEatingTime += (pile + midK -1)/ midK;
            }
            if(totalBananaEatingTime <= h){
                bestK = midK;
                maxK = midK-1;
            }
            else{
                minK = midK +1;
            }
        }
        return bestK;
    }
}