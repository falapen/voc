#Benchmarking routine for OrderedDict by Mauro José Pappaterra

from collections import OrderedDict
import time

X = 10000 # number of Dictionaries to create
Y = 1000 # number of elements to populate the dictionaries with

dict_array = []

start = time.clock() # start clock
start_total =  start

# Create  X number of dictionaries
for i in range (X):
    dict = OrderedDict()
    dict_array.append(dict)

print("Created " + str(X) + " dictionaries in -> " + str(round((time.clock() - start),2))) # stop clock, print time

# Populate all X dictionaries with Y elements
start = time.clock() # start clock

for i in range (X):
    for e in range (Y):
        dict_array[i][e] = 'Hello'

print("Populated all " + str(X) + " dictionaries with " + str(Y) + " elements each in -> "  + str(round((time.clock() - start),2))) # stop clock, print time

# Update Y values in all X dictionaries
start = time.clock() # start clock

for i in range (X):
    for e in range (Y):
        dict_array[i][e] += ' World!'

print("Updated all " + str(Y) + " elements in " + str(X) + " dictionaries in -> "  + str(round((time.clock() - start),2))) # stop clock, print time

# Pop all Y elements in first half of X dictionaries (starting first)
start = time.clock() # start clock

for i in range (0,int(X/2)):
    for e in range (Y):
        dict_array[i].popitem(last=False)

print("Popped all " + str(Y) + " elements in first half (" + str(int(X/2)) + ") dictionaries starting from first element in -> "  + str(round((time.clock() - start),2))) # stop clock, print time

# Pop all Y elements in second half of X dictionaries (starting last)
start = time.clock() # start clock

for i in range (int(X/2), X):
    for e in range (Y):
        dict_array[i].popitem(last=True)

print("Popped all " + str(Y) + " elements in second half (" + str(int(X/2)) + ") dictionaries starting from last element in -> "  + str(round((time.clock() - start),2))) # stop clock, print time

print("Total Time - > "  + str(round((time.clock() - start_total),2))) # stop clock, print time )
