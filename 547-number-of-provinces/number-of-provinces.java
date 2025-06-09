class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        Queue<Integer> cityQ = new ArrayDeque<>();
        visited = new boolean[len];
        int provinceCount = 0;
        for(int i=0;i<len;i++){
            if(visited[i]!=true){
                dfs(cityQ, isConnected, i);
                provinceCount++;
            }
        }
        return provinceCount;
    }

    private void dfs(Queue<Integer> cityQ, int[][] adj, int start){
        cityQ.offer(start);
        visited[start] = true;
        while(!cityQ.isEmpty()){
            int city = cityQ.poll();
            for(int i=0;i<adj.length;i++){
                if(adj[i][city] == 1){
                    if(!visited[i]){
                        cityQ.offer(i);
                        visited[i]=true;
                    }
                }
            }
        }
    }
}