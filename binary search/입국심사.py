def solution(n, times):
    l = 0
    r = max(times) * n       # 최대 걸리는 시간
    
    while (l<=r):
        m = (r+l) // 2       # 중간 시간
        people = 0
        
        # m 시간동안 심사받을 수 있는 사람 수
        for t in times:
            people += m // t
        
        # n명보다 작으면 l 이동
        if (people < n):
            l = m + 1
        # n명보다 크면 r 감소
        elif (people >= n):
            answer = m
            r = m - 1
        
    return answer
