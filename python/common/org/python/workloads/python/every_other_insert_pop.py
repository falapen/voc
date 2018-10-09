"""
Preforms 10^7 operations, every other an insert, every other a pop (int, int).
"""
from collections import OrderedDict
import time
start = time.clock()
d = OrderedDict()
for k in range(150):
    for a in range(10000):
        d.update({a: a})
    for a in range(10000):
        d.popitem()
print(time.clock()-start)