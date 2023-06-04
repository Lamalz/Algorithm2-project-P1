package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

public class Line extends Edge {
    private int length = 5 * super.getWeight()  ;

    public Line(Vertex source, Vertex destination, int weight) {
        super(source, destination, weight);
    }
    public Line(){
        this.source = new Office(); 
        this.destination = new Office(); 
        this.parent = new Office();
    }
    
    
    @Override
    public void displayInfo() {
        System.out.println(length);

    }

    public int getLength() {
        return length;
    }
    
    
}
