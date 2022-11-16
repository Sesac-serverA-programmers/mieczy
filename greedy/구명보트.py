### https://velog.io/@ajufresh/프로그래머스-구명보트-문제풀이-java
def solution(people, limit):
    answer = 0
    i = 0
    
    # 정렬
    people.sort()
    
    minIdx = 0;
    maxIdx = len(people) - 1
    weight = 0
    while (minIdx <= maxIdx):
        weight = people[minIdx] + people[maxIdx]
        if (weight <= limit):
            answer += 1
            minIdx += 1
            maxIdx -= 1
        else:
            answer += 1
            maxIdx -= 1
    
    return answer
