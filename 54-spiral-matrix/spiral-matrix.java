class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;

        int up = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;

        while(res.size() < m*n){
            int i;
            for(i=left;i<=right && res.size()< m*n ; i++){
                res.add(matrix[up][i]);
            }

            for(i=up+1;i<=down-1 && res.size() < m*n; i++){
                res.add(matrix[i][right]);
            }

            for(i=right;i>=left && res.size() < m*n; i--){
                res.add(matrix[down][i]);
            }

            for(i=down-1;i>=up+1 && res.size() < m*n; i--){
                res.add(matrix[i][left]);
            }
            up++; down--; left++; right--;
        }
        return res;
    }
}