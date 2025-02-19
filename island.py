from typing import List

def num_islands(grid: List[List[str]]) -> int:
    # Your implementation goes here
    DIRECTIONS = [(1,0),(-1,0),(0,1),(0,-1)]
    m,n = len(grid), len(grid[0])
    res = 0
    # we start at 1, traverse it's neighbors, make neighbots that's 1 as visited, when we return, add one
    # into our res
    def dfs(x,y):
        if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] == "0" :
            return
        grid[x][y] = "0" 
        for dx, dy in DIRECTIONS:
            new_x, new_y = x+dx, y+dy
            dfs(new_x,new_y)

    for i in range(m):
        for j in range(n):
            if grid[i][j] == "1":
                dfs(i,j)
                res += 1
    return res 

                


    

# Running the test cases


def test_num_islands(func):
    test_cases = [
        (
            [  # ✅ 1 island
                ["1", "1", "1", "1", "0"],
                ["1", "1", "0", "1", "0"],
                ["1", "1", "0", "0", "0"],
                ["0", "0", "0", "0", "0"]
            ],
            1
        ),
        (
            [  # ✅ 3 islands
                ["1", "1", "0", "0", "0"],
                ["1", "1", "0", "0", "0"],
                ["0", "0", "1", "0", "0"],
                ["0", "0", "0", "1", "1"]
            ],
            3
        ),
        (
            [  # ✅ 0 islands
                ["0", "0", "0", "0", "0"],
                ["0", "0", "0", "0", "0"],
                ["0", "0", "0", "0", "0"]
            ],
            0
        ),
        (
            [  # ✅ 5 islands (Each '1' is separate)
                ["1", "0", "1", "0", "1"],
                ["0", "1", "0", "1", "0"],
                ["1", "0", "1", "0", "1"]
            ],
            8
        ),
        (
            [  # ✅ 1 large island (all '1's are connected)
                ["1", "1", "1"],
                ["1", "1", "1"],
                ["1", "1", "1"]
            ],
            1
        )
    ]

    for i, (grid, expected) in enumerate(test_cases):
        result = func(grid)
        assert result == expected, f"Test case {i+1} failed: input({grid}) got {result}, expected {expected}"
        print(f"Test case {i+1} passed!")

# Run the test function with your solution
test_num_islands(num_islands)
