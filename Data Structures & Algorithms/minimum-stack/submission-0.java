class pair {
    int val;
    int min;

    pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
class MinStack {
    private Stack<pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new pair(val,val));
        } else {
            int currMin = Math.min(val, stack.peek().min);
            stack.push(new pair(val, currMin));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
