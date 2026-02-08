class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        if(k > len) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;
        while(right < len){
            sum += arr[right];
            if(right - left + 1 == k){
                if((sum / k) >= threshold){
                    answer++;
                }
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return answer;
    }
}