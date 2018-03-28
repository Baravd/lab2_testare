package model;

public class Entry {	
	private int value;
	private String typeEntry;//cost or income
	private String idMember;
	
	
	public Entry(String typeEntry, int value,String idM){
		this.typeEntry=typeEntry;
		this.value=value;
		this.idMember=idM;
	}
	public void setType(String newType) {
		typeEntry = newType;
	}
	
	public String getType() {
		return typeEntry;
	}

	public void setValue(int newValue) {
		this.value = newValue;
	}

	public int getValue() {
		return value;
	}

	public String getTypeEntry() {
		return typeEntry;
	}

	public void setTypeEntry(String typeEntry) {
		this.typeEntry = typeEntry;
	}

	public String getIdMember() {
		return idMember;
	}

	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}

	public String toString() {
		String e=" idM=" +this.idMember+" " + this.typeEntry + " " + this.value;
		return e;   
	}
	
}
