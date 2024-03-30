def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 10000


    board = [[0 for i in range(104)] for _ in range(104)]

    for i in rectangle:
        currentx1 = i[0] * 2
        currenty1 = i[1] * 2
        currentx2 = i[2] * 2
        currenty2 = i[3] * 2

        for x in range(currentx1, currentx2+1, 1):
            for y in range(currenty1, currenty2+1, 1):
                #테두리 1
                if x == currentx1 or x == currentx2 or y == currenty1 or y== currenty2:
                    if board[y][x] != 2:
                        board[y][x] = 1
                #내부 2
                else:
                    board[y][x] = 2

    
    visited = []
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]

    def dfs(finish, current, length):
        x = current[0]
        y = current[1]
        local_answer = answer

        if (x, y) == finish:
            return length

        visited.append((x, y))

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if board[ny][nx] == 1 and (nx, ny) not in visited:
                local_answer = min(local_answer, dfs(finish, (nx, ny), length + 1))

        return local_answer

    answer = dfs((itemX*2,itemY*2), (characterX*2, characterY*2), 0) / 2
                
    return answer