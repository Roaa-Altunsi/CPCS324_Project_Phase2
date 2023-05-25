/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package GraphFramework;

public class Edge {
    
    // ATRIBUTES 
    public Vertex source;
    public Vertex target;
    public Vertex parent;
    public int weight;

    // CONSTRUCTOR
    public Edge(Vertex source, Vertex target, Vertex parent, int weight) {
        this.source = source;
        this.target = target;
        this.parent = parent;
        this.weight = weight;
    }
    
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    // METHODS
    public void displayInfo() {
        System.out.println(" Office No."   + source.label+" - Office No. "+target.label+" : line length: "+weight);
    }
    
}
