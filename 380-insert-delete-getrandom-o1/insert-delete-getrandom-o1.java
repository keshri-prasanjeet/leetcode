class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> randMap;
    private Random random;
    public RandomizedSet() {
        nums = new ArrayList<>();
        randMap = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(randMap.containsKey(val)){
            return false;
        }
        nums.add(val);
        randMap.put(val, nums.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!randMap.containsKey(val)){
            return false;
        }
        // int indexOfNumber = randMap.get(val);
        randMap.remove(val);
        nums.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */