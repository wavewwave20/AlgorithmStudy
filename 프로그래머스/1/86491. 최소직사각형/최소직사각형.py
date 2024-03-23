def solution(sizes):
    answer = 0
    
    for i in sizes:
        if i[0] < i[1]:
            i[0], i[1] = i[1], i[0]
    
    return max([x[0] for x in sizes]) * max([x[1] for x in sizes])