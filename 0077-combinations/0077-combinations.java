class Solution {
    int globalN;
    int globalK;
    List<List<Integer>> answer;
    public List<List<Integer>> combine(int n, int k) {
        globalN = n;
        globalK = k;
        answer = new ArrayList<>();
        findCombinations(new ArrayList<>(), 1);
        return answer;
    }

    private void findCombinations(List<Integer> combination, int startNum){
        if(combination.size() == globalK){
            answer.add(new ArrayList<>(combination));
            return;
        }

        for(int i=startNum; i<=globalN; i++){
            combination.add(i);
            findCombinations(combination, i+1);
            combination.remove(combination.size()-1);
        }
    }
}