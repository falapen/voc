"""
	10^6 inserts followed by 10^6 pops. 
"""

from collections import OrderedDict
import time

max_len = 1000000																																																																																															
d = OrderedDict()
a = OrderedDict()

start = time.clock()

for i in range(max_len):
	d[i] = i

for j in range(max_len):
	a[j+max_len] = j
print(time.clock()-start)

start2 = time.clock()
d.update(a)
print(time.clock()-start2)
															