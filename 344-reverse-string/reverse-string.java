class Solution {
    public void reverseString(char[] s) {
        stringReverser(s, 0, s.length-1);
        return;
    }

    private void stringReverser(char[] s, int left, int right){
        if(left >= right) return;
        stringReverser(s, left+1, right-1);
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}