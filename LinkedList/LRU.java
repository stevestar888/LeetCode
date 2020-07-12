class LRUCache {

    //always add new node to teh front, indicating it's the most recently used one
    //when the size exceedes capacity, remove the last one; (prev of tail)
    //change map value when new node's key exists.  
    
    //doubly linked list declaration
    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
            next = null;
            prev = null;
        }
    }
    
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> map = new HashMap();
    int size;
    
    //remove the end node, which is teh least recent used node
    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    //add at the head
    public void add(Node n) {
        Node next = head.next;
        head.next = n;
        n.prev = head;
        n.next = next;
        next.prev = n;
    }
    
    public LRUCache(int capacity) {
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    //if exists, change the value in the map
    //else remove the whole thing and add new node and map entry altogether
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            remove(map.get(key));
            add(node);
            map.put(key, node);
        } else {
            if (map.size() >= size) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            map.put(key, node);
            add(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */