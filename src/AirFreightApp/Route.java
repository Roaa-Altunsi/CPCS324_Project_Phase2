/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package AirFreightApp;

import GraphFramework.Vertex;

public class Route extends GraphFramework.Edge{
    
    public Route(Vertex source, Vertex target, Vertex parent, int weight) {
        super(source, target, parent, weight);
    }
    
    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }
    
    @Override
    public void displayInfo(){
        System.out.println("--- route length: ");
    }
    
}
