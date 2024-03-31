#!/usr/bin/env python
# coding: utf-8

# # Time to solve another problem together! Here's the problem statement:
# 
# Given two strings s and t, return true if t is an anagram of s, and false otherwise.
# 
# An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

# In[36]:


def createHashMap(input):
    hashmap = {}
    for x in input:
        hashmap[x] = hashmap.get(x, 0) + 1
    return hashmap

def anagram(s,t):
    return False if len(s) != len(t) or  createHashMap(s) != createHashMap(t) else True


# In[37]:


s,t = "doga" , "goad"
anagram(s,t)


# In[38]:


test_cases = [
    ("listen", "silent"),
    ("hello", "hello"),
    ("earth", "hearted"),
    ("Tea", "eAt"),
    ("debit card", "bad credit"),
    ("astronomer", "moon starer"),
    ("Café", "éaFc"),
    ("", ""),
    ("a", "a"),
    ("hello", "world")
]

GREEN = '\033[92m'
RED = '\033[91m'
RESET = '\033[0m'

for idx, (str1, str2) in enumerate(test_cases, start=1):
    result = 'True' if anagram(str1, str2) else 'False'
    color = GREEN if result == 'True' else RED
    print(f"Test Case {idx}: {color}{result}{RESET} : '{str1}' and '{str2}' ")


# In[39]:


get_ipython().system('jupyter nbconvert --to script lab02.ipynb')

