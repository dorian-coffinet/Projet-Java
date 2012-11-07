import java.io.*;
import java.util.Scanner;


public class FichierSource {

	private BufferedReader fichier;
	private String ligne;
	private char charac;
	private int c = 0;

	public void ouvrir (String nom){
		try{

			fichier = new BufferedReader(new FileReader(nom));

		} catch (IOException ioe) {

			System.out.println("Erreur " + ioe.toString());
		}

	}
	public void fermer (){
		try {
			fichier.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public char lireCaratere() throws IOException{
		
		int c = fichier.read();
		
		
			charac=(char)c;
			if(c!=-1)
				System.out.print(charac);
			c++ ;
			

		
		return charac;
	}
	
	
}


