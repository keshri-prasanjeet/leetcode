class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int totalProvinces = 0;

        for(int i=0;i<len;i++){
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                totalProvinces++;
            }
            
        }
        return totalProvinces;
    }

    private void dfs(int[][] adj, boolean[] visited, int start){
        Queue<Integer> cityQ = new LinkedList<>();
        cityQ.offer(start);
        visited[start] = true;
        while(!cityQ.isEmpty()){
            int city = cityQ.poll();
            for(int i=0;i<adj.length;i++){
                if(adj[city][i]==1 && !visited[i]){
                    cityQ.offer(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}