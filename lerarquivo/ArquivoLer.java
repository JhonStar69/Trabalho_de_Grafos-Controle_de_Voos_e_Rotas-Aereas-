package lerarquivo;

import dijkstra.Dijkstra;
import tad.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ArquivoLer {

    public void LerAeroporto(ArrayList<Aeroporto> infAeroporto, Grafo grafoRotas, ArrayList<Voo> infVoos, GrafoVoo grafoVoo) throws Exception {

        FileInputStream entradaArquivo = new FileInputStream(new File("/home/jhon/IdeaProjects/Trabalho_Aeroporto/src/Voos_Original.txt"));
        int contAero = 0, contVoo = 0;
        int op = 1;

        Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
        Rotas rota = new Rotas();
        Dijkstra dj = new Dijkstra(grafoRotas);

        while (lerArquivo.hasNext()) {

            String linha = lerArquivo.nextLine();

            if (linha.charAt(0) == '!') {
                op = op + 1;
            }

            if (linha != null && !linha.isEmpty() && linha.charAt(0) != '!') {

                String dados[] = linha.split("\\,");

                if (op == 1) {//opção para ler os dados dos aeroportos

                    infAeroporto.add(new Aeroporto());//add os dados a lista de array

                    String nome = dados[0];
                    infAeroporto.get(contAero).setNomeAero(nome);

                    String fuso = dados[1];
                    infAeroporto.get(contAero).setFusoHorario(Integer.parseInt(fuso));

                    String xCoordenada = dados[2];
                    infAeroporto.get(contAero).setxCoordenada(Integer.parseInt(xCoordenada));

                    String yCoordenada = dados[3];
                    infAeroporto.get(contAero).setyCoordenada(Integer.parseInt(yCoordenada));
                    contAero++;//contador para ir mudando a posicao do vetor

                } else if (op == 2) {//opção para ler as rotas dos avies

                    int coordX1 = 0, coordY1 = 0, coordX2 = 0, coordY2 = 0;

                    int v1 = 0;
                    String nome1 = dados[0];
                    v1 = rota.converterRotasNumeros(nome1);
                    coordX1 = infAeroporto.get(v1).getxCoordenada();
                    coordY1 = infAeroporto.get(v1).getyCoordenada();

                    int v2 = 0;
                    String nome2 = dados[1];
                    v2 = rota.converterRotasNumeros(nome2);
                    coordX2 = infAeroporto.get(v2).getxCoordenada();
                    coordY2 = infAeroporto.get(v2).getyCoordenada();

                    //calcula a distancia dos voos
                    double termo1 = Math.pow((coordY1 - coordX1), 2);
                    double termo2 = Math.pow((coordY2 - coordX2), 2);

                    double peso = Math.sqrt(termo1 + termo2);//joga na formuila de pitagora

                    grafoRotas.insereAresta(v1, v2, peso); // @{\it Duas chamadas porque}@
                    grafoRotas.insereAresta(v2, v1, peso); // @{\it Duas chamadas porque}@

                } else if (op == 3) {//opção para ler os voos dos avioes

                    //aqui inserimos o dados dos voos em uma lista de vetor
                    infVoos.add(new Voo());//add os dados a lista de array
                    //VooID
                    String voo = dados[0];
                    infVoos.get(contVoo).setVoo(Integer.parseInt(voo));

                    // aeroporto de origem
                    String origem = dados[1];
                    infVoos.get(contVoo).setAeroportoOrigem(origem);

                    //Hora de partida
                    String partida = dados[2];
                    infVoos.get(contVoo).setHoraPartida(partida);
                    //   Aeroporto de destino
                    String destino = dados[3];
                    infVoos.get(contVoo).setAeroportoDestino(destino);
                    //  Tempo de chegada
                    String chegada = dados[4];
                    infVoos.get(contVoo).setHoraChegada(chegada);

                    // Paradas durante o voo
                    String Paradas = dados[5];
                    infVoos.get(contVoo).setParadasVoo(Integer.parseInt(Paradas));

                    //aqui inserimos os dados dos voos no grafo de voo, sem contar o peso(distancia)
                    int vertice1 = 0;
                    String nome01 = dados[1];
                    vertice1 = rota.converterRotasNumeros(nome01);

                    int vertice2 = 0;
                    String nome02 = dados[3];
                    vertice2 = rota.converterRotasNumeros(nome02);

                    dj.obterArvoreCMC(vertice1);//FAZ UMA ARVORE E DEFINE O PRIMEIRO NUMERO COMO A RAIZ
                    int peso = 0;
                    peso = dj.calculaDistancia(vertice1, vertice2, peso);

                    int duracao = rota.calcularTempo(partida, chegada);
                    grafoVoo.insereAresta(vertice1, vertice2, peso, Integer.parseInt(voo), Integer.parseInt(Paradas), duracao); // é um grafo direcionado, pois sao os voos
                    contVoo++;//contador para ir mudando a posicao do vetor

                }
            }

        }

    }


}
