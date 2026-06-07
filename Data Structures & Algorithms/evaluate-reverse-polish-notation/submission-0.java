class Solution {
    public int evalRPN(String[] tokens) {
        // reverse polish notation is when operands 
        // follow the numbers being used in the operation
        // in a stack,
        //  pushing numbers onto a stack and applying 
        // operators by popping operands, then
        // pushing the result back. 
        Stack<Integer> stack = new Stack<>();
        for(String c : tokens){
            if(c.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")){
                int a = stack.pop();
                // ints when order matters
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
