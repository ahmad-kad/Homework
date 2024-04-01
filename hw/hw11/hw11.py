#!/usr/bin/env python
# coding: utf-8

# In[7]:


from queue import Queue


# In[8]:


def floodFill(image, sr, sc, color):
    #print(f" img: {image[sr][sc]} col: {color}")
    if image[sr][sc] == color:
        print("unchanged")
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


# In[9]:


def printMatrix(image):
    for row in image:
        print(row)


# ## Test Case

# In[10]:


image = [[1,1,1],
        [1,1,0],
        [1,0,1]]

# sr,sc = starting position, at (1,1) this indicates it'll start in the middle of the matrix and expand.
# Then pixels will be colored as long as they're adjacent to another pixel.

sr,sc,color=1,1,2
print("Original Matrix")
printMatrix(image)
flooded = floodFill(image,sr,sc,color)

print("\nFlooded Matrix")
printMatrix(flooded)


# In[11]:


image = [[0,1,2],
        [0,4,5],
        [0,7,8]]
# sr,sc = starting position, at (1,1) this indicates it'll start in the middle of the matrix and expand.
# Then pixels will be colored as long as they're adjacent to another pixel.

sr,sc,color=0,0,1
print("Original Matrix")
printMatrix(image)
flooded = floodFill(image,sr,sc,color)

print("\nFlooded Matrix")
printMatrix(flooded)


# In[12]:


image = [[0,0,0],
         [0,0,0]]
sr,sc,color = 0,0,1

print("Original Matrix")
printMatrix(image)
flooded = floodFill(image,sr,sc,color)

print("\nFlooded Matrix")
printMatrix(flooded)


# In[ ]:


get_ipython().system('jupyter nbconvert --to script hw11.ipynb')

