package dijkstra;

import tad.*;

public class Dijkstra {
    private int[] antecessor;
    private double[] p;
    private final Grafo grafo;

    Rotas rota = new Rotas();

    public Dijkstra(Grafo grafo) {
        this.grafo = grafo;
    }

    public void obterArvoreCMC(int raiz) throws Exception {
        int n = this.grafo.numVertices();
        this.p = new double[n]; // @{\it peso dos v\'ertices}@
        int[] vs = new int[n + 1]; // @{\it v\'ertices}@
        this.antecessor = new int[n];
        for (int u = 0; u < n; u++) {
            this.antecessor[u] = -1;
            p[u] = Double.MAX_VALUE; // @$\infty$@
            vs[u + 1] = u; // @{\it Heap indireto a ser constru\'{\i}do}@
        }
        p[raiz] = 0;
        FPHeapMinIndireto heap = new FPHeapMinIndireto(p, vs);
        heap.constroi();
        while (!heap.vazio()) {
            int u = heap.retiraMin();
            if (!this.grafo.listaAdjVazia(u)) {
                Grafo.Aresta adj = grafo.primeiroListaAdj(u);
                while (adj != null) {
                    int v = adj.v2();
                    if (this.p[v] > (this.p[u] + adj.peso())) {
                        antecessor[v] = u;
                        heap.diminuiChave(v, this.p[u] + adj.peso());
                    }
                    adj = grafo.proxAdj(u);
                }
            }
        }
    }

    public int antecessor(int u) {
        return this.antecessor[u];
    }

    public double peso(int u) {
        return this.p[u];
    }

    public void imprime() {

        for (int u = 0; u < this.p.length; u++) {
            if (this.antecessor[u] != -1) {
                System.out.println("(" + antecessor[u] + " " + rota.converterRotasNomes(antecessor[u]) +
                        "," + u + " " + rota.converterRotasNomes(u) + ") -- d:" + peso(u) + " km");
            }
        }

    }

    public void imprimeCaminhoGrafo() {

        for (int u = 0; u < this.p.length; u++) {
            if (this.antecessor[u] != -1) {
                System.out.println(antecessor[u] + " " + rota.converterRotasNomes(antecessor[u]) + "\n"
                        + u + " " + rota.converterRotasNomes(u) + " - " + peso(u) + " km");
            }
            //System.out.println(v + " " + rota.converterRotasNomes(v) + " - " + peso(v) + " km");
        }

    }

    public void imprimeCaminho(int origem, int v) {

        if (origem == v) {
            System.out.println(origem + " " + rota.converterRotasNomes(origem));

        } else if (this.antecessor[v] == -1) {
            System.out.println("Nao existe caminho direto de " + origem + " " + rota.converterRotasNomes(origem) +
                    " ate a raiz " + v + " " + rota.converterRotasNomes(v));

        } else {
            imprimeCaminho(origem, this.antecessor[v]);
            System.out.println(v + " " + rota.converterRotasNomes(v) + " - " + peso(v) + " km");
        }

    }

    public int calculaDistancia(int origem, int v, int peso) {

        if (origem == v) {
            return origem;

        } else {
            calculaDistancia(origem, this.antecessor[v], peso);
            peso += peso(v);
        }
        return peso;
    }

}