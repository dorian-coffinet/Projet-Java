import java.io.IOException;
import java.lang.*;
import java.util.Scanner;
import java.util.Set;

public class ALEX {

	private char carcour;
	private int etat;
	private static FichierSource fs;
	private static String fichier;
	private TableDesMotsCles TMC;
	private TableDesSymboles TDS;


	public void initialisation() throws IOException{

		etat=0;
		fs = new FichierSource();
		Scanner sc = new Scanner(System.in);
		System.out.println("entrez le nom du fichier a ouvrir");
		fichier = sc.nextLine();
		fs.ouvrir(fichier);
		carcour=fs.lireCaratere();
		TMC=new TableDesMotsCles();
		TMC.initialisation();
		TDS=new TableDesSymboles();
		
		

	}

	public int[] Alex() throws IOException{
		String s="";
		int []tab=new int[2];
		tab[0]=0;
		tab[1]=-1;
		while (true){


			switch (etat){
			case 0: 
				s="";
				tab=new int[2];
				tab[0]=0;
				tab[1]=-1;
				if (carcour == '\n'|| carcour == ' '|| carcour == '\t'){
					carcour=fs.lireCaratere();
					etat=0;
				}else if(Character.isLetter(carcour)) {
					s=s+carcour;
					etat=1;

				}else if(Character.isDigit(carcour)){
					s=s+carcour;
					etat=3;

				}else if (carcour == '$'){
					carcour=fs.lireCaratere();
					etat=4;

				}else if (carcour == '<'){
					s=s+carcour;
					carcour=fs.lireCaratere();

					etat=6;
				}else if (carcour == '>'){
					s=s+carcour;
					carcour=fs.lireCaratere();

					etat=7;
				}else if (carcour == '{'){
					etat = 8;
				}else if (carcour == '}'){
					etat = 9;
				}else if (!Character.isDefined(carcour)){
					tab[0]=70;
					return(tab);
				}else if(carcour=='.'||carcour=='('||carcour==')'||carcour=='['||carcour==']'||carcour==';'||carcour=='?'||carcour==','||carcour=='&'||carcour=='+'||carcour=='='){
					s=s+carcour;
					carcour=fs.lireCaratere();
					tab[0]=TMC.getValeur(s);
					return(tab);
				}else{
					etat=9;
				}
				
				



				break;

			case 1: 

				if (carcour == '\n'|| carcour == ' '){
					etat=0;
					s=s.substring(0, s.length()-1);
					
					if(TMC.contient(s)){
						tab[0]=TMC.getValeur(s);
						return(tab);
					}else if (TDS.contient(s)){
						
						tab[0]=600;
						tab[1]=TDS.getCle(s);

						return(tab);

					}else{
						TDS.add(s);
						tab[0]=600;
						tab[1]=TDS.getCle(s);
						

						return(tab);
					}
					


				}else if (Character.isLetter(carcour)||(Character.isDigit(carcour))){
					carcour=fs.lireCaratere();
					s=s+carcour;
					etat=1;
				}else if (carcour == '_'){
					carcour=fs.lireCaratere();
					s=s+carcour;
					etat=2;
				}else if (carcour =='$'){
					etat=9;
				}else{
					etat=0;
					s=s.substring(0, s.length()-1);
					
					if(TMC.contient(s)){
						tab[0]=TMC.getValeur(s);
						return(tab);
					}else if (TDS.contient(s)){
						
						tab[0]=600;
						tab[1]=TDS.getCle(s);

						return(tab);
					}else{
						TDS.add(s);
						

						tab[0]=600;
						tab[1]=TDS.getCle(s);
						return(tab);
					}

				}
				break;

			case 2:
				if (Character.isLetter(carcour)){
					carcour=fs.lireCaratere();
					s=s+carcour;
					etat=1;
				}else if (carcour == '_'){
					etat=9;
				}
				break;

			case 3:
				if (Character.isDigit(carcour)){
					carcour=fs.lireCaratere();
					s=s+carcour;
					etat=3;
				}else if (Character.isLetter(carcour)){
					etat=9;
				}else if (carcour =='$'){
					etat=9;
				}else{
					etat=0;
					
					s=s.substring(0, s.length()-1);
					tab[0]=800;

					tab[1]=Integer.parseInt(s);
					return(tab);
				}

				break;


			case 4:
				if (Character.isDigit(carcour)){
					s=s+carcour;
					carcour=fs.lireCaratere();
					
					etat=5;
				}else{
					etat=9;
				}
				break;

			case 5:
				if (Character.isDigit(carcour)){
					s=s+carcour;
					carcour=fs.lireCaratere();
					
					etat=5;
				}else if (Character.isLetter(carcour)){
					s=s+carcour;
					carcour=fs.lireCaratere();
					
					etat=5;
				}
				if (carcour == '\n'|| carcour == ' '){
					etat=0;
					s=s+carcour;
					s=s.substring(0, s.length()-1);
					
					tab[0]=700;
					
					tab[1]=Integer.parseInt(s,16);

					return(tab);
				}
				break;

			case 6:
				
				if (carcour == '\n'|| carcour == ' '){
					etat=0;
					carcour=fs.lireCaratere();
					tab[0]=TMC.getValeur(s);
					return(tab);
				}
				if (carcour == '='){
					etat=0;
					s=s+carcour;
					tab[0]=TMC.getValeur(s);
					etat=0;
					carcour=fs.lireCaratere();
					return(tab);
				}
				if (carcour == '>'){
					etat=0;
					carcour=fs.lireCaratere();
					s=s+carcour;
					tab[0]=TMC.getValeur(s);
					return(tab);
				}

				break;

			case 7:
				s=s.substring(0, s.length()-1);
				if (carcour == '\n'|| carcour == ' '){
					etat=0;
					tab[0]=TMC.getValeur(s);
					return(tab);
				}
				if (carcour == '='){
					etat=0;
					tab[0]=TMC.getValeur(s);
					return(tab);
				}
				break;

			case 8:
				while (carcour != '}' && Character.isDefined(carcour)){


					carcour=fs.lireCaratere();


				}
				if(!Character.isDefined(carcour)){
					etat=9;
				}

				else{
					carcour=fs.lireCaratere();
					s=s+carcour;
					etat=0;
				}


				break;

			case 9:
				

				if (!Character.isDefined(carcour)){
					tab[0]=70;
					return(tab);
				}
				while  (!isSeparateur(carcour)){
					carcour=fs.lireCaratere();

				}
				s=s+carcour;
				etat=0;


				break;


			default : 
				System.out.println("c'est louche, tres louche"); 
				break;
			}
		}



	}

	public boolean isSeparateur(char car){

		if (carcour == ' ' || carcour == '\n' || carcour=='\t'||carcour == '.'|| carcour == '<'||carcour == '>'||carcour == '('||carcour == ')'||carcour == '['||carcour == ']'||carcour == ';'||carcour == ','||carcour == '+'||carcour == '='||carcour == '['||carcour == ']'||carcour == ';'||carcour == ','||carcour == '+'||carcour == '?'||carcour == '['||carcour == ']'||carcour == ';'||carcour == ','||carcour == '+'||carcour == '{'|| !Character.isDefined(carcour)){
			return true;
		}else{
			return false;
		}
	}


	public static void main(String[] args) {
		int []code_lexical = {0,0};
		ALEX a = new ALEX();
		
		try {
			a.initialisation();
			while (code_lexical[0]!=70){
				code_lexical= a.Alex();
				String s=code_lexical[0]+" ";
				
				if(code_lexical[1]!=-1)
					s=s+code_lexical[1];
				System.out.println(s);

			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}


}