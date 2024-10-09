class Solution {

    class Project{
        int capital;
        int profit;

        Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Queue<Project> capitalPq= new PriorityQueue<>((a,b)-> a.capital - b.capital);
        Queue<Project> profitPq = new PriorityQueue<>((a,b)-> b.profit - a.profit);
        

        for(int i=0;i<profits.length;i++){
            capitalPq.offer(new Project(capital[i], profits[i]));
        }

        while(k>0){
            while(!capitalPq.isEmpty() && capitalPq.peek().capital <= w){
                profitPq.offer(capitalPq.poll());
            }

            if(profitPq.isEmpty()){
                return w;
            }

            w += profitPq.poll().profit;

            k--;
        }

        return w;
    }
}