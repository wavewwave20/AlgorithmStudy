from itertools import product
def solution(word):
    dic = ['A', 'E', 'I', 'O', 'U']
    arr = []

    for i in range(1,6,1):
        for c in product(['A', 'E', 'I', 'O', 'U'], repeat=i):
            arr.append(''.join(list(c)))

    arr.sort()
    return arr.index(word)+1
