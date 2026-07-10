class Solution:
    def calPoints(self, operations: List[str]) -> int:
        # keeping score of a baseball game where u start with an empty record:
        # given a list of strings, int x = score
        # + new operation that is sum of two prev scores
        # 'd' records a new score thats 2x prev score
        # 'c' invalidate prev score
        # return sum of scores after appllying all operstions

        # we use a stack instead of parsing like normal becuase of the 'c' operation, which
        # would be complicated to account for
        stack = []
        for op in operations:
            if op == "+":
                stack.append(stack[-1] + stack[-2]) # sum last 2
            elif op == "D":
                stack.append(2 * stack[-1]) # double last
            elif op == "C":
                stack.pop() # remove
            else:
                stack.append(int(op)) # if not an operation- it's a number, so just push onto the stack
        return sum(stack)