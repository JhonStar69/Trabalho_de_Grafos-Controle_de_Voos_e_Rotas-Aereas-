package tad;

import java.util.ArrayList;

public class Aeroporto {
    String nomeAero;
    int fusoHorario;
    int xCoordenada;
    int yCoordenada;

    public String getNomeAero() {
        return nomeAero;
    }

    public void setNomeAero(String nomeAero) {
        this.nomeAero = nomeAero;
    }

    public int getFusoHorario() {
        return fusoHorario;
    }

    public void setFusoHorario(int fusoHorario) {
        this.fusoHorario = fusoHorario;
    }

    public int getxCoordenada() {
        return xCoordenada;
    }

    public void setxCoordenada(int xCoordenada) {
        this.xCoordenada = xCoordenada;
    }

    public int getyCoordenada() {
        return yCoordenada;
    }

    public void setyCoordenada(int yCoordenada) {
        this.yCoordenada = yCoordenada;
    }

    public void imprimirInformacoesAeroporto(ArrayList<Aeroporto> infAeroporto) {
        System.out.println("\nAbreviação do aeroporto    Fuso horário   Coordenada X Coordenada Y");
        for (int i = 0; i < infAeroporto.size(); i++) {
            System.out.print("N "+i+": " + infAeroporto.get(i).getNomeAero() +
                    " ," + infAeroporto.get(i).getFusoHorario() +
                    " ," + infAeroporto.get(i).getxCoordenada() +
                    " ," + infAeroporto.get(i).getyCoordenada());
            System.out.println();

        }
    }
    public void imprimirInformacoesVoo(ArrayList<Voo> infVoo) {
        System.out.println("Voo, aeroporto de origem, Hora de partida, Aeroporto de destinol Tempo de chegada, Paradas");
        for (int i = 0; i < infVoo.size(); i++) {
            System.out.print(" " + infVoo.get(i).getVoo() +
                    " ," + infVoo.get(i).getAeroportoOrigem() +
                    " ," + infVoo.get(i).getHoraPartida() +
                    " ," + infVoo.get(i).getAeroportoDestino()+
                    " ," + infVoo.get(i).getHoraChegada() +
                    " ," + infVoo.get(i).getParadasVoo()
            );
            System.out.println();
        }
    }



}
