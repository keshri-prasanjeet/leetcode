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
                if(moved == k){
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
                System.out.println("curIdx is " + curIdx);
                System.out.println("left is " + left + " right is " + right);
                System.out.println("moved is " + moved);
                if(moved == Math.abs(k)){
                    answer[curIdx++]  = sum;
                    System.out.println("found a window will have put sum " + sum + " at index " + (curIdx -1) );
                    sum -= code[left];
                    System.out.println("left moved now intermediate sum is " + sum);
                    left++;
                    left = left % len;
                    moved--;
                    System.out.println("the left is repositioned to " + left + " moved is " + moved);
                }
                sum += code[right];
                System.out.println("intermediate sum is " + sum);
                right++;
                right = right % len;
                moved++;
            }
        }
        return answer;
    }
}