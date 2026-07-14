class MinStack:
# we want to implement a regular stack that also supports a getMin funct
# lifo
    def __init__(self):
        self.stack = [] # initialize our stack
 
    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append((val, val)) # if empty, append value  given
        else: # we do this empty check to prevent an error
            self.stack.append((val, min(self.getMin(), val))) # else, append like normal
            # but take note of the minimum value

    def pop(self) -> None:
        if self.stack: 
            return self.stack.pop() # if not empty, pop the element on top 

    def top(self) -> int:
        return self.stack[-1][0] # top returns our top value like normal

    def getMin(self) -> int:
        return self.stack[-1][1] # our min returns the second part of our tuple that holds
        # the 
