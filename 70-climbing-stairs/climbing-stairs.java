class Solution {
    Map<Integer, Integer> climbMap = new HashMap<>();
    public int climbStairs(int n) {
        if(climbMap.containsKey(n)) return climbMap.get(n);
        if(n == 0 || n==1) return 1;
        int ways = climbStairs(n-1) + climbStairs(n-2);
        climbMap.put(n, ways);
        return ways;
    }
}