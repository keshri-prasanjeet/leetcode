class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m-1;
        while(top<=bottom){
            int middle = top + (bottom-top)/2;
            if(matrix[middle][0] <= target && target <=matrix[middle][n-1]){
                int left = 0;
                int right = n-1;
                while(left <= right){
                    int mid = left + (right-left)/2;
                    if(matrix[middle][mid] == target) return true;
                    else if(matrix[middle][mid] > target) right = mid-1;
                    else left = mid+1;
                }
                break;
            }
            else if(matrix[middle][0]>target) bottom = middle-1;
            else top = middle+1;
        }
        return false;
    }
}