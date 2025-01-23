class RandomizedSet {
    List<Integer> randList;
    Map<Integer,Integer> randMap;
    Random random;
    public RandomizedSet() {
        randList = new ArrayList<>();
        randMap = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(!randMap.containsKey(val)){
            randList.add(val);
            randMap.put(val, randList.size()-1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(randMap.containsKey(val)){
            int index = randMap.get(val);
            int lastNum = randList.get(randList.size()-1);
            randList.set(index, lastNum);
            randMap.put(lastNum, index);
            randMap.remove(val);
            randList.remove(randList.size()-1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return randList.get(random.nextInt(randList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */