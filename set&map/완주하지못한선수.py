### 항상 1명의 미완주자 반환
### O(N)
def solution(participant, completion):
    men = dict()
    answer = ''

    # 완주자를 (이름:인원)으로 저장
    for name in completion:
        if name in men:
            men[name] += 1
        else:
            men[name] = 1
            
    # 완주자 명단에 참가자가 있는지 확인
    for name in participant:
        if not(men.get(name)) or men[name] == 0:
            return name
        else:
            men[name] -= 1
