package tad;

import java.text.DecimalFormat;

public class Grafo {
    public static class Aresta {
        private int v1, v2, peso;

        public Aresta(int v1, int v2, int peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.peso = peso;
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
    }

    private int cab[], prox[];
    private double peso[];
    private int pos[]; // @{\it posi\c{c}\~ao atual ao se percorrer os adjs de um v\'ertice v}@
    private int numVertices, proxDisponivel;

    public Grafo(int numVertices) {
        int numArestas = 4500;
        int tam = numVertices + 2 * numArestas;
        this.cab = new int[tam];
        this.prox = new int[tam];
        this.peso = new double[tam];
        this.numVertices = numVertices;
        this.pos = new int[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            this.prox[i] = 0;
            this.cab[i] = i;
            this.peso[i] = 0;
            this.pos[i] = i;
        }
        this.proxDisponivel = this.numVertices;
    }

    public Grafo(int numVertices, int numArestas) {
        int tam = numVertices + 2 * numArestas;
        this.cab = new int[tam];
        this.prox = new int[tam];
        this.peso = new double[tam];
        this.numVertices = numVertices;
        this.pos = new int[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            this.prox[i] = 0;
            this.cab[i] = i;
            this.peso[i] = 0;
            this.pos[i] = i;
        }
        this.proxDisponivel = this.numVertices;
    }

    public void insereAresta(int v1, int v2, double peso) {
        if (this.proxDisponivel == this.cab.length)
            System.out.println("Nao ha espaco disponivel para a aresta");
        else {
            int ind = this.proxDisponivel++;
            this.prox[this.cab[v1]] = ind;
            this.cab[ind] = v2;
            this.cab[v1] = ind;
            this.prox[ind] = 0;
            this.peso[ind] = peso;
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

    public Aresta primeiroListaAdj(int v) {
        // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@
        // @{\it {\bf null} se a lista de adjac\^encia de v for vazia}@
        this.pos[v] = v;
        return this.proxAdj(v);
    }

    public Aresta proxAdj(int v) {
        // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@
        // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@
        this.pos[v] = this.prox[this.pos[v]];
        if (this.pos[v] == 0) return null;
        else return new Aresta(v, this.cab[pos[v]], (int) this.peso[pos[v]]);
    }

    public void imprime() {

        DecimalFormat df = new DecimalFormat("#,###.00");

        Rotas rota = new Rotas();
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print("\n" + i + "º Aeroporto " + rota.converterRotasNomes(i) + ":");

            for (int j = this.prox[i]; j != 0; j = this.prox[j])
                System.out.print("  |" + this.cab[j] + " " + rota.converterRotasNomes(this.cab[j]) + " (" + df.format(this.peso[j]) + ")| -");
        }
    }

    public int numVertices() {
        return this.numVertices;
    }

    public void verificarHamiltoniano(Grafo grafoRotas) {
        //esse metodo se baseia no teorema abaixo para calcular se o grafo é hamiltoniano ou nao
        //Teorema: Se G é um grafo de ordem p (>=3) tal que o grau(v) >= p/2 para cada vértice v de G, então G é hamiltoniano.
        int v1 = 0, p = 0, ordemGrafo = 0;
        int vetorQtdVertice[];

        vetorQtdVertice = new int[22];
        for (int i = 0; i < 22; i++) {
            v1 = i;
            if (!grafoRotas.listaAdjVazia(v1)) {
                Grafo.Aresta adj = grafoRotas.primeiroListaAdj(v1);

                while (adj != null) {
                    p++;
                    adj = grafoRotas.proxAdj(v1);
                }
                vetorQtdVertice[i] = p;
                p = 0;
            }
        }
        for (int i = 0; i < 22; i++) {
            if (ordemGrafo < vetorQtdVertice[i]) {
                //aqui obtemos o maior grau do grafo para ser a ordem dele
                ordemGrafo = vetorQtdVertice[i];
            }
        }
        //aqui irmaos dividir a ordem do grafo por 2 para fazer as verificaçoes
        System.out.println("\nO grafo possui grau: " + ordemGrafo);

        ordemGrafo = ordemGrafo / 2;
        p = 0;
        for (int i = 0; i < 22; i++) {
            //aqui iremos verificar o grau(v) >= p/2 para cada vértice, acumulando cada vez que o grafo entrar na condiçao
            if (vetorQtdVertice[i] >= ordemGrafo) {
                p++;
            }
        }

        //apos fazer as verificaçoes do teorema, iremos verificar se o somador deu 22, que é a quantidade de vertices que temos
        //se todos os vertices satisfazerem a condiçao do teorema, teremos o acumulador valendo 22 e ele pode ser considerado
        //um grafo hamiltoniano
        if (p == 22) {
            System.out.println("\nA rota criada atendeu ao teorema e é hamiltoniano");
        } else {
            System.out.println("\nA rota criada não atendeu ao teorema, por isso não é um caminho hamiltoniano");
        }

    }


}
