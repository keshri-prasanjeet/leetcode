class Solution {
    public int minFlips(int a, int b, int c) {

        int flips = 0;

        for(int i=0;i<32;i++){
            int aBit = (a>>i) & 1;
            int bBit = (b>>i) & 1;
            int cBit = (c>>i) & 1;

            if((aBit | bBit) != cBit){
                if(cBit == 1) flips++;
                else flips+=aBit+bBit;
            }
        }
        return flips;
    }
}