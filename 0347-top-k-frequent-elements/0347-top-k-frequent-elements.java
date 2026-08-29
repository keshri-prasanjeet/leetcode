class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(frequencyMap.get(b), frequencyMap.get(a)));

        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        frequencyMap.forEach((key,value) -> {
            pq.offer(key);
        });

        int[] ans = new int[k];
        int i = 0;
        while(i<k){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}