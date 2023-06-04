package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;
import java.util.ArrayList;

public class BluePrintsGraph extends Graph {
    
        public static Edge createEdge(Vertex v, Vertex u, int w) {
        return new Line(v, u, w);
     
    }

          public static Vertex createVertex(ArrayList<Office> vertices, String lable, boolean isVisited) {
               return new Office(lable, isVisited);
    
          }   
}
