package aplications; // group 9

public class Contact {

	private String name;
	private String number;
	
	//constructor
	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	//default constructor 
	public Contact() {
		this.name = "";
		this.number = "";
	}
	
	//return contact name
	public String getName() {
		return this.name;
	}
	
	//return contact phone number
	public String getNumber() {
		return this.number;
	}
	
	//print contact
	public void printContact() {
		System.out.println("["+this.name+", "+this.number+"]");
	}
	
	//checks if there is another copy of the same contact
	public boolean equals(Contact c) {
		if (!c.getName().equals(this.name)) return false;
		return c.getNumber().equals(this.number);
		
	}

}
