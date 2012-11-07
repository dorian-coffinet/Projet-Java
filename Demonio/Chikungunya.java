/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les chikungunya qui sont des monstres.
 * Ils sont assez difficiles à battre. Pour des monstres ils sont relativement rusés
 * et ils possèdent des pouvoirs magiques qui peuvent s'avérer redoutables.
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

