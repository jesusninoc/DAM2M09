package org.provencana.dam.cripto;

import java.io.File;
import java.util.Arrays;

public class DamCripto {

    private String[] args;
    private StrFromFile clau;
    private StrFromFile missatgeEntrada;
    private StrFromFile missatgeSortida;
    private int[] ordinal;


    public DamCripto(final String[] args) {
        this.args = args;
        clau = new StrFromFile();
        missatgeEntrada = new StrFromFile();
        missatgeSortida = new StrFromFile();
    }

    public static void main(final String[] args) {

        DamCripto damCripto = new DamCripto(args);
        Boolean resultat = Boolean.FALSE;

        if (damCripto.verifyArgs()) {

            switch (args[0]) {
                case "-e":
                    resultat = damCripto.encripta();
                    break;

                case "-d":
                    resultat = damCripto.desencripta();
                    break;
            }
        }

        if (resultat) {
            System.out.println(damCripto.toString());
        }
    }

    private Boolean verifyArgs() {

        if (!verificaNumeroArguments()) {
            return Boolean.FALSE;
        }

        if (!verificaPrimerArgument()) {
            return Boolean.FALSE;
        }

        if (!verificaSegonArgument()) {
            return Boolean.FALSE;
        }

        if (!verificaTercerArgument()) {
            return Boolean.FALSE;
        }

        if (!obtenirClau()) {
            return Boolean.FALSE;
        }

        if (!verificaClau()) {
            return Boolean.FALSE;
        }

        if (!obtenirMissatgeEntrada()) {
            return Boolean.FALSE;
        }


        return Boolean.TRUE;
    }

    private boolean verificaNumeroArguments() {
        if (args.length != 4) {
            printUse();
            return false;
        }
        return true;
    }


    private boolean verificaPrimerArgument() {
        if (!args[0].equals("-e") && !args[0].equals("-d")) {
            printUse();
            System.out.println(" el primer paràmetre ha de ser o bé -e o bé -d");
            return false;
        }
        return true;
    }

    private boolean verificaSegonArgument() {
        if (!isFile(args[1])) {
            printUse();
            System.out.println(" el segon paràmetre ha de ser un fitxer amb la clau");
            return false;
        }
        return true;
    }

    private boolean verificaTercerArgument() {
        if (!isFile(args[2])) {
            printUse();
            System.out.println(" el tercer paràmetre ha de ser un fitxer amb el missatge d'entrada");
            return false;
        }
        return true;
    }

    private boolean obtenirClau() {
        if (!getClau()) {
            printUse();
            System.out.println(" no s'ha pogut llegir la clau");
            return false;
        }
        return true;
    }

    private boolean verificaClau() {
        if (!verifyKey()) {
            printUse();
            System.out.println(" la clau no pot ser buida i no pot contenir caràcters repetits");
            return false;
        }
        return true;
    }

    private boolean obtenirMissatgeEntrada() {
        if (!getMissatgeEntrada()) {
            printUse();
            System.out.println(" no s'ha pogut llegir el missatge d'entrada");
            return false;
        }
        return true;
    }

    private static void printUse() {
        System.out.println("ús: { -e | -d }  <fitxerClau> <fitxerIn> <fitxerOut>   ");
    }

    private static Boolean isFile(final String file) {
        File f = new File(file);
        if (f.exists() && !f.isDirectory()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean getClau() {
        final Boolean r;
        r = clau.setStrFromFile(args[1]);
        return r;
    }

    private Boolean getMissatgeEntrada() {
        final Boolean r;
        r = missatgeEntrada.setStrFromFile(args[2]);
        return r;
    }


    public Boolean verifyKey() {
        if (!clau.getStr().isEmpty()) {
            if (!hasRepeatedCharacters()) {
                return Boolean.TRUE;
            }
        }
        System.out.println("La clau te caràcters repetits !!!");
        return Boolean.FALSE;
    }

    public Boolean hasRepeatedCharacters() {
        int i, j, k;
        char a;
        String key = clau.getStr();
        k = key.length();
        for (i = 0; i < k; i = i + 1) {
            a = key.charAt(i);
            for (j = i + 1; j < k; j = j + 1) {
                if (a == key.charAt(j)) {
                    return Boolean.TRUE;
                }
            }
        }

        return Boolean.FALSE;
    }

    public Boolean encripta() {
        fillOrdinals();
        encriptaEntrada();
        return missatgeSortida.setFileFromStr(args[3]);
    }

    public Boolean desencripta() {
        fillOrdinals();
        desencriptaEntrada();
        return missatgeSortida.setFileFromStr(args[3]);
    }


    public void fillOrdinals() {
        int i, j, k;
        String a = clau.getStr();
        k = a.length();
        ordinal = new int[k];
        char[] clauordenada = clau.getStr().toCharArray();
        Arrays.sort(clauordenada);
        for (i = 0; i < k; i = i + 1) {
            for (j = 0; j < k; j = j + 1) {
                if (a.charAt(j) == clauordenada[i]) {
                    ordinal[i] = j;
                }
            }
        }
    }

    public void encriptaEntrada() {
        int i, j, k;
        String a = clau.getStr();
        String r = "";
        k = a.length();
        i = (int) (missatgeEntrada.getStr().length() / k);
        j = missatgeEntrada.getStr().length() - i * k;
        char b[] = (missatgeEntrada.getStr() + " abcdefghijklmnopqrstuvwxyz".substring(0, k - j)).toCharArray();

        for (i = 0; i < k; i = i + 1) {
            for (j = 0; j < b.length / k; j = j + 1) {
                r = r + b[j * k + ordinal[i]];
            }
        }
        missatgeSortida.setStr(r);
    }

    private void desencriptaEntrada() {
        int i, j, k, leni;
        String r = "";
        String a = clau.getStr();
        k = a.length();
        leni = (int) (missatgeEntrada.getStr().length() / k);
        char b[] = new char[k * leni];

        for (i = 0; i < leni; i = i + 1) {
            for (j = 0; j < k; j = j + 1) {
                b[i * k + ordinal[j]] = missatgeEntrada.getStr().charAt(j * leni + i);
            }
        }
        missatgeSortida.setStr(getStringFromArrayChar(b));
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
                "clau=" + clau +
                ", missatgeEntrada=" + missatgeEntrada +
                ", missatgeSortida=" + missatgeSortida +
                '}';
    }

}
