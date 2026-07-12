class Solution:
    def isValid(self, s: str) -> bool:
        # given a string w () {} [], return true if each bracket
        # has a matchign ending bracket and is in the right order

        # idea: we can track ending brackets and see if it matches the latest
        # opening bracket (top of stack), if it matches-remove, if it doesnt- return False

        stack = []

        pairs = { ")" : "(", "]" : "[", "}" : "{"}

        for c in s: # for each character in our string
            if c in pairs: # if our match is a closing bracket, this syntax specifically
            # only looks at the keys, which in our pairs funct. is our closing bracket
                if stack and stack[-1] == pairs[c]: # check if the stack isnt empty
                # and check if the top of the stack matches the opening bracket
                # pairs[c] is the actual value, so we check if the actual value is the same as 
                # our top of stack
                    stack.pop() # pop if yes
                else:
                    return False # else invalid
            else: 
                stack.append(c) # else, it's an opening bracket so go ahead and push onto stack
        return not stack # if empty, it'll return true, otherwise, it'll return false