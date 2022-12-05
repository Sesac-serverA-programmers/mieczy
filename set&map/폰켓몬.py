### O(N)
def solution(nums):
    
    # 중복을 제거하기 위해 집합을 사용
    p_list = set(nums)
    length = len(nums) // 2
    count = 0
    
    for p in p_list:
        # 종류가 더 많은 경우, 최대값은 가져갈 수 있는 폰켓몬 수
        if (count >= length):
            return length
        count  += 1

    return count
