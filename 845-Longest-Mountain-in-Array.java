class Solution {
    public int longestMountain(int[] arr) {
        int maxMountainLen = 0;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                int left = i-1;
                int right = i+1;
                while(left > 0 && arr[left] > arr[left-1]) left--;
                while(right < arr.length-1 && arr[right] > arr[right+1]) right++;
                maxMountainLen = Math.max(maxMountainLen, (right-left)+1);
            }
        }
        return maxMountainLen;
    }
}