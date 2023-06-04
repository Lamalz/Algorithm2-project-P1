package GraphFramework;

public class heapNode {
    Vertex vertex;
   
    int key;

    public heapNode() {
    }

    /**
     * constructor with specific value
     *
     * @param vertex --> the vertex that represented by the heapNode
     * @param key --> key the weight so far
     */
    public heapNode(Vertex vertex, int key) {
        this.vertex = vertex;
        this.key = key;
    }

}

    

