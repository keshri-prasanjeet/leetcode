class Solution {
    public boolean isHappy(int n) {
        //how to not fall into an infinite loop???
        //if while doing the sum and square, i get the same sum agina, break out, this is a loop
        Set<Integer> uniqueSums = new HashSet<>();
        while(n!=1){
            int sumOfDigits = getSumOfDigits(n);
            if(!uniqueSums.contains(sumOfDigits)){
                uniqueSums.add(sumOfDigits);
                n = sumOfDigits;
            }
            else return false;
        }
        return true;
    }

    private int getSumOfDigits(int n){
        int sum = 0;
        while(n!=0){
            sum += (n%10) * (n%10);
            n/=10;
        }
        return sum;
    }
}