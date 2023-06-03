package applications;

import java.util.ArrayList;

public class Chat {
	private Contact c;
	private ArrayList<String> list;
	//constructor
	public Chat(Contact c, ArrayList<String> list) {
		this.c = new Contact(c.getName(), c.getNumber());
		this.list = new ArrayList<String>(list);
	}
	
	//default constructor 
	public Chat() {
		this.c = new Contact();
		this.list = new ArrayList<String>();
	}
	
	public Chat(Contact c) {
		this.c = c;
		this.list = new ArrayList<String>();
	}
	
	//get Contact
	public Contact getContact() {
		return c;
	}
	
	public ArrayList<String> getList() {
		return list;
	}
	
	//add to list
	public void addTo(String s)
	{
		list.add(s);
	}
	
	//compare two chats
	public boolean chatEqualsTo(Chat other) {
		if (this.list.size() != other.getList().size())
			return false;
		if(this.c.equals(other.getContact()))
		{
			for (int i = 0; i < other.getList().size(); i++)
			{
				
				if(!(other.getList().get(i).equals(this.list.get(i))))
					return false;
			}
			return true;
		}
		return false;
	}
	
	//Search a sentence
	public boolean findSentence(String s) {
		for (String str : list) {
			if (s.equals(str)) {
				return true;
			}
		}
		return false;
	}
	
	//print a chat
	public void printChat() {
		System.out.println("Chat with " + c.getName());
		for (String s : list) {
			System.out.println(s);
		}
	}
}
