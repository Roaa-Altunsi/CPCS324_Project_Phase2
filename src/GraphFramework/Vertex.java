/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package GraphFramework;

import java.util.LinkedList;

public abstract class Vertex {
    
    // ATRIBUTES 
    public String label;
    boolean isVisited;
    LinkedList<Edge> adjList;

    // CONSTRUCTOR
    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        this.adjList = new LinkedList<Edge>();
    }

    // METHODS
    public abstract void displayInfo();
    
}
