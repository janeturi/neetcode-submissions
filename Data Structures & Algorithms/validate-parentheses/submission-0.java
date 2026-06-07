class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> closeToOpen = new HashMap<>();
        // hashmap includes all possible choices
        closeToOpen.put(')', '(');
        closeToOpen.put( ']', '[');
        closeToOpen.put( '}', '{');

        for(char c : s.toCharArray()){
            // go through string
            if(closeToOpen.containsKey(c)) {
                // go through hashmap and check if hash has characters in string
                if(!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                    // if the stack isnt empty and we can see that
                    // we're gonna get c 
                    // remove it
                } else {
                    return false; // if its empty or we dont have anything
                    // in the hash,
                    // we return false
                } 
            } else {
                stack.push(c); // if we dont have 
            }
        }
        return stack.isEmpty();

    }
}
