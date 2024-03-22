def solution(answers):
    answer = []
    score = [0,0,0]
    
    one = '12345'
    two = '21232425'
    three = '3311224455'
    
    count = 0
    
    for ex in answers:
        if ex == int(one[count % len(one)]):
            score[0] +=1
        count += 1
    

    count = 0
    for ex in answers:
        if ex == int(two[count % len(two)]):
            score[1] +=1
        count += 1
    

    count = 0
    for ex in answers:
        if ex == int(three[count % len(three)]):
            score[2] +=1
        count += 1
    
    
    for i in range(3):
        if max(score) == score[i]:
            answer.append(i+1)
    
    return answer