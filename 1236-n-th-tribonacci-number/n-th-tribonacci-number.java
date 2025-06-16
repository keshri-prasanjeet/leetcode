class Solution {
    Map<Integer, Integer> tribonacciMap = new HashMap<>();
    public int tribonacci(int n) {
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        if(tribonacciMap.containsKey(n)) return tribonacciMap.get(n);
        int tribonacciNum = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        tribonacciMap.put(n, tribonacciNum);
        return tribonacciNum;
    }
}