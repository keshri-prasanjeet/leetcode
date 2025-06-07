class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //the centrepoint of this problem, the adjancency list
        Map<String, List<List<Object>>> adjList = new HashMap<>();

        for(int i=0;i<equations.size();i++){
            String numerator = equations.get(i).get(0);
            String denominator=equations.get(i).get(1);
            double value = values[i];

            adjList.putIfAbsent(numerator, new ArrayList<>());
            adjList.putIfAbsent(denominator, new ArrayList<>());

            adjList.get(numerator).add(List.of(denominator, value));
            adjList.get(denominator).add(List.of(numerator, 1.0/value));
        }

        double[] answer = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            answer[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adjList);
        }

        return answer;
    }

    private double bfs(String src, String target, Map<String, List<List<Object>>> adjList){
        if(!adjList.containsKey(src) || !adjList.containsKey(target)) return -1.0;
        Queue<Object[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(new Object[]{src, 1.0});
        visited.add(src);
        while(!q.isEmpty()){
            Object[] top = q.poll();
            String exKey = (String) top[0];
            double exVal = (double) top[1];

            if(exKey.equals(target)) return exVal;
            //this key is not the target, explore the neighbors

            for(List<Object> neighbour: adjList.get(exKey)){
                String neighbourKey = (String) neighbour.get(0);
                if(!visited.contains(neighbourKey)){
                    double neighbourVal = (double) neighbour.get(1);
                    q.offer(new Object[]{neighbourKey, neighbourVal * exVal});
                    visited.add(neighbourKey);
                }
            }
        }
        return -1.0;
    }
}