class Solution {
    int[] map;
    public int climbStairs(int n) {
        map = new int[n+1];
        Arrays.fill(map, -1);
        return findWays(n);
        // return map[n];
    }

    private int findWays(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        if(map[n]!=-1) return map[n];
        int ways = findWays(n-1) + findWays(n-2);
        map[n] = ways;
        return ways;
    } 
}