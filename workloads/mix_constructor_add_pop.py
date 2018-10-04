#
#Benchmarking routing for OrderedDict
#
from collections import OrderedDict
import time

X = 100000 # number of Dictionaries to create
Y = 10000 # number of elements to populate the dictionaries with

dictionary_array = []

# Create X dictionaries
start = time.clock() # start clock

for i in range (X):
    new_dictionary = OrderedDict()
    dictionary_array.append(new_dictionary)

print("Created " + str(X) + " dictionaries in -> " + str((time.clock() - start))) # stop clock, print time

# Populate all X dictionaries with Y elements each
start = time.clock() # start clock

for dictionary in dictionary_array:
    for index, element in enumerate(dictionary):
        dictionary[index] = index

print("Populated all " + str(X) + " dictionaries with " + str(Y) + " elements each in -> "  + str((time.clock() - start))) # stop clock, print time

# Updated all Y elements on each dictionary
start = time.clock() # start clock

for dictionary in dictionary_array:
    for element in dictionary:
        element = element * 2

print("Updated all " + str(Y) + " elements in " + str(X) + " dictionaries in -> "  + str((time.clock() - start))) # stop clock, print time

# Pop all Y elements on each dictionary
start = time.clock() # start clock

for dictionary in dictionary_array:
    for index, element in enumerate(dictionary):
        dictionary.popitem()

print("Popped all " + str(Y) + " elements in " + str(X) + " dictionaries in -> "  + str((time.clock() - start))) # stop clock, print time
