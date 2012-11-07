/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les lutins qui sont des monstres.
 * Il s'agit de monstres plut�t b�tes et m�chants, ils sont en g�n�ral tr�s
 * nombreux dans le labyrinthe.
 **/
public class Lutin extends Monstre{

	/**
	 * constructeur vide qui initialise les attributs du lutin
	 */		
	public Lutin (){
		super(); 
		representation = new Representation('L');
		PF=2;
		PM=0;
		PR=1;
		PI=0;
	}
}
