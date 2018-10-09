from collections import OrderedDict
import time
import random

start = time.clock()
ordered_dict = OrderedDict()

for i in range(50000):
    ordered_dict[i] = i

for i in range(50000):
    ordered_dict.popitem(False)

print(time.clock()-start)
