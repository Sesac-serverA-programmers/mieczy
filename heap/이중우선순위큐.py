### O(N^2)

import heapq

def solution(operations):
    max_heap = []
    min_heap = []
    
    for operation in operations:
        op, data = operation.split()
        
        if (op == 'I'):
            heapq.heappush(max_heap, -int(data))
            heapq.heappush(min_heap, int(data))    
        else:
            if (not max_heap):    # 빈 큐에서 삭제는 무시
                continue
            elif (data == '-1'):
                min_value = heapq.heappop(min_heap)
                max_heap.remove(-min_value)
            else:
                max_value = heapq.heappop(max_heap)
                min_heap.remove(-max_value)

    if (not max_heap):
        return [0,0]
    else:
        return[-heapq.heappop(max_heap),heapq.heappop(min_heap)]
    
    return answer
