class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Object[]>> adjMatrix = new HashMap<>();
        int index = 0;
        
        for(List<String> equation:equations){
            String numerator = equation.get(0);
            String denominator = equation.get(1);

            adjMatrix.putIfAbsent(numerator, new ArrayList<>());
            adjMatrix.putIfAbsent(denominator, new ArrayList<>());

            adjMatrix.get(numerator).add(new Object[]{denominator, values[index]});
            adjMatrix.get(denominator).add(new Object[]{numerator, 1.0/values[index]});
            index++;
        }
        int len = queries.size();
        double[] answer = new double[len];
        for(int i=0;i<len;i++){
            answer[i] = bfs(adjMatrix, queries.get(i).get(0), queries.get(i).get(1));
        }
        return answer;
    }

    private double bfs(Map<String, List<Object[]>> adjMatrix, String src, String tar){
        if(!adjMatrix.containsKey(src) || !adjMatrix.containsKey(tar)) return -1.0;

        Queue<Object[]> bfsQ = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        bfsQ.offer(new Object[]{src, 1.0});
        visited.add(src);
        while(!bfsQ.isEmpty()){
            Object[] top = bfsQ.poll();
            String operand = (String) top[0];
            double value = (double) top[1];

            if(operand.equals(tar)) return value;
            visited.add(operand);
            for(Object[] neighboursAndValues: adjMatrix.get(operand)){
                String neighbourKey = (String) neighboursAndValues[0];
                if(!visited.contains(neighbourKey)){
                    double neighbourVal = (double) neighboursAndValues[1];
                    bfsQ.offer(new Object[]{neighbourKey, value*neighbourVal});
                }
            }
        }
        return -1.0;
    }
}