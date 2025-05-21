class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> rowMap = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        StringBuilder sb = new StringBuilder();
        int equalPairCount = 0;
        for(int i=0;i<m;i++){
            sb.setLength(0);
            for(int num: grid[i]){
                sb.append(num).append("÷");
            }
            String rowNum = sb.toString();
            rowMap.put(rowNum, rowMap.getOrDefault(rowNum,0)+1);
        }

        for(int i=0;i<n;i++){
            sb.setLength(0);
            for(int j=0;j<m;j++){
                sb.append(grid[j][i]).append("÷");
            }
            String colNum = sb.toString();
            equalPairCount += rowMap.getOrDefault(colNum, 0);
        }

        return equalPairCount;
    }
}