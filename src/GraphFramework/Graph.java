package GraphFramework;

import PhoneNetworkApp.Line;
import PhoneNetworkApp.Office;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    int verticesNo;
    int edgeNo;
    boolean isDigraph;
    ArrayList<Office> vertices;
   
    // ----------------------------------------------------------------------
    public Graph() {
       
    }

    public Graph(int verticesNo, int edgeNo, ArrayList<Office> vertices) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.vertices = vertices;
    }

    // ---------------------------------------------------------------------
    public void makeGraph(int verticesNo, int edgeNo) {

        vertices = new ArrayList<>();
        setData(verticesNo, edgeNo, vertices);

        for (int i = 0; i < verticesNo; i++) {
            createVertex(vertices, Integer.toString(i), false);
        }

        for (int i = 0; i < verticesNo - 1; i++) {
            int w = (int) (1 + Math.random() * 40);
            addEdge(vertices.get(i), vertices.get(i + 1), w);
        }
        int remEdges = edgeNo - (verticesNo - 1);

        for (int i = 0; i < remEdges; i++) {
            // randomly select two vertices to
            Office v = vertices.get((int) (Math.random() * verticesNo));
            Office u = vertices.get((int) (Math.random() * verticesNo));
            // assigning random waight values between(1 - 40)
            int w = (int) (1 + Math.random() * 40);

            if (v.getLable().equals(u.getLable())) {
                i--;
                continue;
            }
            boolean flag = false;
            for (int j = 0; j < v.adjList.size(); j++) {
                if (v.adjList.get(j).destination.getLable().equals(u.getLable())) {
                    i--;
                    flag = true;
                }
            }
            if (flag) {
                continue;
            }
            // add an edge between them
            addEdge(v, u, w);
        }

    }

    // ----------------------------------------------------------------------
    public void readGraphFromFile() throws FileNotFoundException {

        // create file object
        File file = new File("graph.txt");
        try {
            // scanner
            Scanner input = new Scanner(file);
            // read digraph 0 or 1
            String aa = input.nextLine();
            if (aa.equalsIgnoreCase("digraph 0")) {
                isDigraph = false;
            } else {
                isDigraph = true;
            }

            // read verts and edges number from file
            verticesNo = input.nextInt();
            edgeNo = input.nextInt();
            // create array list reprsenting the list of vertcies
            vertices = new ArrayList<>();
            

            // place data in graph object
            setData(verticesNo, edgeNo, vertices);
            // Graph graph = new Graph (verticesNo,edgeNo,vertices);

            while (input.hasNext()) {
                String v = input.next();
                Vertex v1 = createVertex(vertices, v, false);

                String u = input.next();
                Vertex u1 = createVertex(vertices, u, false);

                int w = input.nextInt();

                addEdge(v1, u1, w);
            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Can Not Be Found");
            System.exit(0);
        }
    }

    // add a waighted Edge between 2 vertcies
    public void addEdge(Vertex v, Vertex u, int w) {
        // creates an edge object and passes the source vertex v, the distination u, and
        // the edges' waight
        Edge line = createEdge(v, u, w);
       
        
        v.adjList.add(line);
        if (!isDigraph) {
            Edge line2 = createEdge(u, v, w);
       
            
            u.adjList.add(line2);
        }
    }

    public static Vertex createVertex(ArrayList<Office> vertices, String lable, boolean isVisited) {
        Office o;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getLable().equals(lable)) {
                o = vertices.get(i);
                return o;
            }
        }
        o = new Office(lable, isVisited);
        vertices.add(o);
        return o;
    }

    public static Edge createEdge(Vertex v, Vertex u, int w) {
        Line line = new Line(v, u, w);
        return line;
    }

    ///////////////////////////////////////////////////////////////
    public void setData(int verticesNo, int edgeNo, ArrayList<Office> vertices) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.vertices = vertices;
    }
    
    public ArrayList<Office> getVertices() {
        return vertices;
    }
    
}

