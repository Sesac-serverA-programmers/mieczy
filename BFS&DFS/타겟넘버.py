def solution(numbers, target):
    # count를 위해 전역변수 선언
    global count
    count = 0

    dfs(numbers, target, 0, 0)
    return count
    
def dfs(arr, target, node, total): 
    # count를 위해 전역변수 선언
    global count
    
    # 마지막 노드일 경우, return
    if node == len(arr):
        # 합이 타겟넘버인 경우, count 증가
        if total == target:
            count += 1
        return
    
    dfs(arr, target, node+1, total + arr[node]) # + 원소의 값
    dfs(arr, target, node+1, total - arr[node]) # - 원소의 값
