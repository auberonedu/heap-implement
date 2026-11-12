# Heap Implementation Plan (`plan.md`)

## Setup
* Implement methods incrementally in `Heap.java` alongside unit tests in `HeapTest.java`.
* Complete the missing interactive logic in `HeapRunner.java`.
* Create a branch named `ai_review` before getting AI feedback.
* Submit two PRs (one from `main`, one from `ai_review`)

---

## 2. Backing Data & Indexing
* **Backing Structure:** `private List<Integer> data;` (backed by an `ArrayList<Integer>`).
* **Navigation Formulas** (for node at index `i`):
  * Left Child: `2 * i + 1`
  * Right Child: `2 * i + 2`
  * Parent: `(i - 1) / 2`

---

## 3. Core Methods
* **`insert(int value)`**: Adds the value to the end of the list and puts it on ($O(\log n)$).
* **`pop()`**: Removes and returns the minimum element at index 0, swaps the last element to the root, and moves down ($O(\log n)$).
* **`peek()`**: Returns the minimum element at index 0 without removing it ($O(1)$).
* **`size()`**: Returns the number of elements in the heap ($O(1)$).
* **`isEmpty()`**: Returns `true` if the heap has no elements ($O(1)$).

---

## 4. Helper Methods & Error Handling
* **Private Helpers:** 
  * `percolateUp(int index)` for restoring order upwards.
  * `percolateDown(int index)` for restoring order downwards.
  * `swap(int i, int j)` for swapping list elements.
* **Empty Heap Handling:** Throw an `IllegalStateException` with a clear message if `pop()` or `peek()` is called on an empty heap.