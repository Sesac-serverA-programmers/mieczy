# 실패 코드
# N을 i번 사용하여 계산할 수 있는 결과는 i-1번의 결과를 사칙연산하는 것으로 구성되어 있음
# N은 최대 8까지 사용 가능
def solution(N, number):
    result = [[] for k in range(9)]

    # 값이 같은 경우
    if N == number:
        return 1
    
    for i in range(1, 9):
        result[i].append(int(str(N)*i))
        for j in result[i]:
            if i == 1 or i == 8:
                continue
            result[i+1].append(j + j)
            result[i+1].append(j - j)
            result[i+1].append(j * j)
            if (j != 0): # divide 0 금지
                result[i+1].append(j // j)
    
    for x in range(1,9):
        print(result[x])
        if number in result[x]:
            return x
        
    return -1


print(solution(5, 12))
