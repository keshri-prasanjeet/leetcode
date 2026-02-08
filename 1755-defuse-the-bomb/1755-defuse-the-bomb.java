class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] answer = new int[len];
        if(k==0) return answer;
        int left = 1;
        int right = 1;
        int moved = 0;
        int sum = 0;
        int curIdx = 0;
        if(k>0){
             while(curIdx < len){
                if(moved == Math.abs(k)){
                    answer[curIdx++] = sum;
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
        }
        else{
            left = len+k;
            right = len+k;
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
        }
        return answer;
    }
}