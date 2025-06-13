class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int banana: piles) max = Math.max(max, banana);
        int min = 1;
        int best_speed = max;
        while(min <= max){
            int mid = min + (max - min)/2;
            long banana_eating_time = 0;
            for(int banana: piles){
                banana_eating_time += (banana + mid - 1)/ mid;
            }
            if(banana_eating_time <= h){
                best_speed = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return best_speed;
    }
}