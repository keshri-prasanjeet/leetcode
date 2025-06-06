class Solution {
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean visited[] = new boolean[length];

        int provinces = 0;
        for(int i=0;i<length;i++){
            if(visited[i]) continue;
            dfs(isConnected, visited, i);
            provinces++;
        }
        return provinces;
    }

    private void dfs(int[][] matrix, boolean[] visited, int start){
        Queue<Integer> cityQ = new LinkedList<>();
        cityQ.offer(start);
        visited[start] = true;
        while(!cityQ.isEmpty()){
            int top = cityQ.poll();
            for(int j=0;j<visited.length;j++){
                if(matrix[top][j] == 1 && !visited[j]){
                    cityQ.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}