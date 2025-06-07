class Solution {
    public int minReorder(int n, int[][] connections) {
        //make an adjacency list out of the 2d array connections List<List<int[]>>
        //in this adj list, index is the city and List<int[]> shows all the cities this index city is connected to
        //first element show the connected city and the second element shows the direction of it
        //start doing dfs and if you start from 0th index and recursively try to go all the cities.

        List<List<int[]>> adjList = new ArrayList<>();

        boolean[] visited = new boolean[n];
        while(n-- > 0){
            adjList.add(new ArrayList<>());
        }

        for(int[] connection: connections){
            int from  = connection[0];
            int to = connection[1];

            adjList.get(from).add(new int[]{to, 1});
            adjList.get(to).add(new int[]{from, 0});
        }

        return dfs(0, visited, adjList);

    }

    private int dfs(int city, boolean[] visited, List<List<int[]>> adjList){
        int flips = 0;
        visited[city] = true;

        for(int[] neighbourAndDirection: adjList.get(city)){
            int neighbour = neighbourAndDirection[0];
            int direction = neighbourAndDirection[1];
            if(!visited[neighbour]){
                flips += direction;
                flips += dfs(neighbour, visited, adjList);
            }
        }
        return flips;
    }

}