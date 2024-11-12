class Solution {
    Map<Integer,Integer> stairsMap;
    public int climbStairs(int n) {
        this.stairsMap = new HashMap<>();
        return helper(n);
    }

    private int helper(int n){
        if(n==1 || n==0) return 1;

        if(stairsMap.containsKey(n)) return stairsMap.get(n);

        int ways = helper(n-1) + helper(n-2);

        stairsMap.put(n,ways);
        return ways;
    }
}