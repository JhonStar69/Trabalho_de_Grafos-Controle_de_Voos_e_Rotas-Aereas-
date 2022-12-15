# Trabalho_de_Grafos-Controle_de_Voos_e_Rotas-Aereas-

Trabalho realizado para disciplina de Estrutura de dados 2, o intuito da atividade é trabalhar com grafos  através de aeroportos, onde cada aeroporto é uma 
vértice e cada rota é uma aresta.

## TAD

A implementação foi baseada nos algorítimos do livro, projeto de algoritmos do professor Nivio Ziviani , versão Java/C++.
As classes que possuem os algoritimos de FPHeapMinIndireto e Dijkstra, foram totalmente baseadas no livro, já a classe de grafos, foi totalmente baseada
para se fazer o grafo de rotas,  a classe de grafosVoo foi parcialmente baseada, sendo implementado algumas melhorias.

O trabalho foi feito em Java e possui 9 classes, sendo 1 o main e 3 pacotes, são eles:

Pacotes:
1. dijkstra
2. lerarquivo
3. tad

Classes:

1.FPHeapMinIndireto
2.Dijkstra
3.ArquivoLer
4.Aeroporto
5.Grafo
6.GrafoVoo
7.Rotas
8.Voo
9.Main

A implementação tera apenas informações de funcionalidades criadas, não tera explicação nem
informações dos algorítimos baseados no livro do Nivio.

## 2 IMPLEMENTAÇÃO

###  Rotas:

Na classe Rotas, foi criado dois metodos, são eles, converterRotasNomes(numero), converterRotasNumeros(nomeAeroporto), onde são uma especie de tradutor, pois a cada vez que se
imprime informações do aeroporto, ele busca o nome ou numero referente ao aeroporto. A classe rotas ainda possui um metodo que calcula o tempo de duração de cada voo, onde
ela é utilizada ao ler o arquivo calcularTempo( partida, chegada).

###  ArquivoLer:

A classe arquivoler possui os metodos necessarios para se ler o arquivo e salvar em estruturas feitas para cada informação.

###  Voo:

A classe voo possui a estrutura para salvar as informações dos voos, ou seja, ele copia os dados do arquivo e copia para um vetor contendo as informações dos voos, ainda possui o método
vooDiretoSemPausa(ArrayList<Voo> infVoo, int aero), que é um método para pesquisar quais são os voos sem parada de determinado aeroporto

### Aeroporto:
  
A classe aeroporto, contem os dados em relação aos aeroportos, ela possui uma estrutura para salvar os dados dos aeroportos do arquivo, ela possui o metodo
imprimirInformacoesAeroporto(ArrayList<Aeroporto> infAeroporto), que retorna uma lista de todos os aeroportos com numero e nome referente ao aeroporto. A classe também possui o método imprimirInformacoesVoo(ArrayList<Voo> infVoo) que
retorna uma lista de todos os voos com numero e nome referente ao aeroporto.

### Main:
  
O main contem toda a logica do programa, contem um menu que chama as outras funcionalidades. No main criamos todos os objetos das classes que iremos usar. O main possui um método que é para chamar o algorítimo de Dijkstra, esse método é para
inserir dois números e imprimir o caminho dele, ele sempre cria uma arvore com o primeiro numero recebido como raiz.

## 3. CONSIDERAÇÕES FINAIS.
o trabalho esta funcionando conforme o planejado e o interpretado por min, os métodos saíram como esperado e esta tudo conforme o previsto.
