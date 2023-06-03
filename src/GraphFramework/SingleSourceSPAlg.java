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
        
        for (int i = 0; i < dist.length; i++)
	       dist[i] = inf;
        dist[source.label.charAt(5)-'A'] = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> Integer.compare(a[0],b[0]));// q containing arrays with length 2 to store (val, node)
        
        // add the source to the queue 
        int fpair[]={0,(source.label.charAt(5)-'A')};
        q.add(fpair);

        //
        while(!q.isEmpty()){
            int arr[] =q.poll();
            int val = arr[0],  node = arr[1];
            
            if(dist[node] < val ) continue;
            for (int i = 0; i < graph.vertices[node].adjList.size(); i++) {
                Edge e = graph.vertices[node].adjList.get(i);
                int to = e.target.label.charAt(5)-'A';
                int w = e.weight;
                
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

                if(i != source.label.charAt(5)-'A'){
                    System.out.println("");
                    getPath(source, i, parent);
                    System.out.println(" --- route length: " + dist[i]);
                }
            }
        }
 
    }
    
    public void getPath(Vertex source, int node, int[] parent){
        
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
