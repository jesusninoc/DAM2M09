package org.provencana.dam.cesar;

public class Cesar {


    private Integer clau;
    private String missatgeEntrada;
    private String missatgeSortida;


    public Integer getClau() {
        return clau;
    }

    public void setClau(final Integer clau) {
        this.clau = clau;
    }

    public String getMissatgeEntrada() {
        return missatgeEntrada;
    }

    public void setMissatgeEntrada(final String missatgeEntrada) {
        this.missatgeEntrada = missatgeEntrada;
    }

    public String getMissatgeSortida() {
        return missatgeSortida;
    }

    public void setMissatgeSortida(final String missatgeSortida) {
        this.missatgeSortida = missatgeSortida;
    }

    public static void main(final String[] args) {

        Cesar damCripto = new Cesar();

        damCripto.setClau(3);
        damCripto.setMissatgeEntrada("aquest es el meu missatge");
        damCripto.setMissatgeSortida("");
        damCripto.encripta();
        System.out.println(damCripto.toString());

        damCripto.setClau(3);
        damCripto.setMissatgeEntrada("dtxhvw#hv#ho#phx#plvvdwjh");
        damCripto.setMissatgeSortida("");
        damCripto.desencripta();
        System.out.println(damCripto.toString());

    }

    private void encripta() {
        int i;
        missatgeSortida = "";

        for (i = 0; i < missatgeEntrada.length(); i = i + 1) {
            missatgeSortida = missatgeSortida + (char) ((int) missatgeEntrada.charAt(i) + clau);
        }
    }

    private void desencripta() {
        int i;
        missatgeSortida = "";

        for (i = 0; i < missatgeEntrada.length(); i = i + 1) {
            missatgeSortida = missatgeSortida + (char) ((int) missatgeEntrada.charAt(i) - clau);
        }
    }

    @Override
    public String toString() {
        return "DamCripto{" +
                "clau='" + clau + '\'' +
                ", missatgeEntrada='" + missatgeEntrada + '\'' +
                ", missatgeSortida='" + missatgeSortida + '\'' +
                '}';
    }
}
