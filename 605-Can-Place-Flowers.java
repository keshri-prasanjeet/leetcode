class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int bedLen = flowerbed.length;
        for(int i=0;i<bedLen;i++){
            if(n==0) return true;
            if(flowerbed[i]==0 && 
                (i==0 || flowerbed[i-1]==0) &&
                    (i==bedLen-1 || flowerbed[i+1]==0)){
                        flowerbed[i] = 1;
                        n--;
                    }
        }

        if(n==0) return true;
        return false;
    }
}