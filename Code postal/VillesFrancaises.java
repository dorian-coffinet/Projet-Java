import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;


/**
 * Cette classe contient le programme permettant de manipuler les différentes méthodes définies
 * @author Anne-Sophie DUHAUT, Dorian COFFINET
 *
 */
public class VillesFrancaises {

	/**
	 * méthode de classe permettant de retourner la liste des VillesDeDepartement pour les 100 départements
	 * @param liste une liste de type LinkedList
	 * @return la liste 
	 */
	public static  LinkedList<VillesDeDepartement> departements(ListeDeVilles liste) {

		liste.trierCode();

		LinkedList<VillesDeDepartement> dep = new LinkedList<VillesDeDepartement>();
		for (int i = 0; i < 100; i++)
			dep.add(new VillesDeDepartement());

		for(Ville ville : liste.getListe()){
			int numDep = (new Integer(ville.getCodePostal())).intValue() / 1000;
			ListeDeVilles ldep = dep.get(numDep - 1);	

			/*Le département i (2 premiers chiffres
			 * du code postal) est rangé à l'indice 
			 * i-1 de la liste
			 */


			ldep.ajoute(ville);
		}

		return dep;

	}


	public static void main (String[]args) throws FileNotFoundException, IOException{

		Scanner sc = new Scanner(System.in);
		int choix;
		int dep;
		ListeDeVilles l= new ListeDeVilles();					//création d'une liste de villes vide

		l.charger("codePost.txt");								//chargement des données du fichier "codePost.txt"

		LinkedList<VillesDeDepartement> l1=departements(l);		
		/*
		 * appel à la méthode static departements(l)
		 * qui renvoie une un objet de type LinkedList
		 */



		System.out.println(" (*)Avant de d�rouler le menu, sur quel departement voulez vous des informations? ");
		dep=sc.nextInt();

		//demande � l'utilisateur le d�partement voulu

		VillesDeDepartement vdep = l1.get(dep-1);	

		/* appel à la méthode get(dep-1) qui renvoie un objet
		 * de type VillesDeDepartement, c'est-à-dire
		 * la liste de toutes les villes du département dep
		 */




		choix = -1;

		while(choix != 0){
			System.out.println("Menu :");
			System.out.println(" (0) Quitter");
			System.out.println(" (1) Afficher les 20 premières villes de France triées par code postal.");
			System.out.println(" (2) Afficher les 20 premières villes de France triées par nom.");			
			System.out.println(" (3) Afficher toutes les villes du département "+ dep +".");
			System.out.println(" (4) Afficher les 20 premières villes du département "+dep +".");
			System.out.println(" (5) Afficher toutes les villes du departement " + dep +" partageant leur code postal avec au moins une autre ville.");

			choix=sc.nextInt();

			switch(choix){
			case 1:
				l.trierCode();
				l.afficher(20);
				break;
			case 2:
				l.trierNom();
				l.afficher(20);
				break;
			case 3:
				for (Ville v : vdep.getListe()){
					System.out.println(v);
				}	
				break;
			case 4:	
				vdep.afficher(20);
				break;
			case 5:
				ListeDeVilles t=vdep.memeCode();
				for (Ville v : t.getListe()){
					System.out.println(v);
				}
				break;


			}
		}
	}
}


