def solution(n, lost, reserve):
    # 정렬
    lost.sort()
    reserve.sort()

    # 여벌체육복을 도난당한 경우, 제외시킴
    lost_reserve_n = set(lost) & set(reserve)
    if (len(lost_reserve_n) > 0):
        for i in lost_reserve_n:
            lost.remove(i)
            reserve.remove(i)
    
    for i in lost:
        front = i-1
        back = i+1
        if (front in reserve):  # 앞 번호에게 빌림
            reserve.remove(front)
        elif (back in reserve): # 뒷 번호에게 빌림
            reserve.remove(back)
        else:                   # 못 빌리는 경우
            n -= 1

    return n
