from itertools import combinations, permutations
import math
def solution(numbers):
    answer = 0
    
    numSet = set()

    for i in range(len(numbers)):
        for j in list(permutations(numbers, i+1)):
            num = ""
            for k in j:
                num+=k
            numSet.add(int(num))
    
    for i in numSet:
        if is_prime_number(i):
            answer +=1
    print(numSet)
    return answer

def is_prime_number(x):
    if x <= 1:
        return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True