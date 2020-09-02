public class Main {
    public static void main(String[] args) {
        In in = new In("E:\\learning\\graduate\\detnet\\Code\\data\\tinyDirectedGraph.txt");
        Graph G = new DirectedGraph(in);
        ShortestPath sp = new ShortestPath(G, 0);
        for (int v = 0; v < G.V(); v++) {
            System.out.printf("%d->%d %.2f\n", 0, v, sp.distTo(v));
        }
    }
}
