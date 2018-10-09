from collections import OrderedDict
import time
import random
start = time.clock()
orderedDict = OrderedDict()
counter = 0
names = ["Harry","Ross","Bruce","Cook","Carolyn",
         "Morgan","Albert","Walker","Randy","Reed",
         "Larry","Barnes","Lois","Wilson","Jesse",
         "Campbell","Ernest","Rogers","Theresa",
         "Patterson","Henry","Simmons","Michelle",
         "Perry","Frank","Butler"]

for i in range(10000):
    name = names[random.randint(0,25)]
    score = orderedDict.get(name)
    if (score == None):
        orderedDict.update({name: 1})
    else:
        orderedDict.update({name: 1+score})

dicts = []
for i in range(10000):
    dicts.append(orderedDict.copy())

for i in range(10):
    for d in dicts:
        multiply = 10
        for k, v in d.items():
            orderedDict.update({k: v * multiply})
            counter = counter + 1
            if(multiply > 1):
                multiply = multiply - 1
            else:
                break

        if (random.randint(0,1)%2 == 0):
            d.popitem(True)
        else:
            d.popitem(False)

for d in dicts:
    d.clear()

print(time.clock()-start)
print(counter)
