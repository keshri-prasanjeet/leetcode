class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Object[]>> adjMatrix = new HashMap<>();
        int len = equations.size();
        for(int i=0;i<len;i++){
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            adjMatrix.putIfAbsent(numerator, new ArrayList<>());
            adjMatrix.putIfAbsent(denominator, new ArrayList<>());

            adjMatrix.get(numerator).add(new Object[]{denominator, values[i]});
            adjMatrix.get(denominator).add(new Object[]{numerator, 1.0/values[i]});
        }
        int Qlen = queries.size();
        double[] answer = new double[Qlen];
        for(int i=0;i<Qlen;i++){
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            answer[i] = solve(adjMatrix, start, end);
        }
        return answer;
    }

    private double solve(Map<String, List<Object[]>> adjMatrix, String start, String end){
        if(!adjMatrix.containsKey(start) || !adjMatrix.containsKey(end)){
            return -1.0;
        }
        Queue<Object[]> equationQ = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        equationQ.offer(new Object[]{start, 1.0});
        visited.add(start);
        while(!equationQ.isEmpty()){
            Object[] top = equationQ.poll();
            String key = (String) top[0];
            double val = (double) top[1];

            if(key.equals(end)) return val;
            for(Object[] neighbourAndVal: adjMatrix.get(key)){
                String neighbour = (String) neighbourAndVal[0];
                if(!visited.contains(neighbour)){
                    double neighbourVal = (double) neighbourAndVal[1];
                    equationQ.offer(new Object[]{neighbour, neighbourVal*val});
                    visited.add(neighbour);
                }
            }
        }
        return -1.0;
    }
}