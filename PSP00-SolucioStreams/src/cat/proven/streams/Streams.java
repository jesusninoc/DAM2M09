/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class Streams {

    
    
      /* ------- attributes, properties or fields ------- */
    
    /* the options in the main menu of the application 
     * (i.e. the functional requirements) */
     private final String [] mainMenuOptions = {
             "Exit",     
             "Exercici 1", 
             "Exercici 2",
             "Exercici 3", 
             "Exercici 4",
             "Exercici 5",
             "Exercici 6",
      };
    
     /**
     * main(). 
     * Starts up application execution.
     */
    public static void main(String[] args) {
               
        /* application object */
	Streams myAp = new Streams();
	/* run the application */
	myAp.run();
		
        
    }
        	
    /* -------------- methods -------------- */
    
    /** run()
     * runs the application in non-static mode.
     */	
    private void run() {	
        /* exit flag */
		boolean seguir = true;
		/* menu option to execute */
		int option;
		/* read initial data from persistent storage and/or initialize data*/
		loadData();
		/* user service loop  */
		do {
			//show menu and get option
			option = showMainMenu();
			//control block
			switch (option) {
				case 0: //exit
					seguir = false;  //set the exit flag.
					break;
				case 1: 
					exercici1();
					break;
				case 2: 
					exercici2();
					break;
				case 3: 
					exercici3();
					break;
                                case 4:
                                        exercici4();
                                        break;
                                case 5:
                                        exercici5();
                                        break;
                                case 6:
                                        exercici6();
                                        break;
				default: //default or invalid option
					alert("Invalid option\n");
					break;
			}
		} while (seguir);
		/* save data to persistent storage */
		saveData();
		alert("Closing application ...\n");
        
    }
    
    
      /** showMainMenu()
     * shows the application main menu and gets user's option
     * @return option to execute
     */
     private int showMainMenu() {
		int option=-1;	//option to return	
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("\n===== Main menu =====");
			for (int i=0; i<mainMenuOptions.length; i++) {
				System.out.format("\n(%d) %s", i, mainMenuOptions[i]);
			} 
			System.out.print("\n=============================");
			System.out.print("\nEnter option: ");
			option = scan.nextInt();
		} catch (InputMismatchException ime) {
			option = -1;
		}
		return option;
	}
     
    /** alert()
     * shows a message
     * @param String msg: message to show
     */
     private void alert(String msg) {
	System.out.print(msg);
     }
     
    /** loadData()
     * loads and initializes data
     */
     private void loadData() {
	//TODO
        alert("Loading data ...\n");
    }	
     
    /** saveData()
     * saves data
     */
     private void saveData() {
        //TODO
        alert("Saving data ...\n");
    }
     
          
     
     
     /* EXERCICIS */
     
     /**
      * Resolució de l'exercici 1
      * Entrar una frase i retorna per pantalla amb System.in i System.out
      */
     private void exercici1()
     {
    
        int c;
        String entrada= "";

        System.out.println("Entra una frase:");  
        try
        {  
            while ((c=System.in.read())!='\n')
            {
               entrada+=(char)c;
            }
        } 
        catch(IOException ex)
        {
             ex.printStackTrace();
             ex.getLocalizedMessage();
        }
        
        System.out.println("Has escrito:");  
        System.out.println(entrada);
     }
     
     /**
      * Resolució de l'exercici 2
      * Llegeix de teclat i mostra codificació entera
      */
     private void exercici2()
     {
     
        int c;
        String salida= "";
        
        System.out.println("Entra una frase:");  
        try
        {  
            while ((c=System.in.read())!='\n')
            {
               salida=(char)c + "=" + c;
               System.out.println(salida);
            }
        } 
        catch(IOException ex)
        {
             ex.printStackTrace();
        }
                  
     }
     
     
     /**
      * Resolució de l'exercici 3
      * Mostra un fitxer llegint amb FileReader
      */
     private void exercici3()
     {
     
         String linea="";
        try
        {
        
        FileReader f = new FileReader("files" + File.separator + "entrada.txt");
        int c;
        
        while ((c=f.read())!= -1)
        {
            if ((char)c!='\n')
              linea+=(char)c;
            else   
            {  
                System.out.println(linea);
                linea="";
            }
        }
        System.out.println(linea);
        f.close();
        }
        catch(IOException ex)
        {
             ex.printStackTrace();
        }
    
     }
     
     /**
      * Resolució de l'exercici 3 Solució amb BufferedReader
      * Mostra un fitxer llegint amb BufferedReader
      */
     private void exercici3(boolean Alternatiu)
     {
      try
        {    
             
            FileReader f = new FileReader("files" + File.separator + "entrada.txt");
            BufferedReader entrada =new BufferedReader(f);

            String linea;

            while((linea=entrada.readLine())!=null)
            {
                System.out.println(linea);
            }
            entrada.close();
        }
        catch (IOException e)
        {
             e.printStackTrace();
        }
     }
     
      /**
      * Resolució de l'exercici 4
      * Demana una frase per teclat i l'escriu en un fitxer
      */
     private void exercici4()
     {
        int c;
        String salida= "";
        try
        { 
        
        
        FileWriter f = new FileWriter("files" + File.separator + "sortida.txt");

        // Si volem afegir al contingut:
        //FileWriter f = new FileWriter("C:\\fitxer.txt",true);

        System.out.println("Entra una frase:");  

        while ((c=System.in.read())!='\n')
        {
            salida+=(char)c;
        }

        f.write(salida);
        f.close();

        } 
        catch(IOException ex)
        {
             ex.printStackTrace();
        }

     }
     
     /**
      * Resolució de l'exercici 5
      *  Copia el contingut d'un fitxer a un altre caràcter a caràcter
      */
     private void exercici5()
     {
        int c;
    
        try
        { 
            
            FileReader Entrada = new FileReader("files" + File.separator + "entrada.txt");
            FileWriter Sortida = new FileWriter("files" + File.separator + "sortida.txt");

            while ((c=Entrada.read())!=-1)
            {
                Sortida.write((char)c);
            }

            Entrada.close();
            Sortida.close();

        } 
        catch(IOException ex)
        {
             ex.printStackTrace();
        }
     }
     
     /**
      * Resolució de l'exercici 6
      * Copiar un fitxer binari
      */
     private void exercici6()
     {
        try
        {

           
           FileInputStream fI = new FileInputStream("files" + File.separator +"input.jpg");
           FileOutputStream fO = new FileOutputStream("files" + File.separator + "output.jpg");

            int c;

            while ((c=fI.read())!=-1)
            {
                fO.write(c);
            }

            fI.close();
            fO.close();

        }   
        catch (Exception e)
        {
              e.printStackTrace();

        }
     }

}
