from collections import OrderedDict
import time
import random

od_keys = list()
od_list = list()
start = time.clock()
ordered_dict = OrderedDict()

for i in range(2500):
    ordered_dict[i] = i

for i in range(2500):
    od_keys.append(ordered_dict.keys())

for i in range(2500):
    od_list.append(OrderedDict.fromkeys(od_keys[i]))

print(time.clock()-start)
