class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        findCombinations(1, n, k, new ArrayList<>());
        return combinations;
    }

    private void findCombinations(int startNum, int n, int k, List<Integer> combination){
        if(combination.size() == k){
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for(int i = startNum; i<=n; i++){
            combination.add(i);
            findCombinations(i+1,n,k,combination);
            combination.remove(combination.size()-1);
        }
    }
}