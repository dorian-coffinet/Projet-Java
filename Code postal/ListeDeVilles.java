import java.io.*;
import java.util.*;


/**
 * Cette classe représente le fichier complet "codePost.txt" comme une liste chaînée
 * @author Anne-Sophie DUHAUT, Dorian COFFINET
 *
 */
public class ListeDeVilles {

	/**
	 * liste représentant le fichier de codes postaux
	 */
	private LinkedList<Ville> liste;

	/**
	 * crée une liste de villes vide
	 */
	public ListeDeVilles(){
		liste=new LinkedList<Ville>();
	}

	/**
	 * lit un fichier de codes postaux et de le stocke en mémoire
	 * @param fichier le fichier de codes postaux
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void charger(String fichier) throws FileNotFoundException, IOException{
		try{
			BufferedReader f=new BufferedReader(new FileReader(fichier));
			StringTokenizer st;
			String ligne;
			while((ligne = f.readLine()) != null){
				st=new StringTokenizer(ligne,"\t");
				liste.add(new Ville(st.nextToken(), st.nextToken()));
			}
			f.close();
		}catch (FileNotFoundException e) {
			System.out.println("probleme a l'ouverture du fichier");
		}catch (IOException e) {
			System.out.println("probleme en lecture ou ecriture");
		}catch (Exception e) {
			System.out.println("Exception inconnue");
			e.printStackTrace();
		}
	}

	/**
	 * retourne la liste représentant le fichier de codes postaux
	 * @return
	 */

	/* 
	 * cela est nécessaire car cette classe n'hérite pas de LinkedList mais elle utilise un objet
	 * de ce type. Je dois donc définir
	 * cette méthode qui sera très utile dans le programme principal (exemple : on ne peut pas itérer sur un objet 
	 * de type ListeDeVilles mais on peut sur un objet de type LinkedList, je dois donc pouvoir accéder 
	 * à l'attribut liste, de type LinkedList , de ma classe)
	 */

	public LinkedList<Ville> getListe(){
		return liste;
	}

	/**
	 * affiche à l'écran les n premiers éléments de la liste, ou tous les éléments si n vaut 0
	 * @param n les n premiers éléments
	 */
	void afficher(int n){

		if(n==0){
			n=liste.size();
		}

		for(int i=0;i<n;i++)					
			System.out.println(liste.get(i));

	}

	/**
	 * permet de trier les différentes villes selon leur code postal (tri ascendant)
	 */
	public void trierCode(){
		Collections.sort(liste, new CodeComparator());
	}

	/**
	 *  permet de trier suivant l’ordre alphabétique des noms de ville (tri ascendant)

	 */
	public void trierNom(){
		Collections.sort(liste, new NomComparator());
	}

	/**
	 * permet d'ajouter une ville dans la liste
	 * @param v ville à ajouter
	 */

	/*
	 * cela est nécessaire car cette classe n'hérite pas de LinkedList mais elle l'utilise. Je n'ai
	 * donc pas accès à la méthode add() de la classe LinkedList je dois donc en définir une autre.
	 */

	public void ajoute(Ville v){
		liste.add(v);
	}

	/*
	 * cela est nécessaire car cette classe n'hérite pas de LinkedList mais elle l'utilise. Je n'ai
	 * donc pas accès à la méthode contains() de la classe LinkedList je dois donc en définir une autre.
	 */

	public boolean contient(Ville v){
		return(liste.contains(v));

	}

	/**
	 * permet de construire la liste de villes paratgeant leur code postal avec au moins une autre ville
	 * @return la liste de villes
	 */
	public ListeDeVilles memeCode(){
		ListeDeVilles l=new ListeDeVilles();
		LinkedList<Ville> lk=new LinkedList<Ville>();
		lk=this.getListe();

		for(Ville v : lk){
			for(Ville v1 : lk){

				if((v.getCodePostal().compareTo(v1.getCodePostal()))==0){
					if((v.getNom().compareTo(v1.getNom()))!=0){
						if(!(l.contient(v))  )
							l.ajoute(v);
						if(!l.contient(v1))	
							l.ajoute(v1);
					}
				}		
			}	
		}




		return l;	
	}
}










