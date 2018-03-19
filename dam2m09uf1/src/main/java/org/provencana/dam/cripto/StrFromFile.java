package org.provencana.dam.cripto;

import java.io.*;

public class StrFromFile {

    private String str;

    public StrFromFile() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(final String str) {
        this.str = str;
    }

    public Boolean setStrFromFile(final String file) {
        try {
            File f = new File(file);
            FileReader fileReader = new FileReader(f);
            BufferedReader input = new BufferedReader(fileReader);
            this.str = input.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean setFileFromStr(final String file) {
        try {
            FileWriter f = new FileWriter(file);
            f.write(str + "\r\n");
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public String toString() {
        return " StrFromFile{ " +
                " str='" + str + '\'' +
                " }";
    }
}
