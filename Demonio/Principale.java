/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente le main dans lequel on test le jeu
 **/
import java.util.*;
import java.lang.*;
import java.io.*;
public class Principale {


	private static Labyrinthe laby;
	private static final int dim_x =30;
	private static final int dim_y =30;
	private static ArrayList<Acteurs> liste_d_acteur;
	private static ArrayList<Acteurs> liste_monstre;

	private static void initialisation(int nb_m,int hero){
		laby = new Labyrinthe (dim_x, dim_y);

		liste_d_acteur = new ArrayList<Acteurs>();
		int h_X =  (int)(Math.random()*29+1);
		int h_Y = (int)(Math.random()*29+1);
		Position p =new Position(h_X,h_Y);

		switch(hero){
		case 1:
			Acteurs heros1 = new Amazone();
			heros1.setPosition_dans_labyrinthe(p);
			liste_d_acteur.add(heros1);
			laby.changerCase(p, heros1);
			System.out.println("Héro créé : Amazone représentée par #");

			break;
		case 2:
			Acteurs heros2 = new Guerrier();
			heros2.setPosition_dans_labyrinthe(p);
			liste_d_acteur.add(heros2);
			laby.changerCase(p, heros2);
			System.out.println("Héro créé : Guerrier représenté par @");
			break;
		case 3:
			Acteurs heros3 = new Magicien();
			heros3.setPosition_dans_labyrinthe(p);
			liste_d_acteur.add(heros3);
			laby.changerCase(p, heros3);
			System.out.println("Héro créé : Magicien représenté par M");
			break;
		case 4:
			Acteurs heros4 = new Troubadour();
			heros4.setPosition_dans_labyrinthe(p);
			liste_d_acteur.add(heros4);
			laby.changerCase(p, heros4);
			System.out.println("Héro créé : Troubadour représenté par $");
			break;


		}

		liste_monstre = new ArrayList<Acteurs>();
		boolean b=true;
		for(int i =0; i<nb_m; i++){

			int type_monstre= (int)(Math.random()*4+1);

			int X =  (int)(Math.random()*29+1);
			int Y = (int)(Math.random()*29+1);

			if (type_monstre==1 && b==true){
				Acteurs m1 = new Ballrog();
				Position p1 = new Position(X,Y);
				m1.setPosition_dans_labyrinthe(p1);
				liste_monstre.add(m1);
				laby.changerCase(p1,m1);
				b=false;

			}else{
				switch(type_monstre){

				case 1 :	
					Acteurs m1 = new Lutin();
					Position p1 = new Position(X,Y);
					m1.setPosition_dans_labyrinthe(p1);
					liste_monstre.add(m1);
					laby.changerCase(p1,m1);

					break;
				case 2 : 
					Acteurs m2 = new Fisk();
					Position p2 = new Position(X,Y);
					m2.setPosition_dans_labyrinthe(p2);
					liste_monstre.add(m2);
					laby.changerCase(p2,m2);

					break;
				case 3 : 
					Acteurs m3 = new Orc();
					Position p3 = new Position(X,Y);
					m3.setPosition_dans_labyrinthe(p3);
					liste_monstre.add(m3);
					laby.changerCase(p3,m3);
					break;
				case 4 :
					Acteurs m4 = new Chikungunya();
					Position p4 = new Position(X,Y);
					m4.setPosition_dans_labyrinthe(p4);
					liste_monstre.add(m4);
					laby.changerCase(p4,m4);

					break;

				default:
					System.out.println("erreur");


				}

			}
		}
		laby.afficherLabyrinthe();


	}



	public static void main(String[]args){
		Scanner scn;
		scn= new Scanner(System.in);
		System.out.println();
		System.out.println("Quel hero voulez vous? Tappez le choix correspondant ");
		System.out.println("(0) Quitter");
		System.out.println("(1) Amazone ");
		System.out.println("(2) Guerrier");
		System.out.println("(3) Magicien");
		System.out.println("(4) Troubadour");
		int type_heros=scn.nextInt();



		System.out.println();
		System.out.print("Combien voulez vous de monstres? ");
		int nb_monstre=scn.nextInt();
		System.out.println();	

		int dir =-1;
		initialisation(nb_monstre,type_heros);


		boolean game_over=false ;

		int choix = -1;
		while(game_over==false){

			System.out.println();
			System.out.print("Deplacer le heros(Pour sortir du jeu tapez 0)");
			System.out.println();
			dir = scn.nextInt();

			if(dir==0){
				System.out.println("Fin du jeu retour au menu");
				game_over=true;
			}else{

				for (Acteurs act : liste_d_acteur)
					act.seDeplacer(dir, laby, act);
				for (Acteurs monstre : liste_monstre){
					int alea= (int)(Math.random()*9+1);
					monstre.seDeplacer(alea,laby,monstre);
				}
				laby.afficherLabyrinthe();
			}

		}



		while(choix != 0){
			System.out.println("Menu :");
			System.out.println(" (0) Quitter");
			System.out.println(" (1) Sauvegarder votre jeu");
			System.out.println(" (2) Charger une ancienne partie");
			choix=scn.nextInt();

			switch(choix){
			case 1:
				System.out.println("Sauvegarde...");
				break;
			case 2:
				System.out.println("Chargement...");
				break;

			}
		}
	}

}








