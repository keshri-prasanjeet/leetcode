class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> minHeapL = new PriorityQueue<>();
        PriorityQueue<Integer> minHeapR = new PriorityQueue<>();

        int i=0;
        int j = n-1;
        for(int count = 0; count<candidates; count++){
            if(i<=j){
                minHeapL.offer(costs[i++]);
            }
            if(i<=j){
                minHeapR.offer(costs[j--]);
            }
        }

        long totalCost = 0;
        while(k-- > 0){
            int leftPeek = minHeapL.isEmpty() ? Integer.MAX_VALUE : minHeapL.peek();
            int rightPeek = minHeapR.isEmpty()? Integer.MAX_VALUE : minHeapR.peek();

            if(leftPeek <= rightPeek){
                totalCost+=minHeapL.poll();
                if(i<=j){
                    minHeapL.offer(costs[i++]);
                }
            }
            else{
                totalCost+=minHeapR.poll();
                if(i<=j){
                    minHeapR.offer(costs[j--]);
                }
            }
        }
        return totalCost;
    }
}