public class UndirectedGraph extends Graph {

    public UndirectedGraph(int V) {
        super(V);
    }

    public void addEdge(int v, int w, double weight) {
        Edge e = new Edge(v, w, weight);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
}
