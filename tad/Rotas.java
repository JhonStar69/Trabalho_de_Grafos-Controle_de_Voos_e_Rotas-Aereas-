package tad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rotas {
    public int converterRotasNumeros(String nomeAeroporto) {
        int vertice = -1;

        switch (nomeAeroporto) {
            case "ABQ":
                vertice = 0;
                break;
            case "ATL":
                vertice = 1;
                break;
            case "BNA":
                vertice = 2;
                break;
            case "BOS":
                vertice = 3;
                break;
            case "DCA":
                vertice = 4;
                break;
            case "DEN":
                vertice = 5;
                break;
            case "DFW":
                vertice = 6;
                break;
            case "DTW":
                vertice = 7;
                break;
            case "HOU":
                vertice = 8;
                break;
            case "JFK":
                vertice = 9;
                break;
            case "LAX":
                vertice = 10;
                break;
            case "MIA":
                vertice = 11;
                break;
            case "MSP":
                vertice = 12;
                break;
            case "MSY":
                vertice = 13;
                break;
            case "ORD":
                vertice = 14;
                break;
            case "PHL":
                vertice = 15;
                break;
            case "PHX":
                vertice = 16;
                break;
            case "PVD":
                vertice = 17;
                break;
            case "RDU":
                vertice = 18;
                break;
            case "SEA":
                vertice = 19;
                break;
            case "SFO":
                vertice = 20;
                break;
            case "STL":
                vertice = 21;
                break;
            case "TPA":
                vertice = 22;
                break;
            default:
                System.out.println("Erro naoi tem");
                break;
        }

        return vertice;
    }

    public String converterRotasNomes(int numero) {
        String nome = null;

        switch (numero) {
            case 0:
                nome = "ABQ";
                break;
            case 1:
                nome = "ATL";
                break;
            case 2:
                nome = "BNA";
                break;
            case 3:
                nome = "BOS";
                break;
            case 4:
                nome = "DCA";
                break;
            case 5:
                nome = "DEN";
                break;
            case 6:
                nome = "DFW";
                break;
            case 7:
                nome = "DTW";
                break;
            case 8:
                nome = "HOU";
                break;
            case 9:
                nome = "JFK";
                break;
            case 10:
                nome = "LAX";
                break;
            case 11:
                nome = "MIA";
                break;
            case 12:
                nome = "MSP";
                break;
            case 13:
                nome = "MSY";
                break;
            case 14:
                nome = "ORD";
                break;
            case 15:
                nome = "PHL";
                break;
            case 16:
                nome = "PHX";
                break;
            case 17:
                nome = "PVD";
                break;
            case 18:
                nome = "RDU";
                break;
            case 19:
                nome = "SEA";
                break;
            case 20:
                nome = "SFO";
                break;
            case 21:
                nome = "STL";
                break;
            case 22:
                nome = "TPA";
                break;
            default:
                System.out.println("Erro não tem");
                break;
        }

        return nome;
    }


    public int calcularTempo(String partida, String chegada) {
        //essa coiserada é pra calcular a duração do tempo do voo

        //parte onde retiramos a letra P ou A das strings
        partida = String.valueOf(pegarNumerosApenas(partida));
        chegada = String.valueOf(pegarNumerosApenas(chegada));

        //variaveis para calculos
        int minutoP, horaP, minutoC, horaC;//p=partida, c = chegada

        //aqui fazemos comparaçao para ver o tamanho da string e ver onde vamos pegar a hora e o minuto
        //pode ser que tenha string com apenas 3 numeros, entao copiamos os valores para as novas variaveis
        if (partida.length() == 4) {
            minutoP = Integer.parseInt(partida.substring(2));
            horaP = Integer.parseInt(partida.substring(0, 2));
        } else {
            minutoP = Integer.parseInt(partida.substring(1));
            horaP = Integer.parseInt(partida.substring(0, 1));
        }

        if (chegada.length() == 3) {
            minutoC = Integer.parseInt(chegada.substring(1));
            horaC = Integer.parseInt(chegada.substring(0, 1));
        } else {
            minutoC = Integer.parseInt(chegada.substring(2));
            horaC = Integer.parseInt(chegada.substring(0, 2));
        }
        //calculo do tempo de duração
        int instanteInicial = horaP * 60 + minutoP;
        int instanteFinal = horaC * 60 + minutoC;
        int duracao;
        //tem uma condição para nao ter numeros negativos
        if (instanteInicial < instanteFinal) {
            duracao = instanteFinal - instanteInicial;
        } else {
            duracao = instanteInicial - instanteFinal;
        }
        //pega o minuto e a hora apos ter calculado
        int duracaoHoras = duracao / 60;
        int duracaoMinutos = duracao % 60;
        //copia os valores para uma string para concatenar eles
        String hora = String.valueOf(duracaoHoras);
        String minuto = String.valueOf(duracaoMinutos);
        hora = hora.concat(minuto);
        //apos concaternar, passa eles para serem retornados
        duracao = Integer.parseInt(hora);
        return duracao;
    }

    public StringBuilder pegarNumerosApenas(String partida) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(partida);

        StringBuilder nroExtraidos = new StringBuilder();
        while (m.find()) {
            nroExtraidos.append(m.group().trim()).append("");
        }
        return nroExtraidos;
    }


}
