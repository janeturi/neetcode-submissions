class MinStack {
    private Stack<Integer> stack; 
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>(); // stores pushed values
        minStack = new Stack<>(); // stores minimum
        // so far at each level
    }
    
    public void push(int val) {
        stack.push(val); // push onto main stack
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);  // checks val being pushed 
            // against current min in minStack, pushes if 
            // it's truly a min
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return; 
        int top = stack.pop();
        // pops from top like normal
        if (top == minStack.peek()){
            // only pops if top is min
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
        // return top of stack via peek
    }
    
    public int getMin() {
        return minStack.peek();
        // return min via peek
    }
}
