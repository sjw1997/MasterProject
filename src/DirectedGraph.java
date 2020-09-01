public class DirectedGraph extends Graph {

    public DirectedGraph(int V) {
        super(V);
    }

    public void addEdge(int from, int to, double weight) {
        Edge e = new Edge(from, to, weight);
        adj[from].add(e);
        E++;
    }

}
