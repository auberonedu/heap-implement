import java.util.ArrayList;

/**
 * A min-heap.
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap O(log(n))
 * Popping the front of the heap O(log(n))
 * Peeking at the front of the heap without removing the element O(1)
 * Getting the size of the heap O(1)
 * Checking whether the heap is empty O(1)
 * 
 * 
 * The Heap must hold ints
 * 
 * Use List/ArrayList as a backing array, but DO NOT use the
 * PriorityQueue class. Do not make Node objects, use array
 * indexing instead.
 * 
 * It is up to you to make design decisions about how to:
 * - name methods
 * - determine return value and argument types
 * - hold private instance variables
 */
public class Heap {

 private ArrayList<Integer> items = new ArrayList<>();
 private int size;

 public int size() {
  return size;
 }

 public boolean isEmpty() {
  return size == 0;
 }

 private int getLeftChildIndex(int parentIndex) {
  return 2 * parentIndex + 1;
 }

 private int getRightChildIndex(int parentIndex) {
  return 2 * parentIndex + 2;
 }

 private int getParentIndex(int childIndex) {
  return (childIndex - 1) / 2;
 }

 private boolean hasLeftChild(int index) {
  return getLeftChildIndex(index) < size;
 }

 private boolean hasRightChild(int index) {
  return getRightChildIndex(index) < size;
 }

 private boolean hasParent(int index) {
  return index > 0;
 }

 private int leftChild(int index) {
  return items.get(getLeftChildIndex(index));
 }

 private int rightChild(int index) {
  return items.get(getRightChildIndex(index));
 }

 private int parent(int index) {
  return items.get(getParentIndex(index));
 }

 private void swap(int indexOne, int indexTwo) {
  int temp = items.get(indexOne);
  items.set(indexOne, items.get(indexTwo));
  items.set(indexTwo, temp);
 }

 public int peek() {
  if (size == 0)
   throw new IllegalStateException();
  return items.get(0);

 }

 public int pop() {
  if (size == 0)
   throw new IllegalStateException();

  int item = items.get(0);

  items.set(0, items.get(size - 1));

  items.remove(size - 1);

  size--;

  heapifyDown();

  return item;
 }

 public void add(int item) {
  items.add(item);
  size++;
  heapifyUp();
 }

 public void heapifyUp() {
  int index = size - 1;

  while (hasParent(index) && parent(index) > items.get(index)) {

   swap(getParentIndex(index), index);

   index = getParentIndex(index);
  }
 }

 private void heapifyDown() {
  int index = 0;

  while (hasLeftChild(index)) {
   int smallerChildIndex = getLeftChildIndex(index);

   if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
    smallerChildIndex = getRightChildIndex(index);
   }

   if (items.get(index) <= items.get(smallerChildIndex)) {
    break;
   }

   swap(index, smallerChildIndex);
   index = smallerChildIndex;
  }
 }

}