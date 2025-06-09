class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i =0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] connection:connections){
            int from = connection[0];
            int to = connection[1];
            adjList.get(from).add(new int[]{to, 1});
            adjList.get(to).add(new int[]{from, 0});
        }
        return dfs(adjList, visited, 0);
    }

    private int dfs(List<List<int[]>> adjList, boolean[] visited, int city){
        int flips = 0;
        visited[city] = true;
        for(int[] neighbourAndDirection: adjList.get(city)){
            int neighbour = neighbourAndDirection[0];
            int direction = neighbourAndDirection[1];
            if(!visited[neighbour]){
                flips+= direction;
                flips+= dfs(adjList, visited, neighbour);
            }
        }
        return flips;
    }
}