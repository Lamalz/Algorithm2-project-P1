package GraphFramework;

import PhoneNetworkApp.Office;

public class minHeap {
    //the max value of the heap size
    int size;

    // heap current size
    int currentSize;

    //array contains the values of the min heap
    heapNode[] minHeapArray;

    //array that will be used to decrease the key
    int[] indexes;

    /**
     * Constructor with specific size value of the heap
     *
     * @param size = the max value
     */
    public minHeap(int size) {
        this.size = size;
        minHeapArray = new heapNode[size + 1];
        indexes = new int[size];
        minHeapArray[0] = new heapNode(new Office(), Integer.MIN_VALUE);
        minHeapArray[0].vertex.lable = Integer.toString(-1);
        currentSize = 0;
    }

    /**
     * This method will prints min heap values
     */
    public void display() {
        for (int i = 0; i <= currentSize; i++) {
            System.out.println(" " + minHeapArray[i].vertex + "   key   " + minHeapArray[i].key);
        }
        System.out.println("________________________");
    }

    /**
     * This method to add nodes to the min heap
     *
     * @param node
     */
    public void insert(heapNode node) {
        currentSize++;
        int Index = currentSize;
        minHeapArray[Index] = node;
        indexes[Integer.parseInt(node.vertex.lable)] = Index;
        bubbleUp(Index);
    }

    /**
     * This method will moves the last value added to the correct position in
     * the heap
     *
     * @param Number = current index
     */
    public void bubbleUp(int num) {
        int parentIndex = num / 2;
        int currentIndex = num;
        while (currentIndex > 0 && minHeapArray[parentIndex].key > minHeapArray[currentIndex].key) {
            heapNode currentNode = minHeapArray[currentIndex];
            heapNode parentNode = minHeapArray[parentIndex];

            //swap the positions
            indexes[Integer.parseInt(currentNode.vertex.lable)] = parentIndex;
            indexes[Integer.parseInt(parentNode.vertex.lable)] = currentIndex;
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
    }

    /**
     * Update the indexes[] array and move the last node to the top and remove
     * it
     *
     * @return min heapNode
     */
    public heapNode extractMin() {
        heapNode min = minHeapArray[1];
        heapNode lastNode = minHeapArray[currentSize];
        indexes[Integer.parseInt(lastNode.vertex.lable)] = 1;
        minHeapArray[1] = lastNode;
        minHeapArray[currentSize] = null;
        sinkDown(1);
        currentSize--;
        return min;
    }

    /**
     * This method to compare the values in the min heap to make sure all are in
     * correct position
     *
     * @param k
     */
    public void sinkDown(int k) {
        int smallest = k;
        int leftChildIndex = 2 * k;
        int rightChildIndex = 2 * k + 1;
        if (leftChildIndex < heapSize() && minHeapArray[smallest].key > minHeapArray[leftChildIndex].key) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < heapSize() && minHeapArray[smallest].key > minHeapArray[rightChildIndex].key) {
            smallest = rightChildIndex;
        }
        if (smallest != k) {

            heapNode smallestNode = minHeapArray[smallest];
            heapNode kNode = minHeapArray[k];

            //swap the positions
            indexes[Integer.parseInt(smallestNode.vertex.lable)] = k;
            indexes[Integer.parseInt(kNode.vertex.lable)] = smallest;
            swap(k, smallest);
            sinkDown(smallest);
        }
    }

    /**
     * swap to elements places
     *
     * @param num1 = the k value
     * @param num2 = the smallest value
     */
    public void swap(int num1, int num2) {
        heapNode temp = minHeapArray[num1];
        minHeapArray[num1] = minHeapArray[num2];
        minHeapArray[num2] = temp;
    }

    /**
     * This method will check if the currentSize equal to zero then it means
     * that the min heap is empty
     *
     * @return either true or false
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * @return heap Current size
     */
    public int heapSize() {
        return currentSize;
    }
}
