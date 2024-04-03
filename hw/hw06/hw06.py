#!/usr/bin/env python
# coding: utf-8

# In[238]:


from typing import List

def threeSum( nums: List[int]) -> List[List[int]]:
    fullList = []
    setList = []
    nums.sort()
    print(nums)
    for x in range(len(nums)-2):
       #print(x)
        for y in range(x+1,len(nums)):
            #print(y)
            for z in range(y+1,len(nums)):
                #print(z)
                #print(f"{nums[x]}:{nums[y]}:{nums[z]}")
                combo = {nums[x],nums[y],nums[z]}
                if nums[x] + nums[y] + nums[z] == 0 and combo not in setList:
                    setList.append(combo)
                    fullList.append([nums[x],nums[y],nums[z]])
    return fullList
        


# In[239]:


from typing import List

def threeSum( nums: List[int]) -> List[List[int]]:
    fullList = []
    nums.sort()
    
    for i in range(len(nums)-2):
       if i > 0 and nums[i] == nums[i - 1]:
            continue
       left,right = i + 1, len(nums)-1 
       while left < right:
            total = nums[i] + nums[left] + nums[right]
            if total < 0:
               left+=1
            elif total >0:
               right-=1
            else:
                fullList.append([nums[i],nums[left],nums[right]])
                left +=1
                right -=1
                while left < right and nums[left] == nums[left - 1]:
                    left += 1
                while left < right and nums[right] == nums[right + 1]:
                    right -= 1

    return fullList
        


# In[240]:


nums = [0,1,1]
threeSum(nums)


# In[241]:


nums = [-5,0,5,10,-10,0] 
threeSum(nums)


# 
# def threeSum(self, nums: List[int]) -> List[List[int]]:
# 
#   #Your code here
# 
# Announced Test Cases:
# 
# Input: nums = [0,1,1]
# Output: []
# Explanation: The only possible triplet does not sum up to 0.
# 
# Input: nums = [-5,0,5,10,-10,0] 
# Output: [[-10,0,10],[-5,0,5]] 
# Explanation: There are two possible combinations of triplets that satisfy: (-5,0,5) and (-10,0,10).
# 
# Hint: There are 3 well-known ways to solve this problem!
# 
# Hint 2: This problem should remind you of another homework problem that you hopefully have already solved. 
# 
# Hint 3: This problem might benefit from the algorithms we have recently discussed in class!

# In[ ]:


get_ipython().system('jupyter nbconvert --to script hw06.ipynb')

