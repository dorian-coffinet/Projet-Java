/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les chikungunya qui sont des monstres.
 * Ils sont assez difficiles � battre. Pour des monstres ils sont relativement rus�s
 * et ils poss�dent des pouvoirs magiques qui peuvent s'av�rer redoutables.
 **/
public class Chikungunya extends Monstre{

	/**
	 * constructeur vide qui initialise les attributs de Chikungunya
	 */	
	public Chikungunya (){
		super(); 
		representation = new Representation('C');
		PF=4;
		PM=5;
		PR=1;
		PI=2;
	}


}

