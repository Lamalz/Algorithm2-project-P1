package GraphFramework;

import PhoneNetworkApp.Office;

public class Edge implements Comparable<Edge> {
    int weight;
    public Vertex source, destination, parent;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
        this.parent = new Office();// ypu prob dont need it
    }
    public Edge(){
    }
    public void displayInfo() {
        System.out.println(source + " " + destination + " " + weight);

    }
    
   public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }
    public Edge(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        if (this.weight > e.weight) {
            return 1;
        } else if (this.weight == e.weight) {
            return 0;
        } else {
            return -1;
        }
    }

  
}
