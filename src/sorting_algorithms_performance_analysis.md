## Algorithm Performance Analysis

### Sorting Algorithms Runtimes

| Data Type              | Bubble Sort Runtime (ms) | Selection Sort Runtime (ms) | Insertion Sort Runtime (ms) |
| ---------------------- | ------------------------ | --------------------------- | --------------------------- |
| Randomly Shuffled Data | 17                       | 7                           | 6                           |
| Sorted Data            | 12                       | 8                           | 0.97                        |
| Reverse Sorted Data    | 18                       | 7                           | 8                           |

### Explanation and Analysis:

1. **Randomly Shuffled Data:**
   - **Bubble Sort:** 17 ms
   - **Selection Sort:** 7 ms
   - **Insertion Sort:** 6 ms
   - The randomly shuffled data represents a scenario where the input elements are in no particular order. The results show that Bubble Sort has the highest runtime, followed by Selection Sort, and then Insertion Sort. This aligns with the expected time complexities for these algorithms. Bubble Sort has a worst-case time complexity of O($n^2$), making it less efficient for random data.

2. **Sorted Data:**
   - **Bubble Sort:** 12 ms
   - **Selection Sort:** 8 ms
   - **Insertion Sort:** 0.97 ms
   - With already sorted data, Insertion Sort performs significantly better than the other two algorithms. This is expected since Insertion Sort has a best-case time complexity of O(n) for already sorted data. Selection Sort and Bubble Sort have similar runtimes, and both exhibit O($n^2$) behavior in the worst case, making them less efficient for sorted data.

3. **Reverse Sorted Data:**
   - **Bubble Sort:** 18 ms
   - **Selection Sort:** 7 ms
   - **Insertion Sort:** 8 ms
   - Reverse sorted data is challenging for algorithms with quadratic time complexities. Bubble Sort and Insertion Sort show high runtimes, especially for Bubble Sort, which has a worst-case time complexity of O($n^2$). Selection Sort performs comparatively better than the other two but still exhibits O($n^2$) behavior in the worst case.

### Time Complexity Analysis:

#### Bubble Sort:

- **Best Case (O(n)):**
  - The best-case scenario occurs when the input array is already sorted. Bubble Sort makes only one pass through the array, confirming that no swaps are needed.

- **Worst Case (O($n^2$)):**
  - The worst-case scenario happens when the input array is in reverse order. Bubble Sort compares and swaps elements until the array is sorted.

- **Average Case (O($n^2$)):**
  - On average, Bubble Sort has a quadratic time complexity. It involves comparing and swapping elements throughout the entire array, resulting in O($n^2$) time complexity.

#### Selection Sort:

- **Best Case (O($n^2$)):**
  - The best-case scenario is still O($n^2$). It occurs when the input array is in ascending order, but the algorithm still performs the same number of comparisons and swaps.

- **Worst Case (O($n^2$)):**
  - The worst-case scenario happens when the input array is in reverse order. Selection Sort consistently makes the same number of comparisons and swaps, leading to O($n^2$) time complexity.

- **Average Case (O($n^2$)):**
  - The average-case time complexity for Selection Sort is O($n^2$). It involves a fixed number of comparisons and swaps for each element, resulting in quadratic complexity.

#### Insertion Sort:

- **Best Case (O(n)):**
  - The best-case scenario occurs when the input array is already sorted. Insertion Sort makes one pass through the array, requiring only O(n) time complexity.

- **Worst Case (O($n^2$)):**
  - The worst-case scenario happens when the input array is in reverse order. For each element, Insertion Sort compares and shifts elements, resulting in a quadratic number of comparisons and shifts.

- **Average Case (O($n^2$)):**
  - On average, Insertion Sort has a quadratic time complexity. It involves a fixed number of comparisons and shifts for each element, leading to O($n^2$) time complexity.

### O(n) - Linear Time Complexity:

**Definition:** An algorithm is said to have linear time complexity (O(n)) if the running time of the algorithm grows proportionally with the size of the input.

**Example:** Suppose you have an algorithm that iterates through each element in a list exactly once. The running time of this algorithm would be linear with respect to the size of the list.

**Calculation:** If the algorithm takes 'c' units of time for each element in the input, then the total running time would be approximately c * n, where 'n' is the size of the input.

### O(n^2) - Quadratic Time Complexity:

**Definition:** An algorithm is said to have quadratic time complexity (O(n^2)) if the running time of the algorithm grows with the square of the size of the input.

**Example:** Suppose you have a nested loop where, for each element in the input, you iterate through the entire input again. The running time of such an algorithm would be quadratic.

**Calculation:** If the algorithm takes 'c' units of time for each pair of elements in the input, then the total running time would be approximately c * n^2.

### How to Calculate:

1. **Identify the Dominant Term:**
   - Look for the term that contributes the most to the running time as the input size grows.

2. **Eliminate Constants:**
   - Drop the constants and lower-order terms. Focus on the term that has the most significant impact.

3. **Express in Big O Notation:**
   - Write the complexity using Big O notation, focusing on the dominant term.


