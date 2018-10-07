"""
Creates a main dictionary with 'E' number of elements
Creates 'D' number of copies of the main dictionary
Pops each element in all dictionaries
Pops either first or last element by chance
"""
from collections import OrderedDict
import time
import random


E = 100 # Number of elements to create in dictionary
D = 1000 # Number of dictionaries to create and pop

start = time.clock()
main_dict = OrderedDict()

for i in range(E): #Populate main dictionary
    main_dict[i] = i

for j in range(D):
    temp_dict = main_dict.copy() #Create new copy of main dictionary

    for k in range(temp_dict.__len__()): #Pop all items in temp dictionary by chance
        rnd = random.randint(0, 1)
        if rnd == 0:
            temp_dict.popitem(last=False)
        else:
            temp_dict.popitem(last=True)

    temp_dict.clear()

main_dict.clear()

print(time.clock()-start)



