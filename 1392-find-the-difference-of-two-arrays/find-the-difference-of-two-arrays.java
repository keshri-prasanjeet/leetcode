class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();
        for(int n: nums1){
            n1.add(n);
        }
        for(int n: nums2){
            n2.add(n);
        }
        Set<Integer> ans1 = new HashSet<>();
        for(int n: nums2){
            if(!n1.contains(n)) ans1.add(n);
        }
        Set<Integer> ans2 = new HashSet<>();
        for(int n: nums1){
            if(!n2.contains(n)) ans2.add(n);
        }
        List<List<Integer>> finalAns = new ArrayList<>();
        finalAns.add(new ArrayList<>(ans2));
        finalAns.add(new ArrayList<>(ans1));
        return finalAns;
    }
}