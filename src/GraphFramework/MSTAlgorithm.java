package GraphFramework;

import java.util.ArrayList;


public abstract class MSTAlgorithm {
    
    Graph graph;
    ArrayList <Edge> MSTResultList;
    
    
      public MSTAlgorithm() {
         MSTResultList =  new ArrayList<Edge>();
         
 graph=new Graph();
    }

    //absract method to force the children to implement it
    public abstract void displayResultingMST(ArrayList <Edge> MSTResultList);
 
}
