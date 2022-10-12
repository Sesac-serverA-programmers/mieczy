### O(N)
def solution(s):
    answer = True
    stack = []
    
    for ch in s:
        if (ch == '('):
            stack.append(ch)
        else:
            if stack:
                stack.pop()
            else:
                return False
    if stack:
        return False
    
    return True
