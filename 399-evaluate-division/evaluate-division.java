class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<List<Object>>> adjList = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double val = values[i];

            adjList.putIfAbsent(numerator, new ArrayList<>());
            adjList.putIfAbsent(denominator, new ArrayList<>());

            adjList.get(numerator).add(List.of(denominator, val));
            adjList.get(denominator).add(List.of(numerator, 1.0 / val));
        }

        //do dfs to find the values for queries
        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            answer[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adjList);
        }
        return answer;
    }

    private double bfs(String src, String target, Map<String, List<List<Object>>> graph) {
        if (!graph.containsKey(src) || !graph.containsKey(target))
            return -1.0;
        Set<String> visited = new HashSet<>();
        Queue<Object[]> q = new ArrayDeque<>();
        q.offer(new Object[] { src, 1.0 });
        visited.add(src);
        while (!q.isEmpty()) {
            Object[] top = q.poll();
            String ex = (String) top[0];
            double val = (double) top[1];

            if (ex.equals(target))
                return val;

            for (List<Object> neighbours : graph.get(ex)) {
                String neighbourKey = (String) neighbours.get(0);
                if (!visited.contains(neighbourKey)) {
                    double neighbourVal = (double) neighbours.get(1);
                    q.offer(new Object[] { neighbourKey, neighbourVal * val });
                    visited.add(neighbourKey);
                }
            }
        }
        return -1.0;
    }
}