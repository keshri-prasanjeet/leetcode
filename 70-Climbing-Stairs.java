class Solution {
    Map<Integer,Integer> dpMap;
    public int climbStairs(int n) {
        this.dpMap = new HashMap<>();
        return helper(n);
    }

    private int helper(int n){
        if(n==0 || n==1) return 1;

        if(dpMap.containsKey(n)) return dpMap.get(n);

        int ways = helper(n-1) + helper(n-2);
        dpMap.put(n, ways);
        return ways;
    }
}