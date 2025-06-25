class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<len;i++){
            if(st.isEmpty()){
                st.push(i);
            }
            else{
                int top = st.peek();
                while(temperatures[top] < temperatures[i] && !st.isEmpty()){
                    answer[top]  = i-top;
                    st.pop();
                    if(!st.isEmpty()) top = st.peek();
                }
                st.push(i);
            }
        }
        return answer;
    }
}