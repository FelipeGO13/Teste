package TesteLogica2;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class testeLogica2 {
	Timer timer;
	Double tempoTotal = 0.0;

	public testeLogica2() {
	    timer = new Timer();
	    timer.schedule(new CalculadoraDecaimento(),
	                   0,        //initial delay
	                   1*30000);  //subsequent rate
	    System.out.println(tempoTotal);
	    	    
	}

	class CalculadoraDecaimento extends TimerTask {
	    Double massaMinima = 0.10;
	    Scanner s = new Scanner(System.in);
	
		Double massa = s.nextDouble();
	    
	    public void run() {
	        if (massa >= massaMinima) {
	            massa -= massa * 0.25;
	            tempoTotal += 30.0;
	            System.out.println("Tempo total: " + tempoTotal);
	        } else {
	          
	            timer.cancel(); 
	        }
	    }
	}
	
    public static void main(String args[]) {
    System.out.println("Insira a massa do material.");
        new testeLogica2();
    }
}
