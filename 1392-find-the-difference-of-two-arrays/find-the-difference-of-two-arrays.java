class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        Set<Integer> onlyInNums1 = new HashSet<>(set1);
        Set<Integer> onlyInNums2 = new HashSet<>(set2);

        onlyInNums2.removeAll(set1);
        onlyInNums1.removeAll(set2);

        return List.of(new ArrayList<>(onlyInNums1), new ArrayList<>(onlyInNums2));
    }
}