"""
Preforms 10^7 operations, every other an insert, every other a pop (int, int).
"""
from collections import OrderedDict
import time
start = time.clock()
d = OrderedDict()
for a in range(3000000):
    if a%2 == 0: d.update({a: a})
    if a%2 == 1: d.popitem()
print(time.clock()-start)