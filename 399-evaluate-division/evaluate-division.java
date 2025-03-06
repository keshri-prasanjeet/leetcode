class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<List<Object>>> adj = new HashMap<>();
        //build the adjacency list first
        for(int i=0;i<equations.size();i++){
            String num = equations.get(i).get(0);
            String den = equations.get(i).get(1);
            double value = values[i];

            adj.putIfAbsent(num, new ArrayList<>());
            adj.putIfAbsent(den, new ArrayList<>());
            adj.get(num).add(List.of(den, value));
            adj.get(den).add(List.of(num, 1.0/value));
        }

        //define the answer
        double[] answer = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            answer[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adj);
        }
        return answer;
    }

    private double bfs(String src, String target, Map<String, List<List<Object>>> adj){
        if(!adj.containsKey(src) || !adj.containsKey(target)) return -1.0;
        Queue<Object[]> q = new ArrayDeque<>();//why not linkedlist??
        Set<String> visited = new HashSet<>();

        q.offer(new Object[]{src, 1.0});
        visited.add(src);

        while(!q.isEmpty()){
            Object[] top = q.poll();
            String nodeKey = (String) top[0];
            double nodeVal = (double) top[1];

            if(nodeKey.equals(target)) return nodeVal;

            for(List<Object> neighbor: adj.get(nodeKey)){
                String neighborKey = (String) neighbor.get(0);
                if(!visited.contains(neighborKey)){
                    double neighborVal = (double) neighbor.get(1);
                    double newVal = nodeVal * neighborVal;
                    q.offer(new Object[]{neighborKey, newVal});
                    visited.add(neighborKey);
                }
            }
        }

        return -1.0;

    }
}