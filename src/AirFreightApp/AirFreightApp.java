/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package AirFreightApp;

import GraphFramework.DBAllSourceSPAlg;
import GraphFramework.SingleSourceSPAlg;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirFreightApp {
    
    static AFRouteMap map;
    
    public static void main(String[] args) throws FileNotFoundException{
        
        // Create objects
        Scanner input = new Scanner(System.in);
        map = new AFRouteMap();
        
        // Flag to determine when to print the paths
        boolean flag = false;
        
        // Make user choose 
        System.out.println("(((( Efficient Air freight system of transporting goods: Powered by Dijkstra algorithm ))))\n\n");
        System.out.print("Type 1 to Upload a File or Any Other Number to Generate a Random Graph: ");
        int option = input.nextInt();
        
        if(option != 1){ // Apply makeGraph() method
            
            int vNum = 0, eNum, choice;
            do{
                System.out.println("\n\n--------------------- Choose From 1 to 5 ------------------");
                System.out.println("*** where n = number of vertices and m = number of edges ***");
                System.out.println("*** These are the available cases: ***");
                System.out.println("    1) n=2,000  ***  m=10,000  "
                + "\n    2) n=3,000  ***  m=15,000  " 
                + "\n    3) n=4,000  ***  m=20,000  "
                + "\n    4) n=5,000  ***  m=25,000  "
                + "\n    5) n=6,000  ***  m=30,000  "
                + "\n-------------------------------");
                System.out.print("Your choice: ");

                choice = input.nextInt();

                switch(choice){
                    case 1:
                        vNum = 2000; eNum = 10000; break;
                    case 2: 
                        vNum = 3000; eNum = 15000; break;
                    case 3: 
                        vNum = 4000; eNum = 20000; break;
                    case 4:
                        vNum = 5000; eNum = 25000; break;
                    case 5:
                        vNum = 6000; eNum = 30000; break;
                    default: 
                        System.out.print("Error! Please choose from 1 to 5: "); continue;
                }

                map.makeGraph(vNum, eNum);

            } while(!(choice>=1 && choice<=5));
            
            // Compute the all-pair-source shortest path problem by SingleSourceSPAlg
            SingleSourceSPAlg obj = new SingleSourceSPAlg(map);
            long startTime = System.nanoTime();
            obj.computeDijkstraAlg(new Location("1", vNum), flag);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("------------------------------------------------\nTotal time elapsed (Single Source Dijkstra's Algorithm) : " + elapsedTime + "\n");
           
            
            
        } else { // Read graph from file
            
            flag = true;
            System.out.print("Please enter the file name you wish to use, including the '.txt' extension: ");
            String fileName = input.next();
            map.readGraphFromFile(fileName);
            System.out.println("\n");
            
            // Compute the all-pair-source shortest path problem by DBAllSourceSPAlg
            DBAllSourceSPAlg alg1 = new DBAllSourceSPAlg(map);
            alg1.computeDijkstraBasedSPAlg(flag);
            
        }
        

    }
}
