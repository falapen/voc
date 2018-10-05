"""
 creates a new ordered dict object 3*10^5 times, and runds update 3 times and pop one time for each iteration.
"""

from collections import OrderedDict
import collections
import time
start = time.clock()

for i in range(1, 600000):
    dict = OrderedDict()
    dict.update({'a': 1})
    dict.update({'b': 2})
    dict.update({'c': 3})
    dict.popitem()

print(time.clock()-start)