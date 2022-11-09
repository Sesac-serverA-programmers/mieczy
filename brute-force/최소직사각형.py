# 질문하기(1) 힌트 참고
def solution(sizes):
    width = []  # 가로 집합
    height = [] # 세로 집합
    
    for card in sizes:
        width.append(max(card[0], card[1]))
        height.append(min(card[0], card[1]))
    
    wallet = max(width) * max(height)
    
    return wallet
