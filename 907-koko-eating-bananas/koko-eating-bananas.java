class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for(int pile: piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }

        int left = 0;
        int right = maxSpeed;
        int minSpeed = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right-left)/2;
            int timeTakenToEat = timeTakenToEat(mid, piles);
            if(timeTakenToEat <= h){
                minSpeed = Math.min(minSpeed, mid);
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return minSpeed;
    }

    private int timeTakenToEat(int mid, int[] piles){
        int totalTime = 0;
        for(int pile: piles){
            totalTime += Math.ceil((double)pile / (double)mid);
        }
        return totalTime;
    }
}