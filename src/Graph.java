import java.util.LinkedList;
import java.util.List;

public abstract class Graph {

    protected int V;              // number of vertices
    protected int E;              // number of edges
    protected List<Edge>[] adj;     // adjacency lists

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public Graph() {}

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // edges adjacent to v
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public abstract void addEdge(int v, int w, double weight);
}