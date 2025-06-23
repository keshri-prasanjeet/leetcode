class Solution {
    Integer[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        dp = new Integer[len1][len2];
        return findMinSum(s1, s2, len1-1, len2-1);
    }

    private int findMinSum(String s, String t, int i, int j){
        if(i<0){
            //return all ASCII of t[j]
            int sum = 0;
            while(j>=0){
                sum += t.charAt(j--);
            }
            return sum;
        }
        if(j<0){
            int sum = 0;
            while(i >=0){
                sum+=s.charAt(i--);
            }
            return sum;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = findMinSum(s, t, i-1, j-1);
        }
        else{
            //do delete
            int delI = (int) s.charAt(i) + findMinSum(s,t,i-1,j);
            int delJ = (int) t.charAt(j) + findMinSum(s,t,i,j-1);
            return dp[i][j] = Math.min(delI, delJ);
        }
    }
}