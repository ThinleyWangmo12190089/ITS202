import java.util.*;
import java.util.NoSuchElementException;

public class Digraph {
    private final int V;                  // number of vertices in this digraph
    private int E;                        // number of edges in this digraph
    private LinkedList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;               // indegree[v] = indegree of vertex v
    
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(int V) {
        if(V < 0){
            System.out.println("The number vertices can not be less than zero.");
        }
        this.V = V;
        this.E = 0;

        adj = (LinkedList<Integer>[]) new LinkedList[V];
        indegree = new int[V];
        
        for (int i = 0;i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        

    }    
            
    /**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    public int V() {
       return V;
    }
    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int E() {
        return E;
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if(v<0 || v>=V){
            System.out.println("Vertex should be between 0 and V!!");
        }
        
    }
    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
         if(v<0 || v>=V){
            System.out.println("Vertex should be between 0 and V!!");
        }
        adj[v].add(w);// v is the tail vertex and w is the head vertex
        E++;
    }

    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
   
    /**
     * Returns the reverse of the digraph.
     *
     * @return the reverse of the digraph
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }
    /**
     * Returns a string representation of the graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,  
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Digraph d = new Digraph(6);
        d.addEdge(0,1);
        d.addEdge(0,2);
        d.addEdge(0,4);
        d.addEdge(1,2);
        d.addEdge(1,5);
        d.addEdge(2,4);
        d.addEdge(2,5);
        d.addEdge(3,5);
        d.addEdge(3,2);
        d.addEdge(4,3);

        d.validateVertex(0);

        System.out.println("No of vertices is: " +d.V());
        System.out.println("No of edges is: " +d.E());
        System.out.println(d.toString());
       
        System.out.println(d.reverse());

         assert(d.V() == 6);
         assert(d.E() == 10);   

        System.out.println("All Test Cases Passed");
       
       
    }

}