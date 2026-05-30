We will make a min-heap that stores int values. 
We will use ArrayList<Integer>
private List<Integer> values; (store the numbers in the heap)
public void add(int value) (adds a new int to the heap)
public int pop() (removes and returns the smallest value in the heap)
public int peek() (returns the smallest without removing)
public int size() (returns how many values are in the heap)
public boolean isEmpty() (returns true if the heap is empty)

private helper methods
private void moveUp(int index)
-moves a value up until you reach the right place
private void moveDown(int index)
-moves the value down until you reach the right place
private int parentIndex(int index)
-gets the parent index of a value
private int leftChildIndex(int index)
-gets the left child index
private int rightChildIndex(int index)
-gets the right child index
