/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package AirFreightApp;

public class Location extends GraphFramework.Vertex{
    
    String city;
            
    public Location(String label) {
        super(label);
        this.label = "loc. " + label;
        city = "city " + Math.random() * 30;
    }
    
    @Override
    public void displayInfo(){
        System.out.println(label + ": " + city);
    }
}
