class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //make a priority queue to put the more frequent items in the front and then deque it
        Map<Integer, Integer> freqMap = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(freqMap.get(b), freqMap.get(a)));
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        freqMap.forEach((key, valeu) -> {
            pq.offer(key);
        });
        int[] answer = new int[k];
        int i=0;
        while(i<k){
            answer[i] = pq.poll();
            i++;
        }
        return answer;
    }
}