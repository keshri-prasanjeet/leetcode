class LRUCache {
    class Node{
        int val;
        int key;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    int cap;
    Map<Integer, Node> LRUMap;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.LRUMap = new HashMap<>();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void addNode(Node node){
        //this needs to go at the front
        Node temp = head.next;
        node.next = temp;
        temp.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void deleteNode(Node node){
        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
    }
    
    public int get(int key) {
        if(LRUMap.containsKey(key)){
            //get the value
            //move stuff around
            Node node = LRUMap.get(key);
            int value = node.val;
            deleteNode(node);
            addNode(node);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(LRUMap.containsKey(key)){
            //update the value
            //restructure again
            Node node = LRUMap.get(key);
            LRUMap.remove(key);
            deleteNode(node);
        }
        if(cap == LRUMap.size()){
            LRUMap.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        LRUMap.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */