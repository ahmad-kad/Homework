## Steps


#### LevelOrder
- return null/none if empty list
- initialize final **list** and **queue**
- while queue contains an element create a list that contains values and current lengh of the queue
- - - the current length of the queue is how many elements are in that level
- - add element to list of values
- - add left and right nodes to queue
- append value final list

#### LevelOrder2
- same concept as above but creates a new queue list and reassigns queue to that list before it exits the while loop