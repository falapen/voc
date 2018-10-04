"""
Inserts 650000 random numbers between 0 and 100 in an OrderedDict
"""
from collections import OrderedDict
import time
import random
start = time.clock()
orderedDict = OrderedDict()
for i in range(650000):
    orderedDict[i] = random.randint(0,100)
print(time.clock()-start)
