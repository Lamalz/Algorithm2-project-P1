package GraphFramework;

import PhoneNetworkApp.Line;
import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlg extends MSTAlgorithm {

    ArrayList<Line> edges = new ArrayList<>();

    public void KruskalAlgo(Graph graph) {
        MSTResultList = new ArrayList<Edge>();
        // Add all edges in the graph to the edges list
        for (Vertex vertex : graph.getVertices()) {
            for (Edge edge : vertex.getAdjList()) {
                edges.add((Line) edge);
            }
        }
        displayResultingMST(MSTResultList);
    }

    @Override
    public void displayResultingMST(ArrayList<Edge> MSTResultList) {
        int cost = 0;
        Collections.sort(edges);// Sort All Edges in decreasing Order
        UnionFind set = new UnionFind(edges.size());      
        for (Line edge : edges) {

            if (!set.find(Integer.parseInt(edge.getSource().lable), Integer.parseInt(edge.getDestination().lable))) {
                set.unite(Integer.parseInt(edge.getSource().lable), Integer.parseInt(edge.getDestination().lable));
                MSTResultList.add(edge);// Add  edge to the MSTResultList	
                cost += edge.getWeight();// add edge weight(cost) to weight
            }
        }
        System.out.println(" ");
        printMST(MSTResultList); //Print Office No. " " - Office No. " " Line Length : " " 
        System.out.println(" ");
         //return cost
        System.out.println("The cost of designed phone network::  " + cost);

    }
       // Print The source and destnation and length
    private void printMST(ArrayList<Edge> edgesList) {
        for (int i = 0; i < edgesList.size(); i++) {

            System.out.print("Office No." + edgesList.get(i).source.lable + " - Office No. " + edgesList.get(i).destination.lable + " Line Length :");
            edgesList.get(i).displayInfo();

        }
    }
}
