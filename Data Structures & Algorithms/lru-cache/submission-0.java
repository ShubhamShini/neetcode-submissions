class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key,int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer,Node> map;

    Node head;
    Node tail;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }   

    private void insert(Node node){

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            remove(node);
            insert(node);
            return;
        }

        // Case 2 & 3: New key
        if (map.size() == capacity) {
            // Remove the least recently used node
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        // Create and insert the new node
        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);
    }
}
