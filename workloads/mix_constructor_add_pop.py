"""
Creates 22000 OrderedDicts. Add 100 elements, removes 50 elements does 50 move to end operations on each dict.
"""

from collections import OrderedDict
import random
import time
start = time.clock()

dictArray = []

for i in range (22000):
    dict = OrderedDict()
    dictArray.append(dict)

for d in range(len(dictArray)):
    dict = dictArray[d]

    for i in range(100):
        dict[i] = i
    for i in range(50):
        dict.pop(i)  
    for a in range(51, 100):
        dict.move_to_end(a)

print(time.clock()-start)