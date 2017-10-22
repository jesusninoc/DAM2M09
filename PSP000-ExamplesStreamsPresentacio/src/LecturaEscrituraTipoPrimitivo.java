
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Exemple ús DataStream per llegir Double d'un ftxer
 * 
 * DataStream te metodes per obtenir els tipus primitius (Boolean, Double,..)
 * 
 * @author alumne
 */
public class LecturaEscrituraTipoPrimitivo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //escribim un Double en un fitxer
        FileOutputStream ficheroSalida = new FileOutputStream("fitxers" + File.separator +"preus.cat");
        DataOutputStream salida = new DataOutputStream(ficheroSalida);
        salida.writeDouble(234.56);
        salida.flush(); //força l'escriptura del fitxer
        salida.close();

        //ara el llegim
        FileInputStream ficheroEntrada = new FileInputStream("fitxers" + File.separator +"preus.cat");
        DataInputStream entrada = new DataInputStream(ficheroEntrada);
        double preu = entrada.readDouble();
        System.out.println("preu: " + preu);
        entrada.close();
    }
}
