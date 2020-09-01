public class DirectedGraph extends Graph {

    public DirectedGraph(In in) {
        super(in);
    }

    public void addEdge(int from, int to, double weight) {
        Edge e = new Edge(from, to, weight);
        adj[from].add(e);
        E++;
    }

}
