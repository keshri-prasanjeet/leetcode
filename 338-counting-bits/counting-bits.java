class Solution {
    public int[] countBits(int n) {
        int[] countBits = new int[n+1];
        for(int i = 0;i<=n;i++){
            countBits[i] = convertAndCount(i);
        }
        return countBits;
    }

    private int convertAndCount(int i){
        int res = 0;
        if(i == 0) return 0;
        else{
            while(i > 0){
                int rem = i % 2;
                if(rem == 1) res++;
                i /=2;
            }
        }
        return res;
    }
}