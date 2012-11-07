import java.io.IOException;


public class Ulex {

	private ALEX alex;
	private int ulex;
	public Ulex(){
		alex = new ALEX();
	}

	public void initialisation() throws IOException{

		alex.initialisation();
		ulex = alex.Alex()[0];
		programme();
		if(ulex != 70){
			erreur(0);
		}
		System.out.println("BRAVO!!!");

	}

	public void erreur(int num_erreur){
		switch(num_erreur){
		case 0 :
			System.out.println("Fin de fichier attendu");
			break;
		case 1 :	
			System.out.println(" . attendu");
			break;
		case 2:
			System.out.println("';' est attendu");
			break;
		case 3:
			System.out.println("'identificateur' est attendu");
			break;
		case 4:
			System.out.println("'PROGRAM' est attendu");
			break;
		case 5:
			System.out.println("'VAR'est attendu");;
			break;
		case 6:
			System.out.println("'DW'est attendu");
			break;
		case 7:
			System.out.println("'?' ou constante est attendu");
			break;
		case 8:
			System.out.println("'constante' est attendu");
			break;
		case 9:
			System.out.println("')' est attendu");
			break;
		case 10:
			System.out.println("'(' est attendu");
			break;
		case 11:
			System.out.println("'DUP' est attendu");
			break;
		case 12:
			System.out.println("'BEGIN' est attendu");
			break;
		case 13:
			System.out.println("'END' est attendu");
			break;
		case 14:
			System.out.println("'If WHILE ou ASSEMBLEUR' est attendu");
			break;
		case 15:
			System.out.println("'THEN' est attendu");
			break;
		case 16:
			System.out.println("'IF' est attendu");
			break;
		case 17:
			System.out.println("'ELSE' est attendu");
			break;
		case 18:
			System.out.println("'DO' est attendu");
			break;
		case 19:
			System.out.println("'WHILE' est attendu");
			break;
		case 20:
			System.out.println("'(' ou 'AX'ou 'BX' ou 'CX' ou 'DX' ou 'SI' ou 'SP' ou indentificateur ou '[' ou consatnte attendu");
			break;
		case 21:
			System.out.println("'<' ou '>'ou '<=' ou '>=' ou '=' ou '<>' attendu");
			break;
		case 22:
			System.out.println("instruction assembleur attendue");
			break;
		case 23:
			System.out.println("'MOV' ou 'ADD'ou 'SUB' ou 'AND' ou 'OR' ou 'XOR' ou 'LEA' attendu");
			break;
		case 24:
			System.out.println("',' attendue");
			break;
		case 25:
			System.out.println("'AX'ou 'BX' ou 'CX' ou 'DX' ou 'SI' ou 'SP' ou indentificateur ou '[' attendu");
			break;
		case 26:
			System.out.println("'AX'ou 'BX' ou 'CX' ou 'DX' ou 'SI' ou 'SP' ou constante attendu");
			break;
		case 27:
			System.out.println("'MUL' ou 'DIV'ou 'PUSH' ou 'POP' attendu");
			break;
		case 28:
			System.out.println("'INT' attendu");
			break;
		case 29:
			System.out.println("identificateur ou '[' attendu");
			break;
		case 30:
			System.out.println("']' attendu");
			break;
		case 31:
			System.out.println("'SI' ou 'BX' attendu");
			break;
		case 32:
			System.out.println("constante ou 'SI' attendu");
			break;
		}

		System.exit(num_erreur);
	}

	public void programme() throws IOException{
		if(ulex==18){
			ulex=alex.Alex()[0];
			if(ulex==600){
				ulex=alex.Alex()[0];
				if(ulex==57){
					ulex=alex.Alex()[0];
					nterm0();
					programme_principal();
					
					if(ulex==50){
						ulex=alex.Alex()[0];
					}else{
						erreur(1);
					}
				}else{
					erreur(2);
				}
			}else{
				erreur(3);
			}

		}else{
		erreur(4);
		}
	}

	public void nterm0() throws IOException{
		if(ulex==19){
			partie_declaration();
		}
	}





	public void partie_declaration() throws IOException{
		if(ulex==19){
			ulex=alex.Alex()[0];

			nterm1();
		}else{
			erreur(5);
		}
	}

	public void nterm1() throws IOException{
		declaration();
		nterm2();
	}

	public void nterm2() throws IOException{
		if(ulex == 600 || ulex ==20){
			nterm1();
		}
	}

	public void declaration() throws IOException{
		nterm3();
		if(ulex == 20){
			ulex=alex.Alex()[0];
			suite_declaration();
			if(ulex == 57){
				ulex=alex.Alex()[0];
			}else{
				erreur(2);
			}
		}else{
			erreur(6);
		}
	}

	public void nterm3() throws IOException{
		if(ulex == 600){
			ulex=alex.Alex()[0];	
		}
	}

	public void suite_declaration() throws IOException{
		if(ulex == 700 || ulex == 800){
			//ulex=alex.Alex()[0];
			nterm4();	
		}else if(ulex == 58){
			ulex=alex.Alex()[0];	
		}else{
			erreur(7);
		}


	}

	public void nterm4()throws IOException{
		if(ulex == 700 || ulex == 800){
			constante();
			nterm5();
		}else{
			erreur(8);
		}
	}

	public void nterm5() throws IOException {
		if(ulex == 21){
			ulex=alex.Alex()[0];
			if(ulex == 53){
				ulex=alex.Alex()[0];
				nterm6();
				ulex=alex.Alex()[0];
				if(ulex == 54){
					ulex=alex.Alex()[0];
				}else{
					erreur(9);
				}
			}else{
				erreur(10);
			}
		}else{
			erreur(11);
		}

	}



	public void nterm6() throws IOException {
		if(ulex == 700 || ulex == 800 || ulex ==58){
			constante();
		}else{
			erreur(7);
		}

	}

	public void programme_principal() throws IOException{
		if(ulex == 22){
			ulex=alex.Alex()[0];
			nterm7();
			if(ulex == 23){
				ulex=alex.Alex()[0];
			}else{
				erreur(13);
			}
		}else{
			erreur(12);
		}
	}


	public void nterm7() throws IOException {
		if(ulex == 24 || ulex == 27 || (ulex >=1 && ulex<=17)|| ulex == 31){
			instruction();
			nterm7();
		}

	}

	public void instruction() throws IOException {
		if(ulex == 24){
			conditionnelle();
			
			if(ulex == 57){
				ulex=alex.Alex()[0];
			}else{
				erreur(2);
			}
		}else if(ulex == 27){
			iteration();
			
			if(ulex == 57){
				ulex=alex.Alex()[0];
			}else{
				erreur(2);
			}
		}else if((ulex >=1 && ulex<=17)|| ulex == 31){
			assembleur();
			
			if(ulex == 57){
				ulex=alex.Alex()[0];
			}else{
				erreur(2);
			}
		}else{
			erreur(14);
		}

	}

	

	public void iteration() throws IOException {
		if(ulex == 27){
			ulex=alex.Alex()[0];
			condition();
			if(ulex == 28){
				ulex=alex.Alex()[0];
				programme_principal();
			}else{
				erreur(18);
			}
		}else{
			erreur(19);
		}

	}

	public void conditionnelle() throws IOException {
		if(ulex == 24){
			ulex=alex.Alex()[0];
			condition();
			if(ulex == 25){
				ulex=alex.Alex()[0];
				programme_principal();
				nterm8();
			}else{
				erreur(15);
			}
		}else{
			erreur(16);
		}

	}

	public void nterm8() throws IOException {
		if(ulex == 26){
			ulex=alex.Alex()[0];
			programme_principal();
		}

	}

	public void condition() throws IOException {
		if(ulex == 53 || ulex >= 1 && ulex <= 6 || ulex == 600 || ulex == 55 || ulex == 700 || ulex == 800){
			terme();
			nterm9();
		}else{
			erreur(10);
		}

	}

	public void nterm9() throws IOException {
		if(ulex == 29){
			ulex=alex.Alex()[0];
			terme();
			nterm9();
		}
		
	}

	public void terme() throws IOException {
		if(ulex == 53 || ulex >= 1 && ulex <= 6 || ulex == 600 || ulex == 55 || ulex == 700 || ulex == 800){
			facteur();
			nterm10();
		}
		
	}

	public void nterm10() throws IOException {
		if(ulex == 30){
			ulex=alex.Alex()[0];
			facteur();
			nterm10();
		}
		
	}

	public void facteur() throws IOException {
		if(ulex == 53){
			ulex=alex.Alex()[0];
			condition();
			if(ulex == 54){
				ulex=alex.Alex()[0];
			}else{
				erreur(9);
			}
			
		}else if(ulex >= 1 && ulex <= 6 || ulex == 600 || ulex == 55 || ulex == 700 || ulex == 800){
			nterm11();
			operateur();
			nterm11();
		}else{
			erreur(20);
		}
		
	}

	public void nterm11() throws IOException {
		if(ulex >= 1 && ulex <= 6){
			reg();
		
		}else if(ulex == 600 || ulex == 55){
			mem();
		}else if (ulex == 800 || ulex == 700){
			constante();
		}
		/*}else{
			erreur(20);
		}*/
	}
	
	public void operateur() throws IOException {
		if(ulex == 51 || ulex == 52 || ulex >= 62 && ulex <= 65){
			ulex=alex.Alex()[0];
		}else{
			erreur(21);
		}
		
	}
	
	public void assembleur() throws IOException {
		if(ulex >=7 && ulex <=12 || ulex == 31){
			type_1();
		}else if(ulex >= 13 && ulex <= 16){
			type_2();
		}else if(ulex == 17){
			type_3();
		}else{
			erreur(22);
		}

	}

	public void type_1() throws IOException {
		if(ulex >=7 && ulex <=12 || ulex == 31){
			mnemo_1();
			nterm12();
		}else{
			erreur(23);
		}
		
	}

	public void nterm12() throws IOException {
		if(ulex >=1 && ulex <=6){
			reg();
			if(ulex == 59){
				ulex=alex.Alex()[0];
				nterm11();
			}else{
				erreur(24);
			}
		}else if(ulex == 600 || ulex == 55){
			mem();
			if(ulex == 59){
				ulex=alex.Alex()[0];
				nterm13();
			}else{
				erreur(24);
			}
		}else{
			erreur(25);
		}
		
	}

	public void nterm13() throws IOException {
		if(ulex >=1 && ulex <=6){
			reg();
		}else if(ulex == 800 || ulex == 700){
			constante();
		}else{
			erreur(26);
		}
		
	}

	public void type_2() throws IOException {
		if(ulex >= 13 && ulex <= 16){
			mnemo_2();
			nterm14();
		}else{
			erreur(27);
		}
		
	}

	public void nterm14() throws IOException {
		if(ulex >=1 && ulex <=6){
			reg();
		}else if(ulex == 600 || ulex == 55){
			mem();
		}else{
			erreur(25);
		}
		
	}

	public void type_3() throws IOException {
		if(ulex == 17){
			mnemo_3();
			if(ulex == 800 || ulex == 700){
				constante();
			}else{
				erreur(8);
			}
		}else{
			erreur(28);
		}
		
	}
	
	public void reg() throws IOException {
		if(ulex >=1 && ulex <=6){
			ulex=alex.Alex()[0];
		}
		
	}

	public void mem() throws IOException {
		if(ulex == 600){
			ulex=alex.Alex()[0];
			nterm15();
		}else if(ulex == 55){
			suite_mem();
		}else{
			erreur(29);
		}
		
	}

	

	

	public void nterm15() throws IOException {
		if(ulex == 55){
			suite_mem();
		}
		
	}

	public void suite_mem() throws IOException {
		if(ulex == 55){
			ulex=alex.Alex()[0];
			nterm16();
		}
		
	}

	public void nterm16() throws IOException {
		if(ulex == 5){
			ulex=alex.Alex()[0];
			nterm18();
			if(ulex == 56){
				ulex=alex.Alex()[0];
			}else{
				erreur(30);
			}
		}else if(ulex == 2){
			ulex=alex.Alex()[0];
			nterm17();
		}else{
			erreur(31);
		}
		
		
	}

	public void nterm17() throws IOException {
		if(ulex == 60){
			ulex=alex.Alex()[0];
			nterm18();
		}
		
	}

	public void nterm18() throws IOException {
		if(ulex == 700 || ulex == 800){
			constante();
			if(ulex == 56){
				ulex=alex.Alex()[0];
			}else{
				erreur(30);
			}
		}else if(ulex == 5){
			ulex=alex.Alex()[0];
			nterm19();
			if(ulex == 56){
				ulex=alex.Alex()[0];
			}else{
				erreur(30);
			}
		}else{
			erreur(32);
		}
		
	}

	public void nterm19() throws IOException {
		if(ulex == 60){
			ulex=alex.Alex()[0];
			if(ulex == 700 || ulex == 800){
				constante();
			}else{
				erreur(8);
			}
		}
		
	}

	public void constante() throws IOException {
		if(ulex == 700 || ulex == 800){
			ulex=alex.Alex()[0];
		}
		
	}
	
	public void mnemo_1() throws IOException{
		 if(ulex >= 7 && ulex <= 12 || ulex ==31){
			 ulex=alex.Alex()[0];
		 }
	}
	
	public void mnemo_2() throws IOException{
		 if(ulex >= 13 && ulex <= 16){
			 ulex=alex.Alex()[0];
		 }
	}
	
	public void mnemo_3() throws IOException{
		 if(ulex == 17){
			 ulex=alex.Alex()[0];
		 }
	}

	public static void main(String[] args) throws IOException {
		Ulex u=new Ulex();
		u.initialisation();
	}
}
