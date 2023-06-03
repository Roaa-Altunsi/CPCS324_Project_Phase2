/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package GraphFramework;

import java.util.PriorityQueue;

public class SingleSourceSPAlg extends ShortestPathAlgorithm{
    
    // CONSTRUCTOR
    public SingleSourceSPAlg(Graph graph){
        super(graph);
    }

    // METHODS
    public void computeDijkstraAlg(Vertex source, boolean flag){
        int dist[]=new int[this.graph.verticesNo];
        int inf= Integer.MAX_VALUE;
        int parent[] =new int[this.graph.verticesNo];
        
        int indexSrc = (flag)? source.label.charAt(5)-'A': Integer.parseInt(source.label.substring(5))-1;
        
        
        for (int i = 0; i < dist.length; i++)
	       dist[i] = inf;
        dist[indexSrc] = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> Integer.compare(a[0],b[0]));// q containing arrays with length 2 to store (val, node)
        
        // add the source to the queue 
        int fpair[]={0,indexSrc};
        q.add(fpair);

        // 
        while(!q.isEmpty()){
            int arr[] =q.poll();
            int val = arr[0],  node = arr[1];
            
            if(dist[node] < val ) continue; // keep the shortest distance 
            for (int i = 0; i < graph.vertices[node].adjList.size(); i++) { // iterate trhough adjacent vertices 
                Edge e = graph.vertices[node].adjList.get(i);
                int to = (flag)? e.target.label.charAt(5)-'A': Integer.parseInt(e.target.label.substring(5))-1;
                int w = e.weight;
                
                // update the shortest distance 
                if (dist[to] > val + w) {
	               dist[to] = val + w;
                       int pair[]={dist[to], to};
	               q.add(pair);
                       parent[to]=node;
                } 
            } 
        }
       
        // print shortest path
        if(flag){
            for(int i=0; i<graph.verticesNo; i++){
                
                if(dist[i] == inf) {
                    System.out.println("");
                    System.out.println("There is no path from " + source.label + " to " + graph.vertices[i].label);
                    continue;
                }

                if(i != indexSrc){
                    System.out.println("");
                    getPath(source, i, parent);
                    System.out.println(" --- route length: " + dist[i]);
                }
            }
        }
 
    }
    
    // Display the shortest path to the node
    public void getPath(Vertex source, int node, int[] parent){
        // Base case
        if(graph.vertices[parent[node]].label.equals(source.label)){  
            source.displayInfo();
            System.out.print("- ");
            graph.vertices[node].displayInfo();
        } else {
            getPath(source, parent[node], parent);
            System.out.print("- ");
            graph.vertices[node].displayInfo();
        }
        
        
    }
    
}
