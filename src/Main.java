public class Main {
    public static void main(String[] args) {
        In in = new In("E:\\learning\\graduate\\detnet\\Code\\data\\tinyDirectedGraph.txt");
        Graph G = new DirectedGraph(in);
        ShortestPath sp = new ShortestPath(G, 5);
        for (int v = 0; v < G.V(); v++) {
            System.out.printf("%d->%d %.2f\n", 5, v, sp.distTo(v));
        }
    }
}
