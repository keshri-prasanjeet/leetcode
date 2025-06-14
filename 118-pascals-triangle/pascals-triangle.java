class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(List.of(1)));
        if(numRows == 1) return answer;
        answer.add(new ArrayList<>(List.of(1,1)));
        if(numRows == 2) return answer;

        for(int i=2;i<numRows;i++){
            List<Integer> aux = new ArrayList<>();
            int loop = i-1;
            aux.add(1);
            while(loop != 0){
                aux.add(answer.get(i-1).get(loop-1) + answer.get(i-1).get(loop));
                loop--;
            }
            aux.add(1);
            answer.add(new ArrayList<>(aux));
        }
        return answer;
    }
}