class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # when we encounter a '1', a land cell, we use bfs to visit all connected land and mark
        # as water to make sure no island is counted twice
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        rows, cols = len(grid), len(grid[0])
        islands = 0

        def bfs(r, c):
            q = deque() 
            grid[r][c] = "0"
            q.append((r, c)) # push starting cell into queue and mark as visited + add to q

            while q: # while we have unprocessed cells
                row, col = q.popleft()
                for dr, dc in directions: # for each direction via row or colums, scans ffor islands
                    nr, nc = dr + row, dc + col # nr and nc are where we are based off movements given by dr and dc, these are for filling in our islands
                    if (nr < 0 or nc < 0 or nr >= rows) or (nc >= cols) or (grid[nr][nc] == "0"): # out of bounds or visited
                    # goes too far back or too far up
                        continue
                    q.append((nr, nc)) # append the new cell to our queue
                    grid[nr][nc] = "0"  #then mark as seen

        for r in range(rows): # traverse whole grid
            for c in range(cols):
                if grid[r][c] == "1": # when land is found, increment island count and bfs from that cell
                    bfs(r, c)
                    islands += 1
        
        return islands