class TimeMap {
    Map<String, TreeMap<Integer, String>> tMap;
    public TimeMap() {
        tMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        tMap.computeIfAbsent(key, k-> new TreeMap()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> map = tMap.get(key);
        if(map==null) return "";
        Integer floorKey = map.floorKey(timestamp);
        return floorKey == null ? "" : map.get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */