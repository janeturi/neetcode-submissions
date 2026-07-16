class Solution:
    # we take a list of strings to a string
    
    def encode(self, strs: List[str]) -> str:
        # parse each character and then just append???
        res = []
        for s in strs:
            res.append(str(len(s))) # append empty space for the length of the string
            res.append("#") 
            res.append(s) 
        return "".join(res)

    def decode(self, s: str) -> List[str]: 
        # add like a '#' or something to seperate each new thing but idk how
        # that wont affect the og string
        res = []
        i = 0
        while i < len(s): # while not done processing everything
            j = i # current string
            while s[j] != '#':
                j += 1 # move along string until we reach end
            length = int(s[i:j]) # length is size of two pointers
            i = j + 1 # move to end of next word
            j = i + length # ^ move to next word
            res.append(s[i:j]) # append as new
            i = j # move to next
        return res










       