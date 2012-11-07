
public class SudokuAll {
	
	private char[][] grille;
	
	private int nbSolutions;
	
	private boolean parametre1=false;
	
	public SudokuAll(String[] s1){
		int longueur=0;
		if(s1[0].compareTo("-test")==0){
			for(int p=0;p<s1.length-1;p++){
				s1[p]=s1[p+1];
			}
			longueur=28;
			parametre1=true;
		}
		if(longueur==28){
			if(s1.length != 28)
				System.out.println("Liste de chiffres invalide");
		}else{
			if(s1.length != 27)
				System.out.println("Liste de chiffres invalide");
		}
		grille=new char[9][9];

		int k=0;
		char c;
		int i=0;
		while(i<9){
			int j= 0;
			while(j<9){
				if(k != 27){
					String sg = null;
					if(k != s1.length){
						sg=s1[k];
						for(int g=0;g<3;g++){
							c=sg.charAt(g);
							if(c=='0')
								grille[i][j]=' ';
							else
								grille[i][j]=c;
							
							j++;
						}
					}
					k++;
				}
			}
			i++;
		}
		nbSolutions=0;
	}
	
	public void affichage(){

		for (int i=0; i<9; i++){
			if(i==0 || i%3==0)
				System.out.println(" -------------------- ");

			for (int j=0; j<9; j++){
				if(j==0 || j%3==0)
					System.out.print("|");
				System.out.print(grille[i][j]+" ");
				if(j==8)
					System.out.print("|");
			}
			System.out.println();
			if(i==8)
				System.out.println(" -------------------- ");
		}

	}
	
	public void affichage2(){
		System.out.println("Solution "+nbSolutions);
		for (int i=0; i<9; i++){
			if(i==0 || i%3==0)
				System.out.println(" -------------------- ");

			for (int j=0; j<9; j++){
				if(j==0 || j%3==0)
					System.out.print("|");
				System.out.print(grille[i][j]+" ");
				if(j==8)
					System.out.print("|");
			}
			System.out.println();
			if(i==8)
				System.out.println(" -------------------- ");
		}

	}
	
	public boolean estDansCarre(int i, int j, char c){
		boolean res=false;
		int ligne=0;
		int colonne=0;
		int initialisation1=0;
		int initialisation2=0;
		if(i<3){
			initialisation1=0;
			ligne=3;
		}else{
			if(i<6){
				ligne=6;
				initialisation1=3;
			}else{
				ligne=9;
				initialisation1=6;
			}
		}
		if(j<3){
			initialisation2=0;
			colonne=3;
		}else{
			if(j<6){
				initialisation2=3;
				colonne=6;
			}else{
				initialisation2=6;
				colonne=9;

			}
		}

		for(int k=initialisation1;k<ligne;k++){
			for(int z=initialisation2;z<colonne;z++){
				if(grille[k][z]==c)
					res=true;

			}
		}
		return res;

	}

	public boolean estDansLigne(int ligne,char c){
		boolean estdansligne=false;
		int k = 0;
		while(k<9){
			if ( grille[ligne][k]==c){
				estdansligne=true;
				k=10;
			}else{
				k++;
			}
		}	
		return estdansligne;

	}
	public boolean estDansColonne(int colonne,char c){
		boolean estdanscolonne=false;
		int k = 0;
		while(k<9){
			if ( grille[k][colonne]==c){
				estdanscolonne=true;
				k=10;
			}else{
				k++;
			}
		}	
		return estdanscolonne;

	}
	
	public void remplirGrille(int i,int j){
		
		if(i>8){
			nbSolutions++;
			if(!parametre1)
				affichage2();
		}else{
			
			int k=1;
			if(grille[i][j]==' '){
				

				while(k<10){
					String chaine = Integer.toString(k);
					char car = chaine.charAt(0);
					if(!estDansLigne(i,car) && !estDansColonne(j,car) && !estDansCarre(i,j,car)){
						grille[i][j]=car;
						if(j==8)
							remplirGrille(i+1,0);
						else
							remplirGrille(i,j+1);
						grille[i][j]=' ';
					}
					k++;
				}
			}else{
				if(j==8)
					remplirGrille(i+1,0);
				else
					remplirGrille(i,j+1);
			}
		}
		
	}
	
	public static void main(String[] args){



		if(args[0].compareTo("-test")==0){
			SudokuAll s=new SudokuAll(args);
			s.remplirGrille(0,0);
			System.out.println("Il y a "+s.nbSolutions+" solution(s)");
		}else{
			SudokuAll s=new SudokuAll(args);
			s.affichage();
			s.remplirGrille(0,0);
			
		}


	}



}
