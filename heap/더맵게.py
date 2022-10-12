### O(NlogN)

import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville) # 최소힙
    
    while (scoville[0] < K):
        # 스코빌 지수를 K 이상으로 만들 수 없는 경우
        if (len(scoville) == 1):
            return -1
        mixed = heapq.heappop(scoville) + heapq.heappop(scoville) * 2
        answer += 1
        heapq.heappush(scoville, mixed)
    
    return answer
