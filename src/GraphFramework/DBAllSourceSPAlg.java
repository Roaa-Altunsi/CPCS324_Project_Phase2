/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package GraphFramework;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm{
    
    // CONSTRUCTOR
    public DBAllSourceSPAlg(Graph graph){
        super(graph);
    }
    
    // METHODS
    public void computeDijkstraBasedSPAlg(boolean flag){
        
        // Computing the shortest path from each vertex to the rest of the vertices
        int numVertices = graph.verticesNo;
        SingleSourceSPAlg Single = new SingleSourceSPAlg(graph);
        for (int sourceVertex = 0; sourceVertex < numVertices; sourceVertex++) {
            
            System.out.println("The starting point location is " + graph.vertices[sourceVertex].label.charAt(5));
            System.out.println("The routes from location " + graph.vertices[sourceVertex].label.charAt(5) + 
                    " to the rest of the locations are:");
            Single.computeDijkstraAlg(graph.vertices[sourceVertex], flag);
            System.out.println("\n---------------------------------------------------------------\n");
            
        }
        
    }
    
}
