from collections import deque

def solution(maps):
    global n, m      # 전역변수 n, m
    n = len(maps[0]) # 가로
    m = len(maps)    # 세로
    visited = [[0] * n for _ in range(m)] # 방문 배열
    
    q = deque()
    visited[0][0] = 1
    q.append((0, 0, 1))
    
    dy = (0, 1, 0, -1)
    dx = (1, 0, -1, 0)

    while q:
        # 현재 좌표 & 거리
        y, x, d = q.popleft()
        
        if y == m-1 and x == n-1:
            return d
        
        for j in range(4):
            ny = y + dy[j]
            nx = x + dx[j]
            nd = d + 1
            
            # 유효한 좌표이고, 방문하지 않았고 벽이 아닌 경우
            if isValid(ny, nx) and not visited[ny][nx] and maps[ny][nx] == 1:
                visited[ny][nx] = 1
                q.append((ny, nx, nd))
   
    # 도착하지 못한 경우
    return -1

# 좌표의 유효성 검사
def isValid(y, x):
    global n, m # 전역변수 n, m
    return 0 <= x < n and 0 <= y < m
