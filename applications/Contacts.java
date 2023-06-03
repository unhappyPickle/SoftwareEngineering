package applications; // group 9

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Contacts extends App{

	private ArrayList<Contact> list;
	
	//creating contacts list
	public Contacts() {
		this.list = new ArrayList<Contact>();
	}
	
	//function 1- adding contact to the list
	public void addContact(Contact c) {
		for (Contact co : list) {
			if (co.getName().equals(c.getName())) {
				System.out.println("There is already " + c.getName() + " in contacts");
				return;
			}
		}
		list.add(c);
		System.out.println(c.getName() + " was added to contacts succesfully!");

	}
	
	//function 2- deleting one copy (if exists) of the contact from the list
	public boolean deleteContact(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	//function 3- prints all contacts
	public void print() {
		for (Contact c : list) {
			c.printContact();
		}
	}
	
	//function 4- searching for contacts
	public ArrayList<Contact> member(String name){
		ArrayList<Contact> l = new ArrayList<Contact>();
		
		for (Contact c : list) {
			if (name.equals(c.getName())) l.add(c);
		}
		
		return l;
		
	}
	
	//function 5- sorting the list by lexicographic name
	public void sortByName() {
		Collections.sort(this.list ,new NameComp());
	}
	
	public void sortByNumber() {
		Collections.sort(list ,new NumberComp());
	}
	
	//function 7- deleting duplicates of the contact
	public int deleteDups() {
		int sizebefore = list.size();
		for (int j = 0; j < list.size(); j++) {
			Contact c = list.get(j);
			for (int i = j+1; i < list.size(); i++) {
				if (list.get(i).equals(c)) {
					list.remove(i);
					i--;
				}
			}
		}
		return -list.size()+sizebefore;
	}
	
	//function 8- reverse the contacts list
	public void reverseList() {
		int size = list.size();
		for (int i = 0; i < size/2; i++) {
			Contact temp = list.get(i);
			list.set(i, list.get(size-i-1));
			list.set(size-i-1, temp);
		}
	}
	
	//function 9- save contacts to a file
	public void saveToFile(String fileName) throws IOException {
		File file = new File(fileName);
		FileWriter writer = new FileWriter(file, false);
		for (int i = 0; i < list.size(); i++) {
			writer.write(list.get(i).getName() + "\n");
			writer.write(list.get(i).getNumber() + "\n");
		}
		writer.close();
	}
	
	//function 10- loading contacts from file to list 
	public void loadFromFile(String fileName) throws IOException {
		File file = new File(fileName);
		Scanner reader = new Scanner(file);
		while(reader.hasNext()) {
			String name = reader.nextLine();
			String number = reader.nextLine();
			Contact c = new Contact(name,number);
			addContact(c);
		}
		reader.close();
	}

	@Override
	public void printOptions() {
		System.out.println("1) add contact");
		System.out.println("2) remove contact");
		System.out.println("3) print contacts");
		System.out.println("4) search contact");
		System.out.println("5) sort by name");
		System.out.println("6) sort by phone number");
		System.out.println("7) remove duplicates");
		System.out.println("8) reverse");
		System.out.println("9) save to a file");
		System.out.println("10) load from a file");
		System.out.println("11) exit");
		
	}

	@Override
	public boolean chooseOption(int option, Contacts con) {
		String name, filename;
		Scanner in = new Scanner(System.in);
		switch (option) {
		case 1:
			System.out.print("Enter name: ");
			name = in.nextLine();
			System.out.print("Enter phone number: ");
			String number = in.nextLine();
			Contact c = new Contact(name, number);
			addContact(c);
			break;
		case 2:
			System.out.print("Enter name: ");
			name = in.nextLine();
			boolean removed = deleteContact(name);
			if (removed) System.out.println(name + " was removed succesfully!");
			else System.out.println("There are no \""+name+"\" in the list");
			
			break;
		case 3:
			System.out.println("==========");
			print();
			System.out.println("==========");
			break;
		case 4:
			System.out.print("Enter name: ");
			name = in.nextLine();
			ArrayList<Contact> members = member(name);
			for (Contact co : members) {
				co.printContact();
			}
			if (members.size() == 0) System.out.println("There are no \""+name+"\" in the list");
			break;
		case 5:
			sortByName();
			System.out.println("Sorted by name");
			break;
		case 6:
			sortByNumber();
			System.out.println("Sorted by number");
			break;
		case 7:
			int deleted = (int) deleteDups();
			System.out.println(deleted + " were deleted");
			break;
		case 8:
			reverseList();
			System.out.println("The list has been reveresed");
			break;
		case 9:
			System.out.print("Enter filename: ");
			filename = in.nextLine();
			try {
				saveToFile(filename);
				System.out.println("Saved to file successfully");
			} catch (IOException e) {
				System.out.println("Failed saving to file");
			}
			break;
		case 10:
			System.out.print("Enter filename: ");
			filename = in.nextLine();
			try {
				loadFromFile(filename);
				System.out.println("Loaded file successfully");
			} catch (IOException e) {
				System.out.println("Failed loading from file");
			}
			break;
		case 11:
			System.out.println("goodbye!");
			in.close();
			return false;
			

		default:
			System.out.println("please Enter a number between 1 and 11");
			break;
		}
		
		return true;

	}
	
	
}
