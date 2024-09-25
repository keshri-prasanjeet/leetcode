class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<List<Object>>> adj = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String fir = equations.get(i).get(0);
            String sec = equations.get(i).get(1);
            double value = values[i];

            adj.putIfAbsent(fir, new ArrayList<>());
            adj.get(fir).add(Arrays.asList(sec, value));
            
            adj.putIfAbsent(sec, new ArrayList<>());
            adj.get(sec).add(Arrays.asList(fir, 1.0/value));
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
            Object[] head = q.poll();
            String node = (String) head[0];
            double weight = (double) head[1];
            
            if(node.equals(target)) return weight;

            for(List<Object> value: adj.get(node)){
                String nei = (String) value.get(0);
                double wei = (double) value.get(1);
                if(!visited.contains(nei)){
                    double newWeight = wei * weight;
                    q.offer(new Object[]{nei, newWeight});
                    visited.add(nei);
                }
            }
        }
        return -1.0;

    }
}