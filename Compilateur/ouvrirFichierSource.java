import java.io.IOException;
import java.util.Scanner;


public class ouvrirFichierSource {

	static FichierSource fs = new FichierSource();
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("entrez le nom du fichier a ouvrir");
		String str = sc.nextLine();
		fs.ouvrir(str);
		int i=0;
		while(i < 500){
		System.out.println(fs.lireCaratere());
		i++;
		}
		//fs.fermer();

	}	
}
