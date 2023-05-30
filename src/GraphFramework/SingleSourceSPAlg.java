/*
CPCS324 Group Project | Phase2 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
*/

package GraphFramework;
import java.util.*;

public class SingleSourceSPAlg extends ShortestPathAlgorithm{
    
    // CONSTRUCTOR
    public SingleSourceSPAlg(Graph graph){
        super(graph);
    }

    // METHODS
    public void computeDijkstraAlg(Vertex source){
        int dist[]=new int[this.graph.verticesNo];
        int inf= Integer.MAX_VALUE;
        int parent[] =new int[this.graph.verticesNo];
        
        
        for (int i = 0; i <= dist.length; i++)
	       dist[i] = inf;
        dist[1] = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> Integer.compare(a[0],b[0]));// q containing arrays with length 2 to store (val, node)
        
        // add the source to the queue 
        int fpair[]={0,(source.label.charAt(0)-'A')};
        q.add(fpair);
        
        //
        while(q.size()!=0){
            int arr[] =q.poll(); 
            int val = arr[0],  node = arr[1];
            
            if(dist[node] < val ) continue;
            for (int i = 0; i < graph.vertices[node].adjList.size(); i++) {
                Edge e = graph.vertices[node].adjList.get(i);
                int to = e.target.label.charAt(0)-'A';
                int w = e.weight;
                
                if (dist[to] > val + w) {
	               dist[to] = val + w;
                       int pair[]={dist[to], to};
	               q.add(pair);
                       parent[to]=node;
                } 
            } 
        }
    }
    
}