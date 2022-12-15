package tad;

import java.util.ArrayList;

public class Voo {

    int voo;
    String aeroportoOrigem;
    String horaPartida;
    String aeroportoDestino;
    String horaChegada;
    int paradasVoo;

    public int getVoo() {
        return voo;
    }

    public void setVoo(int voo) {
        this.voo = voo;
    }

    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public void setAeroportoOrigem(String aeroportoOrigem) {
        this.aeroportoOrigem = aeroportoOrigem;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getAeroportoDestino() {
        return aeroportoDestino;
    }

    public void setAeroportoDestino(String aeroportoDestino) {
        this.aeroportoDestino = aeroportoDestino;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public int getParadasVoo() {
        return paradasVoo;
    }

    public void setParadasVoo(int paradasVoo) {
        this.paradasVoo = paradasVoo;
    }

    public void vooDiretoSemPausa(ArrayList<Voo> infVoo, int aero) {
        //5.2. Mostrar, a partir de um aeroporto definido, quais os voos diretos (sem escalas e/ou
        //conexões) que partem dele e a lista desses destinos.
        Rotas rotas = new Rotas();
        System.out.println("\nLista de voos que parte de " + aero + " " + rotas.converterRotasNomes(aero));
        System.out.println("ID - AEROPORTO SAIDA - HORA SAIDA - AEROPORTO CHEGADA - HORA CHEGADA - PARADAS");


        for (Voo value : infVoo) {

            if (aero == rotas.converterRotasNumeros(value.getAeroportoOrigem())) {
                if (value.getParadasVoo() == 0) {
                    System.out.println("\n " + value.getVoo() +
                            " ," + value.getAeroportoOrigem() +
                            " ," + value.getHoraPartida() +
                            " ," + value.getAeroportoDestino() +
                            " ," + value.getHoraChegada() +
                            " ," + value.getParadasVoo()
                    );
                }
            }

        }

    }
}
