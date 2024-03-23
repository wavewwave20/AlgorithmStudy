from collections import deque


def solution(n, wires):
    
    answer = n

    def bfs(start, wires):
        que = deque([start])
        visited[start] = True
        
        towerCount = 1
        
        while que:
            current = que.popleft()
            
            for wire in wires:
                if wire[0]-1 == current \
                and visited[wire[1]-1] == False:
                    visited[wire[1]-1] = True
                    que.append(wire[1]-1)
                    towerCount += 1
                elif wire[1]-1 == current and visited[wire[0]-1] == False:
                    visited[wire[0]-1] = True
                    que.append(wire[0]-1)
                    towerCount += 1
            
        return towerCount
    
    for i in range(len(wires)):
        cuttedWires = [value for index, value in enumerate(wires) if index != i]
        cuttedWire = wires[i]
        
        visited = [False for _ in range(n)]
        
        num = bfs(cuttedWire[0]-1,cuttedWires)

        result = abs(n - 2 * num)
        
        if result < answer:
            answer = result

    return answer