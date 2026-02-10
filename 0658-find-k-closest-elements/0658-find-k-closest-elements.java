class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int left = 0;
        int right = len - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // first mid is 2
            // now i have to check for two windows
            // one starting from mid and another starting from mid+1
            // in both of these windows, the difference maker is left and right
            // left is mid node and right is mid+k node
            // 1,2,3,4,5
            //   ^ â
            // 2 is start of mid window = 2,3,4
            // 3 is start of mid + 1 window = 3,4,5
            // the difference between these two nodes is 2 and 5
            int leftDiff = x - arr[mid];
            int rightDiff = arr[mid + k] - x;
            // System.out.println("at left " + left);
            // System.out.println("at right " + right);
            // System.out.println("at mid " + mid);
            // System.out.println("left diff is  " + leftDiff);
            // System.out.println("right diff is  " + rightDiff);
            if (leftDiff > rightDiff) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            answer.add(arr[i]);
        }
        return answer;
    }
}