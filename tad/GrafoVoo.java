package tad;

import java.text.DecimalFormat;

public class GrafoVoo {

    public static class Aresta {
        private int v1, v2, peso, id, parada, duracao;

        public Aresta(int v1, int v2, int peso, int id, int parada, int duracao) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
            this.parada = parada;
            this.duracao = duracao;
            this.id = id;
        }

        public int id() {
            return this.id;
        }

        public int peso() {
            return this.peso;
        }

        public int v1() {
            return this.v1;
        }

        public int v2() {
            return this.v2;
        }

        public int parada() {
            return this.parada;
        }

        public int duracao() {
            return this.duracao;
        }
    }

    private int cab[], prox[];
    private double peso[];
    private int id[];

    private int parada[];

    private int duracao[];
    private int pos[]; // @{\it posi\c{c}\~ao atual ao se percorrer os adjs de um v\'ertice v}@
    private int numVertices, proxDisponivel;

    public GrafoVoo(int numVertices) {
        int numArestas = 4500;
        int tam = numVertices + 2 * numArestas;
        this.cab = new int[tam];
        this.prox = new int[tam];
        this.peso = new double[tam];
        this.id = new int[tam];
        this.parada = new int[tam];
        this.duracao = new int[tam];
        this.numVertices = numVertices;
        this.pos = new int[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            this.prox[i] = 0;
            this.cab[i] = i;
            this.peso[i] = 0;
            this.id[i] = 0;
            this.parada[i] = 0;
            this.duracao[i] = 0;
            this.pos[i] = i;
        }
        this.proxDisponivel = this.numVertices;
    }

    public GrafoVoo(int numVertices, int numArestas) {
        int tam = numVertices + 2 * numArestas;
        this.cab = new int[tam];
        this.prox = new int[tam];
        this.peso = new double[tam];
        this.id = new int[tam];
        this.parada = new int[tam];
        this.duracao = new int[tam];
        this.numVertices = numVertices;
        this.pos = new int[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            this.prox[i] = 0;
            this.cab[i] = i;
            this.peso[i] = 0;
            this.id[i] = 0;
            this.parada[i] = 0;
            this.duracao[i] = 0;
            this.pos[i] = i;
        }
        this.proxDisponivel = this.numVertices;
    }

    public void insereAresta(int v1, int v2, double peso, int id, int parada, int duracao) {
        if (this.proxDisponivel == this.cab.length)
            System.out.println("Nao ha espaco disponivel para a aresta");
        else {
            int ind = this.proxDisponivel++;
            this.prox[this.cab[v1]] = ind;
            this.cab[ind] = v2;
            this.cab[v1] = ind;
            this.prox[ind] = 0;
            this.peso[ind] = peso;
            this.id[ind] = id;
            this.parada[ind] = parada;
            this.duracao[ind] = duracao;
        }
    }

    public boolean existeAresta(int v1, int v2) {
        for (int i = this.prox[v1]; i != 0; i = this.prox[i])
            if (this.cab[i] == v2) return true;
        return false;
    } //@\lstcontinue@

    /*-- @{\it Operadores para obter a lista de adjacentes}@ --*/
    public boolean listaAdjVazia(int v) {
        return (this.prox[v] == 0);
    }

    public tad.Grafo.Aresta primeiroListaAdj(int v) {
        // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@
        // @{\it {\bf null} se a lista de adjac\^encia de v for vazia}@
        this.pos[v] = v;
        return this.proxAdj(v);
    }

    public tad.Grafo.Aresta proxAdj(int v) {
        // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@
        // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@
        this.pos[v] = this.prox[this.pos[v]];
        if (this.pos[v] == 0) return null;
        else return new tad.Grafo.Aresta(v, this.cab[pos[v]], (int) this.peso[pos[v]]);
    }

    public void imprime() {

        DecimalFormat df = new DecimalFormat("#,###.00");

        Rotas rota = new Rotas();
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print("\n" + i + "º Voo " + rota.converterRotasNomes(i) + ":");

            for (int j = this.prox[i]; j != 0; j = this.prox[j])
                System.out.print("  | " + this.cab[j] + "º, ID: " + this.id[j] + ", " + rota.converterRotasNomes(this.cab[j])
                        + ", (" + df.format(this.peso[j]) + " km), paradas " + this.parada[j] + ", duração: " + this.duracao[j] + "| ");
        }
    }

    public int numVertices() {
        return this.numVertices;
    }


}

