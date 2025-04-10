class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int bedLength = flowerbed.length;
        for(int i=0;i<bedLength;i++){
            if(n==0) return true;
            if((flowerbed[i]==0) && (i==0 || flowerbed[i-1]==0) && (i==bedLength-1 || flowerbed[i+1]==0)){
                flowerbed[i] = 1;
                n--;
            }
        }
        if(n==0) return true;
        return false;
    }
}