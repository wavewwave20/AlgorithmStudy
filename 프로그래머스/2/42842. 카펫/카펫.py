def solution(brown, yellow):
    answer = []
    
    width = 3
    height = 3
    
    while True:
        while height <= width:
            if yellow == (width-2) * (height-2) and width*height == brown + yellow:
                return [width, height]
            height +=1
        height = 3
        width += 1