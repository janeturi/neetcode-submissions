class MyQueue:
    # we want to implement fifo using two lifo 
    # we can do this by having 1 stack where we push everything onto one stack
    # and then now when we use the second stack, it'll be in reverse reverse order so 
    # it now works like a queue
    def __init__(self):
        self.s1 = [] 
        self.s2 = []

    def push(self, x: int):
        self.s1.append(x) # our first stack handles the incoming elements in our q

    def pop(self) -> int:
        self.peek() # so since we end up having our s2 holding the actual top of q, we use peek
        # to get the top
        return self.s2.pop() # and then just pop like normal

    def peek(self) -> int:
        if not self.s2: # if empty
            while self.s1: # while elemnts still remain
                self.s2.append(self.s1.pop()) # we pop elements off of s1 and push them onto
                # s2, so now its in reverse reverse order
        return self.s2[-1] # so to peek, now we just return the top of s2

    def empty(self):
        return not self.s1 and not self.s2 # return if either stacks r empty

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()