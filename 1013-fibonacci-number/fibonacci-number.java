class Solution {
    Map<Integer, Integer> fiboMap = new HashMap<>();
    public int fib(int n) {
        if(fiboMap.containsKey(n)) return fiboMap.get(n);
        if(n==0 || n==1) return n;
        int ans = fib(n-1) + fib(n-2);
        fiboMap.put(n, ans);
        return ans;
    }
}