def solution(phone_book):
    dictionary = dict()
    
    # 번호를 key로 삽입
    for num in phone_book:
        dictionary[num] = 1
        
    # 모든 번호를 한 글자씩 늘려가며 비교
    for num in phone_book:
        for i in range(1, len(num)):
            test = num[:i]
            if test in dictionary and test != num:
                return False
    
    return True
