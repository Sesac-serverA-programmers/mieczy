# O(10^6) = O(n)
# O(n)
def solution(arr):
    answer = []
    answer.append(arr[0])

    for i in arr[1:]:
        if(i != answer[-1]):
            answer.append(i)
        continue
    
    return answer
