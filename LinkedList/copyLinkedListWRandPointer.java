/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        if (head == null)
            return null;
        
        Node newHead = new Node(head.val);
        Node newCur = newHead;
        Node cur = head;
        
        while (cur != null) {
            if (cur.next == null) {
                newCur.next = null;
                map.put(cur, newCur);
                cur = cur.next;
                continue;
            }
            Node newNext = new Node(cur.next.val);
            newCur.next = newNext;
        
            map.put(cur, newCur);
            newCur = newCur.next;
            cur = cur.next;
        }
        
        cur = head;
        
        while (cur != null) {
            if (cur.random != null) {
                map.get(cur).random = map.get(cur.random);
            } else 
                map.get(cur).random = null;
            
            cur = cur.next;  
        }       
        return newHead;        
    }
}