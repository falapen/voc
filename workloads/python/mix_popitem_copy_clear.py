"""
Created one that with a loop with 1.5* 10^6 iterations. The algoritm do an insert every iteration and do a pop every 5th iteration, copy every 10th iteration and a clear every 15th iteration.
"""

from collections import OrderedDict
import time
start = time.clock()
dict = OrderedDict()

for i in range(1, 1500000):
   dict[i] = i 
   if i % 5 == 0:
       dict.popitem() 
   if i % 10 == 0:
       dict.copy()
   if i % 15 == 0:
       dict.clear()
print(time.clock()-start)