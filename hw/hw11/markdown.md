## how to floodfill

- get position
- set position to target value
- add neighbors to queue
- repeat ... profit

floodfill(image, sr,sc,color):
    if image[sr][sc] == color:
        return image
    
    originalColor = image[sr][sc]
    
    queue = Queue()
    queue.put((sr, sc))
    
    while not queue.empty():
        currentPixel = queue.get()

        # loc pixel
        x, y = currentPixel

        # ignore out of bounds x,y, or if different from original color
        if x < 0 or x >= len(image) or y < 0 or y >= len(image[0]) or image[x][y] != originalColor:
            continue
                
        # sets new color
        image[x][y] = color
        
        # adds adjacent pixels to queue
        queue.put((x + 1, y))
        queue.put((x - 1, y))
        queue.put((x, y + 1))
        queue.put((x, y - 1)) 
        
    
    return image