class Solution {
    public int tribonacci(int n) {
        Map<Integer,Integer> tribonacciMap = new HashMap<>();
        return tribonacci(n, tribonacciMap);
    }

    private int tribonacci(int n, Map<Integer,Integer> tMap){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(tMap.containsKey(n)){
            return tMap.get(n);
        }
        int ans = tribonacci(n-1, tMap) + tribonacci(n-2, tMap) + tribonacci(n-3, tMap);
        tMap.put(n, ans);
        return ans;
    }
}