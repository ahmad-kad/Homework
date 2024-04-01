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


    levelOrder(root: Optional[TreeNode]) -> List[List[int]]:

        if root is None:

            return None
        
        result = []

        queue = [root]
        
        while queue is not empty:

            levelvalues = []

            levelsize = size of queue

            iterate 'level_size' times:

                dequeue a node from the queue.

                append it to levelvalues
                
                add left and right to queue if present
            
            result.append(levelvalues)
        
    reutrn result
