/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.examenselectivitat;

/**
 *
 * @author alumne
 */
public class NotasSeleThread extends Thread {
    
    
    	private int notaMax;
        private int numAlumnesNotaMax;
	private int[] arr; //Array on estaran els valors
	private int start; // On començarem a comprovar
	private int end;   // On pararem de comprovar
        
        public NotasSeleThread(String nom, int[] arr, int start, int end){
                super(nom);
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

        @Override
	public void run(){
		
		notaMax = 0; // Inicialitzem amb el primer valor
                numAlumnesNotaMax=0;
		
		// Recorrem l'array
		for(int i=start; i<=end; i++){

			if (arr[i]>notaMax) {
                            notaMax = arr[i];
                            numAlumnesNotaMax = 1;
                        }
                        else if (arr[i]==notaMax) {
                            numAlumnesNotaMax++;
                        }
                        
		}
                
             System.out.println(getName() + ": " + numAlumnesNotaMax + " alumnes han tret la nota màxima " + notaMax);

	}


	//getter pels resultats del thread
	public int getNotaMax(){
		return this.notaMax;
	}
 
        public int getNumAlumnesNotaMax(){
		return this.numAlumnesNotaMax;
	}
        
}
