class Solution {
    private void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack){
        if(openN == closedN && openN == n){
            // a complete & valid string is when there's enough open ns
            // and its the same as closed ns
            res.add(stack.toString());
            return;
        }

        if(openN < n){ // if u have less than n valid openings left, aka
        // u can add enough
            stack.append('('); // add open parantheses
            backtrack(openN + 1, closedN, n, res, stack);
            // now check through the rest of the string to see if we can add
            // another open parantheses,
            // openN + 1 to inc count
            stack.deleteCharAt(stack.length() - 1);
            // delete to check other options of valid parantheses
        }

        if(closedN < openN){
            // same logic as before, but with a closed parantheses
            // bc we want to add the same as open
            stack.append(')'); 
            backtrack(openN, closedN + 1, n, res, stack); // closeN + 1 to increase count
            stack.deleteCharAt(stack.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); // result 
        StringBuilder stack = new StringBuilder(); // stack to hold the subset of parantheses
        backtrack(0, 0, n, res, stack); // beginning 
        return res;
    }
}
