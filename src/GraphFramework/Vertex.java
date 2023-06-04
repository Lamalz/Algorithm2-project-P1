package GraphFramework;

import java.util.LinkedList;

public class Vertex {
    String lable;
    boolean isVisted = false;
    public LinkedList <Edge> adjList;

    public Vertex() {
        adjList = new LinkedList<Edge>();
    }
    public Vertex(String lable,boolean isVisted) {
        this.lable = lable;
        this.isVisted =  isVisted;
        adjList = new LinkedList<>();
    }
   
    public void displayInfo(){
    System.out.println(lable);
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public boolean isIsVisted() {
        return isVisted;
    }

    public void setIsVisted(boolean isVisted) {
        this.isVisted = isVisted;
    }

    public LinkedList <Edge> getAdjList() {
        return adjList;
    }

    public void setAdjList(LinkedList <Edge> adjList) {
        this.adjList = adjList;
    }

     
     
}