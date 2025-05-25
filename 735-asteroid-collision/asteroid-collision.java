class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> space = new Stack<>();
        boolean incomingSurvives = false;
        boolean shouldPush = true;
        for(int asteroid : asteroids){
            incomingSurvives = false;
            shouldPush = true;
            if(space.isEmpty()){
                space.push(asteroid);
            }
            else{
                int top = space.peek();
                if(top < 0){
                    space.push(asteroid);
                }
                else if(asteroid > 0){
                    space.push(asteroid);
                }
                else{
                    while(!space.isEmpty() && space.peek() > 0){
                        top = space.peek();
                        if(top < -asteroid){
                            space.pop();
                            incomingSurvives = true;
                        }
                        else if(top == -asteroid){
                            space.pop();
                            incomingSurvives = false;
                            shouldPush = false;
                            break;
                        }
                        else {
                            incomingSurvives = false;
                            break;
                        }
                    }
                    if(space.isEmpty() || incomingSurvives) {
                        if(shouldPush) space.push(asteroid); //incoming destroyed all
                    }
                
                }
            }
        }
        return space.stream().mapToInt(Integer::intValue).toArray();
    }
}