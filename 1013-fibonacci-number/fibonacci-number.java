class Solution {
    Map<Integer, Integer> fibMap = new HashMap<>();
    public int fib(int n) {
        if(fibMap.containsKey(n)) return fibMap.get(n);
        if(n==0 || n==1) return n;
        int ans = fib(n-1) + fib(n-2);
        fibMap.put(n, ans);
        return ans;
    }
}