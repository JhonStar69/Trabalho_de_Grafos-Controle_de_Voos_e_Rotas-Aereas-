import java.util.ArrayList;
import java.util.Scanner;

import dijkstra.Dijkstra;
import tad.*;
import lerarquivo.ArquivoLer;

public class Main {
    static Scanner teclado = new Scanner(System.in);

    public static void chamarDJ(Dijkstra dj) throws Exception {
        System.out.println("Digite o numero do primeiro aeroporto: ");
        int num1 = teclado.nextInt();

        System.out.println("Digite o numero do segundo aeroporto: ");
        int num2 = teclado.nextInt();
        dj.obterArvoreCMC(num1);//FAZ UMA ARVORE E DEFINE O PRIMEIRO NUMERO COMO A RAIZ
        dj.imprimeCaminho(num1, num2);//IMPRIME A ARVORE E O MENOR CAMINHO

    }

    public static void main(String[] args) throws Exception {
        int op = -1;

        Grafo grafoRotas = new Grafo(23, 50);
        GrafoVoo grafoVoo = new GrafoVoo(23, 500);

        ArrayList<Aeroporto> informacoesAeroporto = new ArrayList<>(24);//array onde ficara as informaçoes dos aeroportos
        ArrayList<Voo> informacoesVoos = new ArrayList<>(724);//array onde ficara as informaçoes dos voos

        ArquivoLer arquivo = new ArquivoLer();//novo objeto para usar a classe de leitura de arquivos
        arquivo.LerAeroporto(informacoesAeroporto, grafoRotas, informacoesVoos, grafoVoo);

        Aeroporto aeroporto = new Aeroporto();
        Voo voo = new Voo();
        Dijkstra dj = new Dijkstra(grafoRotas);

        do {
            System.out.println("\n\nEscolha sua opção: " +
                    "\n0 - Sair" +
                    "\n1 - Imprimir informações de aeroporto" +
                    "\n2 - Imprimir informações de Voo" +
                    "\n3 - Imprimir ligações entre aeroportos" +
                    "\n4 - Imprimir grafo de voos" +
                    "\n5 - Procurar caminho entre dois aeroportos:" +//questao 5.1 relatorio
                    "\n6 - Pesquisar voo direto de determinado aeroporto" +//questao 5.2 relatorio
                    "\n7 - Viagem com menor custo" +//questao 5.3 relatorio
                    "\n8 - Determinar se um aeroporto consegue atingir qualquer outro" +//questao 5.4 relatorio
                    "\n9 - Definir uma rota que consiga passar por todos os aeroportos:" +//questao 5.5 relatorio
                    "");
            System.out.println("Digite a opção escolhida: ");
            op = teclado.nextInt();

            if (op == 0) {
                System.out.println("\nFinalizando programa.");
                break;
            } else if (op == 1) {

                aeroporto.imprimirInformacoesAeroporto(informacoesAeroporto);

            } else if (op == 2) {

                aeroporto.imprimirInformacoesVoo(informacoesVoos);

            } else if (op == 3) {

                System.out.println("\nOBS: A impressão abaixo mostra uma lista de aeroportos em que o aeroporto principal consegue ir com voos direto");
                grafoRotas.imprime();

            } else if (op == 4) {
                System.out.println("\nOBS: A impressão abaixo mostra os voos para cada aeroporto, resumido");
                grafoVoo.imprime();

            } else if (op == 5) {//verificar se existe algum caminho de um numero ao outro
                //5.1. Para dois aeroportos pesquisados mostrar o caminho, como uma sequência de aeroportos,com base
                // no grafo das rotas;
                chamarDJ(dj);//metodo para inserir numeros e imprimir o algoritimo de djigstra

            } else if (op == 6) {
                //5.2. Mostrar, a partir de um aeroporto definido, quais os voos diretos (sem escalas e/ou
                //conexões) que partem dele e a lista desses destinos.
                System.out.println("Digite o numero do aeroporto: ");
                int aero = teclado.nextInt();

                voo.vooDiretoSemPausa(informacoesVoos, aero);

            } else if (op == 7) {//
                //5.3. Dados uma origem e um destino, desenvolver um algoritmo para determinar a viagem com
                // menor custo em termos de: distância total a percorrer e tempo de voo.

                chamarDJ(dj);//metodo para inserir numeros e imprimir o algoritimo de djigstra

            } else if (op == 8) {
                //5.4. Desenvolver um algoritmo para determinar se é possível, a partir de um aeroporto qualquer
                //atingir qualquer outro (ou se será necessário em alguns casos fazer troca de aeroporto). Se for
                //possível, quais os aeroportos que, se ficassem fora de serviço (apenas um de cada vez),
                //impediriam essa situação.

                //OBS: sera sempre possivel atingir qualquer aeroporto, pois sempre criamos uma rota(arvore) nova
                // toda vez que o algoritimo de djigstra é chamado

                chamarDJ(dj);//metodo para inserir numeros e imprimir o algoritimo de djigstra

            } else if (op == 9) {
                //5.5. Partindo de um aeroporto selecionado definir uma rota que consiga passar por todos os
                //aeroportos e retornar até ele. Essa rota pode ser classificada como um circuito Hamiltoniano

                System.out.println("Digite o numero do aeroporto: ");
                int num1 = teclado.nextInt();

                dj.obterArvoreCMC(num1);//FAZ UMA ARVORE E DEFINE O PRIMEIRO NUMERO COMO A RAIZ

                dj.imprimeCaminhoGrafo();
                dj.obterArvoreCMC(22);
                dj.imprimeCaminho(22, num1);
                grafoRotas.verificarHamiltoniano(grafoRotas);

            }


        } while (true);

    }
}