from collections import OrderedDict
import time
start = time.clock()
d = OrderedDict()
for a in range(10000000):
    d[a] = a
print(d.popitem())
print(time.clock()-start)