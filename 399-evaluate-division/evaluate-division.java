class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<List<Object>>> adj = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String n = equations.get(i).get(0);
            String d = equations.get(i).get(1);
            double value = values[i];

            adj.putIfAbsent(n, new ArrayList<>());
            adj.putIfAbsent(d, new ArrayList<>());

            adj.get(n).add(List.of(d, value));
            adj.get(d).add(List.of(n, 1.0/value));
        }

        double[] answer = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            answer[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adj);
        }

        return answer;
    }

    private double bfs(String src, String target, Map<String, List<List<Object>>> adj){
        if(!adj.containsKey(src) || !adj.containsKey(target)) return -1.0;
        Queue<Object[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.offer(new Object[]{src, 1.0});
        visited.add(src);

        while(!q.isEmpty()){
            Object[] top = q.poll();
            String key = (String) top[0];
            double val = (double) top[1];
            if(key.equals(target)) return val;

            for(List<Object> neighbor: adj.get(key)){
                String neighborKey = (String) neighbor.get(0);
                double neighborVal = (double) neighbor.get(1);
                double newVal = neighborVal * val;
                if(!visited.contains(neighborKey)){
                    q.offer(new Object[]{neighborKey, newVal});
                    visited.add(neighborKey);
                }
            }
        }

        return -1.0;
    }
}