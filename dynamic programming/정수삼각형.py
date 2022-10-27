### 첫번째 에러: 이중 리스트 초기화를 잘못함 arr = [0]*n*n
### 두번째 에러: print를 지우지 않음
### 세번째 에러: 가장 오른쪽 합을 고려하지 않아 list index error 발생


def solution(triangle):
    depth = len(triangle)
    arr = [[0]*depth for k in range(depth)]
    
    # 가장 꼭대기 값
    arr[0][0] = triangle[0][0]

    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            # 가장 왼쪽의 합은 항상 위의 값 + 현재 값
            if j == 0:
                arr[i][j] = arr[i-1][j] + triangle[i][j]
            # 가장 오른쪽의 합은 항상 위의 값 이전의 값 +  현재 값
            elif j == len(triangle)-1:
                arr[i][j] = arr[i-1][j-1] + triangle[i][j]
            # 위로 대각선 방향 한 칸 오른쪽 또는 왼쪽 중 max + 현재 값
            else:
                arr[i][j] = max(arr[i-1][j], arr[i-1][j-1]) + triangle[i][j]
    
    return max(arr[-1])
                       
    
