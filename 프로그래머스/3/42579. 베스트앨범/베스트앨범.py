def solution(genres, plays):
    answer = []

    dic = {}
    dic2 = {}


    for i, genresName in enumerate(genres):
        
        if genresName not in dic.keys():
            dic[genresName] = [(i,plays[i])]
            dic2[genresName] = plays[i]
        else:
            dic[genresName].append((i,plays[i]))
            dic2[genresName] += plays[i]

    for i in dic.keys():
        dic[i].sort(key = lambda x : -x[1])

    for i in sorted(dic2.items(), key= lambda x : -x[1]):
        answer.append(dic[i[0]][0][0])

        if len(dic[i[0]]) > 1:
            answer.append(dic[i[0]][1][0])
    return answer