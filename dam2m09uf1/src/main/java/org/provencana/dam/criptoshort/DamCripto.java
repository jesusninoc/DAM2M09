package org.provencana.dam.criptoshort;

import java.util.Arrays;

public class DamCripto {

    private String clau;
    private String missatgeEntrada;
    private String missatgeSortida;
    private int[] ordinal;


    public String getClau() {
        return clau;
    }

    public void setClau(final String clau) {
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

    public int[] getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(final int[] ordinal) {
        this.ordinal = ordinal;
    }

    public static void main(final String[] args) {

        DamCripto damCripto = new DamCripto();

        damCripto.setClau("MAGNOLIW");
        damCripto.setMissatgeEntrada("aquest es el meu missatge");
        damCripto.setMissatgeSortida("");
        damCripto.encripta();
        System.out.println(damCripto.toString());

        damCripto.setClau("MAGNOLIW");
        damCripto.setMissatgeEntrada("q m ueia etetmadas eelsbs sceugf'");
        damCripto.setMissatgeSortida("");
        damCripto.desencripta();
        System.out.println(damCripto.toString());

    }

    private Boolean encripta() {
        fillOrdinals();
        encriptaEntrada();
        return Boolean.TRUE;
    }

    private Boolean desencripta() {
        fillOrdinals();
        desencriptaEntrada();
        return Boolean.TRUE;
    }

    private void fillOrdinals() {
        int i, j, k;
        String a = clau;
        k = a.length();
        ordinal = new int[k];
        char[] clauordenada = clau.toCharArray();
        Arrays.sort(clauordenada);
        for (i = 0; i < k; i = i + 1) {
            for (j = 0; j < k; j = j + 1) {
                if (a.charAt(j) == clauordenada[i]) {
                    ordinal[i] = j;
                }
            }
        }
    }

    private void encriptaEntrada() {
        int i, j, k;
        String a = clau;
        String r = "";
        k = a.length();
        i = (int) (missatgeEntrada.length() / k);
        j = missatgeEntrada.length() - i * k;
        char b[] = (missatgeEntrada + " abcdefghijklmnopqrstuvwxyz".substring(0, k - j)).toCharArray();

        for (i = 0; i < k; i = i + 1) {
            for (j = 0; j < b.length / k; j = j + 1) {
                r = r + b[j * k + ordinal[i]];
            }
        }
        missatgeSortida = r;
    }

    private void desencriptaEntrada() {
        int i, j, k, leni;
        String r = "";
        String a = clau;
        k = a.length();
        leni = (int) (missatgeEntrada.length() / k);
        char b[] = new char[k * leni];

        for (i = 0; i < leni; i = i + 1) {
            for (j = 0; j < k; j = j + 1) {
                b[i * k + ordinal[j]] = missatgeEntrada.charAt(j * leni + i);
            }
        }
        missatgeSortida = getStringFromArrayChar(b);
    }

    private String getStringFromArrayChar(char[] a) {
        String r = "";
        for (int i = 0; i < a.length; i++) {
            r = r + a[i];
        }
        return r;
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
