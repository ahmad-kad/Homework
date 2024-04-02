# Time Complexity Analysis for Matrix Multiplication

Below is the pseudocode to perform matrix multiplication, given two matrices A and B. 

    MATRIX_MULTIPLY(A, B): 
    if columns(A) ≠ rows(B):                                                
        raise ValueError("Matrix multiplication is not defined.") 

    rows_A ← number of rows in A                                            # O(1)
    cols_A ← number of columns in A                                         # O(1)
    cols_B ← number of columns in B                                         # O(1)
    result ← matrix of size rows_A x cols_B filled with zeros               # O(1)

    for i from 1 to rows_A do:                                              # O(n)
        for j from 1 to cols_B do:                                              # O(n)
        sum ← 0                                                                     # O(1)
            for k from 1 to cols_A do:                                              # O(n)     
                sum ← sum + A[i][k] * B[k][j]                                           # (1)
            result[i][j] ← sum return result                                        # O(1)

### Worst Case: O(n^3)
    1+1+1+1+n(n(1 + n (1))+ 1)
    4 + n (n^2 + 2n)
    4 + n^3 + n^2

    n^3 contains the highest degree therefore the worst case is O(n^3)

### Best Case: Omega(1) * if it exits early else Omega(n^3)

    best case is invalid matrix operation where the function exits before performing any calculation at *Omega(1)* however useful best case scenarios are limited to Omega(n^3) because matrix operations must iterate through all their elements to calculate the results. * atleast for this algorithm.

### Average Case: Theta(n^3)

    Average case will be Theta(n^3) because the best and worst case are Omega(n^3) (provided they give the actual result)