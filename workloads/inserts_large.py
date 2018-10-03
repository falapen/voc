"""
Inserts 10^7 tuples (int, int) into an OrderedDict and then pops one element and prints the runtime. 
"""
from collections import OrderedDict
import time
start = time.clock()
d = OrderedDict()
for a in range(10000000):
    d[a] = a
b = d.popitem()
print(time.clock()-start)