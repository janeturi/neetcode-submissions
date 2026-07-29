class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = collections.deque() # initialize a queue with positions of all ortten oranges
        fresh, time = 0, 0

        for r in range(len(grid)): # go through entire grid to count number of fresh oranges
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    fresh += 1 
                if grid[r][c] == 2: # if rotten, mark down into our queue
                    q.append((r, c))
            
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while fresh > 0 and q: # while we still have fresh oranges or oranges that can rot
            for i in range(len(q)):
                r, c = q.popleft()

                for dr, dc in directions:
                    row, col = r + dr, c + dc
                    if (row in range(len(grid)) and col in range(len(grid[0])) and grid[row][col] == 1):
                        # if neighbors are valid and fresh
                        grid[row][col] = 2 # make rot
                        q.append((row, col)) # add to rot list
                        fresh -= 1 # fresh goes down
            time += 1 # time goes up for each iteration
        return time if fresh == 0 else -1 # return time if fresh goes up, if there are leftover frsh fruit, we throw awya