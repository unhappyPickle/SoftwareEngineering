package aplications;

import java.util.ArrayList;
import java.util.Scanner;

public class SMS extends App{
	private ArrayList<Chat> chatList;
	//default constructor
	public SMS() {
		this.chatList = new ArrayList<Chat>();
	}
	
	//function 1 - add a chat
	public void addChat(String message, Contact c) {
		boolean exist = false;
		for (Chat other : chatList) {
			if (other.getContact().equals(c)){
				other.addTo(message);
				exist = true;
			}
		}
		if (!exist)
			chatList.add(new Chat(c));
	}
	
	//function 2 - remove a chat
	public void removeChat(Contact c) {
		for (int i = 0; i < chatList.size(); i++) 
		{
			if (chatList.get(i).getContact().equals(c)){
				chatList.remove(i);
				return;
			}
		}
	}
	
	//function 3 - print a specific chat
	public void printChat(String name)
	{
		for (Chat chat : chatList)
		{
			if (chat.getContact().getName().equals(name))
			{
				chat.printChat();
				return;
			}
		}
		System.out.println("There is no chat with " + name);
	}
	
	
	// function 4 - search a sentence
	public void searchSentence(String sentence)
	{
		for (Chat chat : chatList)
		{
			if(chat.findSentence(sentence))
				System.out.println(chat.getContact().getName());
		}
	}
	
	//function 5 - print
	public void printSMS() {
		for (Chat chat : chatList) {
			System.out.println("******************");
			chat.printChat();
		}
	}

	@Override
	public void printOptions() {
		System.out.println("1) Add a chat");
		System.out.println("2) Remove a chat");
		System.out.println("3) Print a specific chat");
		System.out.println("4) Search a sentence");
		System.out.println("5) Print all chats");
		System.out.println("6) Exit");
	}

	@Override
	public boolean chooseOption(int option, Contacts con) {
		Scanner in = new Scanner(System.in);
		String name;
		String message;
		Contact c;
		switch(option) {
		case 1:
			System.out.print("Enter the name of the contact");
			name = in.nextLine();
			if (con.member(name).size() == 0) {
				System.out.println("There is no " + name + " in contacts");
				break;
			}
			c = con.member(name).get(0);
			System.out.print("Enter message: ");
			message = in.nextLine();
			addChat(message, c);
			break;
			
		case 2:
			System.out.print("Enter the name of the contact");
			name = in.nextLine();
			if (con.member(name).size() == 0) {
				System.out.println("There is no " + name + " in contacts");
				break;
			}
			c = con.member(name).get(0);
			System.out.print("Enter message: ");
			message = in.nextLine();
			removeChat(c);
			break;
			
		case 3:
			System.out.print("Enter the name of the contact");
			name = in.nextLine();
			
			printChat(name);
			break;
		
		case 4:
			System.out.print("Enter the sentence");
			message = in.nextLine();
			searchSentence(message);
			break;
			
		case 5:
			printSMS();
			break;
			
		case 6:
			System.out.println("goodbye!");
			in.close();
			return false;
			
			default:
				System.out.println("please Enter a number between 1 and 6");
				break;
				
		}
		return true;
	}
	
}
