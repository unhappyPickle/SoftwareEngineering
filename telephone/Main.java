package telephone; // group 9

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void printOptions() {
		System.out.println("Enter your command:");
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
		System.out.print("your choice: ");
		
	}
	
	public static void main(String[] args) {
		
		Contacts phone = new Contacts();
		Scanner in = new Scanner(System.in);
		String name, filename;
		boolean breik = false;
		int choice;
		
		while (true) {
			printOptions();
			try {
				choice = in.nextInt();
				in.nextLine();
			}
			catch(Exception e) {
				in.nextLine();
				System.out.println("Enter a number please");
				System.out.println("*********************************");

				continue;
			}
			switch (choice) {
			case 1:
				System.out.print("Enter name: ");
				name = in.nextLine();
				System.out.print("Enter phone number: ");
				String number = in.nextLine();
				Contact c = new Contact(name, number);
				phone.addContact(c);
				System.out.println(name + " was added to list succesfully!");
				break;
			case 2:
				System.out.print("Enter name: ");
				name = in.nextLine();
				boolean removed = phone.deleteContact(name);
				if (removed) System.out.println(name + " was removed succesfully!");
				else System.out.println("There are no \""+name+"\" in the list");
				
				break;
			case 3:
				System.out.println("==========");
				phone.print();
				System.out.println("==========");
				break;
			case 4:
				System.out.print("Enter name: ");
				name = in.nextLine();
				ArrayList<Contact> members = phone.member(name);
				for (Contact co : members) {
					co.printContact();
				}
				if (members.size() == 0) System.out.println("There are no \""+name+"\" in the list");
				break;
			case 5:
				phone.sortByName();
				System.out.println("Sorted by name");
				break;
			case 6:
				phone.sortByNumber();
				System.out.println("Sorted by number");
				break;
			case 7:
				int deleted = (int) phone.deleteDups();
				System.out.println(deleted + " were deleted");
				break;
			case 8:
				phone.reverseList();
				System.out.println("The list has been reveresed");
				break;
			case 9:
				System.out.print("Enter filename: ");
				filename = in.nextLine();
				try {
					phone.saveToFile(filename);
					System.out.println("Saved to file successfully");
				} catch (IOException e) {
					System.out.println("Failed saving to file");
				}
				break;
			case 10:
				System.out.print("Enter filename: ");
				filename = in.nextLine();
				try {
					phone.loadFromFile(filename);
					System.out.println("Loaded file successfully");
				} catch (IOException e) {
					System.out.println("Failed loading from file");
				}
				break;
			case 11:
				System.out.println("goodbye!");
				in.close();
				breik = true;
				break;
				

			default:
				System.out.println("please Enter a number between 1 and 11");
				break;
			}
			if (breik) break;
			System.out.println("*********************************");
		}

	}

}
