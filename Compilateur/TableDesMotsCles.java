import java.util.HashMap;


public class TableDesMotsCles {
	
	private HashMap<String,Integer> TableMC;
	
	public TableDesMotsCles(){
		TableMC = new HashMap<String,Integer>();
	}
	
	public void initialisation(){
		TableMC.put("AX", new Integer(1));
		TableMC.put("BX", new Integer(2));
		TableMC.put("CX", new Integer(3));
		TableMC.put("DX", new Integer(4));
		TableMC.put("SI", new Integer(5));
		TableMC.put("SP", new Integer(6));
		TableMC.put("MOV", new Integer(7));
		TableMC.put("ADD", new Integer(8));
		TableMC.put("SUB", new Integer(9));
		TableMC.put("AND", new Integer(10));
		TableMC.put("OR", new Integer(11));
		TableMC.put("XOR", new Integer(12));
		TableMC.put("MUL", new Integer(13));
		TableMC.put("DIV", new Integer(14));
		TableMC.put("PUSH", new Integer(15));
		TableMC.put("POP", new Integer(16));
		TableMC.put("INT", new Integer(17));
		TableMC.put("PROGRAM", new Integer(18));
		TableMC.put("VAR", new Integer(19));
		TableMC.put("DW", new Integer(20));
		TableMC.put("DUP", new Integer(21));
		TableMC.put("BEGIN", new Integer(22));
		TableMC.put("END", new Integer(23));
		TableMC.put("IF", new Integer(24));
		TableMC.put("THEN", new Integer(25));
		TableMC.put("ELSE", new Integer(26));
		TableMC.put("WHILE", new Integer(27));
		TableMC.put("DO", new Integer(28));
		TableMC.put("OU", new Integer(29));
		TableMC.put("ET", new Integer(30));
		TableMC.put("LEA", new Integer(31));
		TableMC.put(".", new Integer(50));
		TableMC.put("<", new Integer(51));
		TableMC.put(">", new Integer(52));
		TableMC.put("(", new Integer(53));
		TableMC.put(")", new Integer(54));
		TableMC.put("[", new Integer(55));
		TableMC.put("]", new Integer(56));
		TableMC.put(";", new Integer(57));
		TableMC.put("?", new Integer(58));
		TableMC.put(",", new Integer(59));
		TableMC.put("+", new Integer(60));
		TableMC.put("&", new Integer(61));
		TableMC.put("<=", new Integer(62));
		TableMC.put("<>", new Integer(63));
		TableMC.put("=", new Integer(64));
		TableMC.put(">=", new Integer(65));
		TableMC.put("EOF", new Integer(70));
	}
	
	public boolean contient(String mot){
		return(TableMC.containsKey(mot));
	}
	
	public Integer getValeur(String mot){
		return(TableMC.get(mot));
	}

	public HashMap<String, Integer> getTableMC() {
		return TableMC;
	}
	public void add(String symb, Integer i){
		TableMC.put(symb, i);
		
	}
	
	
	
	
}
