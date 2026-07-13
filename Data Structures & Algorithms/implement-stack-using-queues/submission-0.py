class MyStack:
    # we can create a new queue/node for each push containing values and references
    # to prev, which is basically just making a linkedlist to make a queue to mke a stack
    # by using a deque, we can make sure to only push and pull from the front and ignore
    # the actual queue part
    def __init__(self):
        self.q = None # empty stack

    def push(self, x: int) -> None:
        self.q = deque([x, self.q]) # our queue, we push our x as our first eleent
        # and the old q as the second so [0, 1] -> [2, [0, 1]].. 
        # "python reads left to right. index 0 becomes the front (left) of the queue
        # and the last index becomes the back (right)."

    def pop(self) -> int:
        top = self.q.popleft() # so, when we want to 'pop' we just go ahead and adjust the pointers
        # so top will point to q and q will point to the one after q
        self.q = self.q.popleft()
        return top

    def top(self) -> int:
        return self.q[0] # return top/first element

    def empty(self) -> bool:
        return not self.q # return true if our queue/stack is null


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()