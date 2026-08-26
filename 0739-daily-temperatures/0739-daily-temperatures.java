class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer =new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                //we have found a new temperature that is > than a previous temperature
                int prev = stack.pop();
                answer[prev] = i-prev;
            }
            stack.push(i);
        }
        return answer;
    }
}