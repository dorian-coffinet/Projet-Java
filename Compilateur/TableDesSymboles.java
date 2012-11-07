import java.util.HashMap;


public class TableDesSymboles {

private HashMap<Integer,Table> TableDS;

private Integer num;
	
	public TableDesSymboles(){
		TableDS = new HashMap<Integer,Table>();
		num=1;
	}
	
	public void add(String symb){
		TableDS.put(num,new Table(symb));
		num++;
	}
	
	public boolean contient(String symb){
		boolean b=false;
		for(Integer i : TableDS.keySet()){
			if((TableDS.get(i).getStr()).compareTo(symb)==0){
				b=true;
			}
		}
		return(b);
	}
	
	
	public Integer getCle(String s){
		Integer in=0;
		for(Integer i : TableDS.keySet()){
			if((TableDS.get(i).getStr()).compareTo(s)==0){
				in=i;
			}
		}
		return(in);
	}

	public HashMap<Integer,Table> getTableDS() {
		return TableDS;
	}

	public Integer getNum() {
		return num;
	}
	
	
}
