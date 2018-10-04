from collections import OrderedDict
import time
import random
start = time.clock()
orderedDict = OrderedDict()

names = ["Harry","Ross","Bruce","Cook","Carolyn",
         "Morgan","Albert","Walker","Randy","Reed",
         "Larry","Barnes","Lois","Wilson","Jesse",
         "Campbell","Ernest","Rogers","Theresa",
         "Patterson","Henry","Simmons","Michelle",
         "Perry","Frank","Butler"]

for i in range(500000):
    name = names[random.randint(0,25)]
    score = orderedDict.get(name)
    if (score == None):
        orderedDict[name] = 1
    else:
        orderedDict[name] = score + 1

multiply = 10
for k, v in orderedDict.items():
    orderedDict[k] = v * multiply
    if(multiply > 1):
        multiply = multiply - 1

print(orderedDict)
orderedDict.clear()
print(orderedDict)
print(time.clock()-start)
