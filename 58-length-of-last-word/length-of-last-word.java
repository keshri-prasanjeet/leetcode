class Solution {
    public int lengthOfLastWord(String s) {
        char[] sentence = s.toCharArray();
        int len = s.length();
        boolean done = false;
        for(int i=len-1;i>=0;i--){
            int start = i;
            while(i>=0 && sentence[i]!=' '){
                i--;
                done = true;
            }
            if(done==true){
                return start - i;
            }
        }
        return 1;
    }
}