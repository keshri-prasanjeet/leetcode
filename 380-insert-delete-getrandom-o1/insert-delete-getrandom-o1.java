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
        int indexOfNumber = randMap.get(val);
        nums.set(indexOfNumber, nums.get(nums.size()-1));
        randMap.put(nums.get(indexOfNumber),indexOfNumber);
        randMap.remove(val);
        nums.remove(nums.size()-1);
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