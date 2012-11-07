
public class Table {
	
	private String str;
	private boolean decl;
	private boolean util;
	
	public Table(){
		str="";
		decl=false;
		util=false;
	}
	
	public Table(String s){
		str=s;
		decl=false;
		util=false;
	}

	public String getStr() {
		return str;
	}

	public boolean isDecl() {
		return decl;
	}

	public boolean isUtil() {
		return util;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public void setDecl(boolean decl) {
		this.decl = decl;
	}

	public void setUtil(boolean util) {
		this.util = util;
	}
	
	
}
