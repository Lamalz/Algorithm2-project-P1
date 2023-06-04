package GraphFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import PhoneNetworkApp.Line;


public class MHPrimAlg extends MSTAlgorithm {

    //----------------------------Methods Section----------------------------
    /**
     * This method to apply the prim algorithm using min heap and find the MST
     *
     * @param graph is an object of Graph class
     * @return cost of the minimum spanning tree using prim algorithm
     * implemented using min-heap
     */
    public void MSTPrimAlg(Graph graph) {
        /*boolean array with length ove verticesNo 
        if vertex in heap--> the index (which is equal to vertex label) will be true 
        if vertex not in heap--> the index (which is equal to vertex label)  will be false*/
        boolean[] inHeap = new boolean[graph.verticesNo];
        //create array heapNode for all the vertices
        heapNode[] heapNodes = new heapNode[graph.verticesNo];
        //Declaration of the superclass attribute 
        MSTResultList = new ArrayList<Edge>();
        //for loop to for each vertex to create heapNode for every vertex with key=infinity
        //and inHeap [vertex label] will be true-->means the vertex in heap
        //also fo every vertex add edge with parent null 
        for (int i = 0; i < graph.verticesNo; i++) {
            //create heapNodes for the vertex and key=infinity
            heapNodes[i] = new heapNode(graph.vertices.get(i), Integer.MAX_VALUE);
            //create edge and add it to the MSTResultList  
            MSTResultList.add(new Line());
            inHeap[i] = true;
        }

        //decrease the key for the first heapNode(first vertex)
        heapNodes[0].key = 0;
        //add all the vertices to the MinHeap
        minHeap minHeap = new minHeap(graph.verticesNo);

        //add all heapNodes (all the vertices) to priority queue
        for (int i = 0; i < graph.verticesNo; i++) {
            minHeap.insert(heapNodes[i]);
        }

        //while minHeap is not empty
        while (!minHeap.isEmpty()) {
            //extract the min heapNode
            heapNode extractedMinNode = minHeap.extractMin();
            //extracted vertex
            Vertex extractedVertex = extractedMinNode.vertex;
            //change to inHeap status of the vertex to false
            inHeap[Integer.parseInt(extractedVertex.lable)] = false;
            //iterate through all the adjacent vertices (all edges)
            LinkedList<Edge> list = extractedVertex.adjList;

            //for loop to add all the adjacent edge of extractedVertex
            for (int i = 0; i < list.size(); i++) {
                //get the edge
                Edge edge = list.get(i);
                //only if edge destination is present in heap
                if (inHeap[Integer.parseInt(edge.destination.lable)]) {
                    //variable to store destination label of the edge
                    int destination = Integer.parseInt(edge.destination.lable);
                    //variable to store weight of the edge 
                    int newKey = edge.weight;
                    //check if the the exisiting destiantion key(which stored in heapNode[destination])>updated key
                    //if yes--> update, if not--> remaining the exisiting one 
                    if (heapNodes[destination].key > newKey) {
                        //decrease the key in the heapNode[destination]
                        decreaseKey(minHeap, newKey, destination);
                        //update the parent node for destination
                        MSTResultList.get(destination).parent = extractedVertex;
                        //update the weight for destination
                        MSTResultList.get(destination).weight = newKey;
                        MSTResultList.get(destination).destination.lable = Integer.toString(destination);
                        //update key of destination's heap node
                        heapNodes[destination].key = newKey;
                    }
                }
            }
        }
        //return the cost by call displayResultingMST method to calculate the cost
        displayResultingMST(MSTResultList);
    }

    /**
     * This method decrease key of the heap node and resort the min heap and put
     * the heap node in correct position
     *
     * @param minHeap -- min-heap object to reach to the heapNode to be updated
     * @param newKey -- new key to update the heapNode
     * @param vertex -- label of vertex of the heapNode
     */
    public void decreaseKey(minHeap minHeap, int newKey, int vertex) {
        //get the index which key's needs a decrease;
        int index = minHeap.indexes[vertex];
        //get the node and update its value
        heapNode node = minHeap.minHeapArray[index];
        node.key = newKey;
        minHeap.bubbleUp(index);
    }

    /**
     * This method will accept the linked list of edge of minimum spanning tree
     * and display the edge and calculate the cost then return it
     *
     * @param edgesList -- which is the array of edges that is included in the
     * minimum spanning tree
     * @return the cost of minimum spanning tree
     */
    @Override
    public void displayResultingMST(ArrayList <Edge> edgesList) {
        int cost = 0;
        //for loop to calculate the cost of all edge in minimum spanning tree 
        for (int i = 0; i < edgesList.size(); i++) {
            Edge edge = edgesList.get(i);
            //add weight to the cost
            cost += edge.weight;
        }
         printMST(edgesList);
        //return cost
        System.out.println(" " );
        System.out.println("The cost of designed phone network: "+cost);
       
    }

    private void printMST(ArrayList<Edge> edgesList) {
        for (int i = 1; i < edgesList.size(); i++) {
            System.out.println("Office No."+edgesList.get(i).parent.lable+" - Office No. "+ edgesList.get(i).destination.lable +" Line Length :" + (edgesList.get(i).weight * 5));
            
        }
    }
    

}