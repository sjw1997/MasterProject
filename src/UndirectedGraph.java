public class UndirectedGraph extends Graph {

    public UndirectedGraph(In in) {
        super(in);
    }

    public void addEdge(int v, int w, double weight) {
        Edge e1 = new Edge(v, w, weight);
        Edge e2 = new Edge(w, v, weight);
        adj[v].add(e1);
        adj[w].add(e2);
        E++;
    }
}
