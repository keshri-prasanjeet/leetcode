class Solution {
    public int largestAltitude(int[] gain) {
        int highestAl = Integer.MIN_VALUE;
        int altitude = 0;
        for(int n:gain){
            altitude+=n;
            highestAl = Math.max(highestAl, altitude);
        }
        return highestAl < 0 ? 0 : highestAl;
    }
}