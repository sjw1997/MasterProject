import edu.princeton.cs.algs4.IndexMinPQ;

public class ShortestPath {

    private double[] distTo;
    private Edge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public ShortestPath(Graph G, int source) {
        int V = G.V();
        distTo = new double[V];
        edgeTo = new Edge[V];
        pq = new IndexMinPQ<>(V);
        for (int v = 0; v < V; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[source] = .0;
        pq.insert(source, distTo[source]);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(Graph G, int v) {
        for (Edge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Edge> path = new Stack<>();
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
