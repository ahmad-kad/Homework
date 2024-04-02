# Time Complexity Analysis Insertion Sort

    We have discussed insertion sort as an algorithm. Now that we know how to analyze algorithms, let's apply the same analysis to Insertion Sort!

    You may refer to class slides/ online resources to refresh your memory on the insertion sort algorithm. 

 
### Psuedocode for insertion sort:

    insertionSort(array):
        for i in len(array):                                # O(n)

            current = array[i]                                  # O(1)
            sublist = i-1  --- where the refer                  # O(1)

            while sublist >= 0 and current < arr[sublist] :     # O(n)

                arr[sublist + 1] = arr[sublist]                     # O(1)
                sublist -= 1                                        # O(1)

            arr[sublist + 1] = current                           # O(1)




#### Worst Case: O(n^2)
        O(n) * O(n) = O(n^2)
##### Equation

        n(1+1+n(1+1)+1)
        n(3+2n)
        2n^2 + 3n
    
        2n^2 is the highest polynomial therefore worst case is o(n^2) disregard the scalar value (2)


#### Best Case: Omega(n)
        if the array is already sorted meaning the algorithm traversal through the array **once** 
#### Average Case:  Theta(n^2)
        Average case must lie between Theta(n) and Theta(n^2). Therefore must average case must be Theta(n^2) because we will take the highest degree in (the equaltion n^2 + n )/ 2 referring to the average case.
