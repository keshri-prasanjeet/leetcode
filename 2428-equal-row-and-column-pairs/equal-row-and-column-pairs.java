class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> rowMap = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        int equalPairCount = 0;
        for(int i=0;i<m;i++){
            String rowNum = Arrays.toString(grid[i]);
            rowMap.put(rowNum, rowMap.getOrDefault(rowNum,0)+1);
        }
        int[] temp = new int[m];
        int index = 0;
        for(int i=0;i<n;i++){
            index = 0;
            for(int j=0;j<m;j++){
                temp[index++] = grid[j][i];
            }
            String colNum = Arrays.toString(temp);
            equalPairCount += rowMap.getOrDefault(colNum, 0);
        }

        return equalPairCount;
    }
}