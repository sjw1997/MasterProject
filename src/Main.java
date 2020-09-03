public class Main {
    public static void main(String[] args) {
        In in = new In("E:\\learning\\graduate\\detnet\\Code\\data\\tinyDirectedGraph.txt");
        Graph G = new DirectedGraph(in);
        int source = 5, dest = 0;

        int n = 3;
        for (int i = 1; i <= n; i++) {
            ShortestPath sp = new ShortestPath(G, source);
            if (sp.hasPathTo(dest)) {
                System.out.printf("\nThe cost of the %dth path is %.2f\n", i, sp.distTo(dest));
                for (Edge e : sp.pathTo(dest)) {
                    System.out.println(e);
                }
                for (Edge e : sp.pathTo(dest)) {
                    e.setWeight(e.weight() + 1);
                }
            }
        }

    }
}
