class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<List<Object>>> adjacencyList = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String fir = equations.get(i).get(0);
            String sec = equations.get(i).get(1);
            double value = values[i];

            adjacencyList.putIfAbsent(fir, new ArrayList<>());
            adjacencyList.get(fir).add(Arrays.asList(sec, value));

            adjacencyList.putIfAbsent(sec, new ArrayList<>());
            adjacencyList.get(sec).add(Arrays.asList(fir, 1.0/value));
        }

        double[] answer = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            answer[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adjacencyList);
        }
        return answer;
    }

    private double bfs(String src, String target, Map<String, List<List<Object>>> adjacencyList){
        if(!adjacencyList.containsKey(src) || !adjacencyList.containsKey(target)) return -1.0;

        Queue<Object[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.offer(new Object[]{src, 1.0});
        visited.add(src);
        while(!q.isEmpty()){
            Object [] head = q.poll();
            String node = (String) head[0];
            double value = (double) head[1];

            if(node.equals(target)) return value;

            for(List<Object> neighbors: adjacencyList.get(node)){
                String nei = (String) neighbors.get(0);
                double wei = (double) neighbors.get(1);

                double newWeight = wei * value;
                if(!visited.contains(nei)){
                    q.offer(new Object[]{nei, newWeight});
                    visited.add(nei);
                }
            }
        }
        return -1.0;
    }
}