class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        if(k==0) return new int[len];
        int left = 1;
        int right = 1;
        if(k>0){
            return decode(len, left, right, code, k);
        }
        else{
            left = len+k;
            right = len+k;
            return decode(len, left, right, code, k);
        }
    }

    private int[] decode(int len, int left, int right, int[] code, int k){
        int moved = 0;
        int sum = 0;
        int curIdx = 0;
        int[] answer = new int[len];
        while(curIdx < len){
            if(moved == Math.abs(k)){
                answer[curIdx++]  = sum;
                sum -= code[left];
                left++;
                left = left % len;
                moved--;
            }
            sum += code[right];
            right++;
            right = right % len;
            moved++;
        }
        return answer;
    }
}