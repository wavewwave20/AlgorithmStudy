from itertools import permutations
def solution(k, dungeons):
    answer = -1

    dungeonIndexes = [i for i in range(len(dungeons))]

    com = permutations(dungeonIndexes, len(dungeonIndexes))


    for i in com:
        hp = k
        count = 0
        for j in i:
            if hp < dungeons[j][0]:
                break
            else:
                hp -= dungeons[j][1]
                count += 1
        
        if count > answer:
            answer = count


    return answer