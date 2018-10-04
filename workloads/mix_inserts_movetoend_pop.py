"""
Does 10^7 operations, 1/10th of which pops, 1/10th of which move_to_end and the rest inserts. 
"""
from collections import OrderedDict
import random
import time
start = time.clock()
d = OrderedDict()
for a in range(10000000):
    if a%10 == 4: 
        d.popitem()
    elif a%10 == 8:
        rand_key = random.randrange(a)
        while rand_key not in d: 
            rand_key = random.randrange(a)
        d.move_to_end(rand_key)
    else: 
        d[a] = a
print(time.clock()-start)