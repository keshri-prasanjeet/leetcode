class Solution {
    public void reverseString(char[] s) {
       reverseString(0, s.length-1, s);
    }

    private void reverseString(int start, int end, char[] s){
        if(start>=end){
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        reverseString(start+1, end-1, s);
    }
}