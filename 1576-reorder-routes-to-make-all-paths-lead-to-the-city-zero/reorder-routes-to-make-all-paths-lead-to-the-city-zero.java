class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        while(n-- > 0){
            graph.add(new ArrayList<>());
        }
        for(int [] connection: connections){
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }

        //do dfs now
        
        return dfs(0, visited, graph);

    }

    private int dfs(int node, boolean[] visited, List<List<int[]>> graph){
        int flips = 0;
        visited[node] = true;

        for(int[] neighbourDirection: graph.get(node)){
            int neighbour = neighbourDirection[0];
            if(!visited[neighbour]){
                flips+=neighbourDirection[1];
                flips+=dfs(neighbour, visited, graph);
            }
        }
        return flips;
    }
}