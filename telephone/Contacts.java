package telephone; // group 9

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Contacts {

	private ArrayList<Contact> list;
	
	//creating contacts list
	public Contacts() {
		this.list = new ArrayList<Contact>();
	}
	
	//function 1- adding contact to the list
	public void addContact(Contact c) {
		list.add(c);
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
		Collections.sort(list ,new NameComp());
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
	
	
}
