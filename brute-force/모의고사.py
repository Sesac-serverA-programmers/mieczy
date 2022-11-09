def solution(answers):
    # 각 수포자가 문제를 찍는 패턴
    man1 = [1,2,3,4,5]
    man2 = [2,1,2,3,2,4,2,5]
    man3 = [3,3,1,1,2,2,4,4,5,5]
    score = [0,0,0]
    
    #패턴 개수 단위로 정답과 비교
    for i in range(len(answers)):
        if (answers[i] == man1[i%5]):
            score[0] += 1
        if (answers[i] == man2[i%8]):
            score[1] += 1
        if (answers[i] == man3[i%10]):
            score[2] += 1
    
    # 1등 점수
    winner = max(score)
    answer = []
    
    # 가장 높은 점수를 받은 사람 정렬
    for i in range(3):
        if(winner == score[i]):
            answer.append(i+1)
    
    return answer
