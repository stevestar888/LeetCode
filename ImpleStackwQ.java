//Implementing a stack using one queue
//Cycle the last item in the queue to the front after a push
//to simulate the FIFO of stack.
class MyStack {

    Queue<Integer> q = new LinkedList();
    int top = 0;
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        int c = q.size();
        while (c != 1) {
            q.offer(q.poll());
            c--;
        }       
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}