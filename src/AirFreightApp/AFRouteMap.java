/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package AirFreightApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

public class AFRouteMap extends GraphFramework.Graph{
    
    @Override
    public Edge createEdge(Vertex source, Vertex target, int weight) {
        Route r = new Route(source, target, weight);
        return r;
    }

    @Override
    public Vertex createVertex(String label, int verticesNo) {
        Location loc = new Location(label, verticesNo);
        return loc;
    }
    
}
