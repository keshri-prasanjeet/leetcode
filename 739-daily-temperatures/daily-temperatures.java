class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<>();
        int[] answer = new int[temperatures.length];
        st.push(new Pair(temperatures[0], 0));
        for(int i=0;i<temperatures.length-1;i++){
            while(!st.isEmpty() && st.peek().val < temperatures[i+1]){
                Pair pop = st.pop();
                answer[pop.index] = (i+1) - (pop.index);
            }
            st.push(new Pair(temperatures[i+1], i+1));
        }
        return answer;
    }
}

class Pair{
    int val;
    int index;
    public Pair(int val, int index){
        this.val = val;
        this.index = index;
    }
}