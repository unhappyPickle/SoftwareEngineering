package applications;

import java.util.ArrayList;
import java.util.Scanner;

public class Media extends App{

	private ArrayList<MediaFile> list;
	
	public Media() {
		list = new ArrayList<MediaFile>();
	}
	
	
	public void addMedia(MediaFile mf) {
		list.add(mf);
	}
	
	public void playMedia(String name) {
		
		for(MediaFile mf : list) {
			if (name.equals(mf.getName())) {
				mf.play();
				return;
			}
		}
		
		System.out.println("There is no \"" + name + "\" in the list");
	}
	
	public void playAll() {
		for (MediaFile mf : list) {
			mf.play();
		}
	}
	
	@Override
	public void printOptions() {
		System.out.println("1) add media");
		System.out.println("2) play media by name");
		System.out.println("3) play all");
		System.out.println("4) exit");
	}


	@Override
	public boolean chooseOption(int option, Contacts con) {
		Scanner in = new Scanner(System.in);
		String name;
		int length;
		switch(option) {
		case 1:
			System.out.print("Enter name: ");
			name = in.nextLine();
			while (true) {
				System.out.print("Enter number of seconds: ");
				try {
				length = in.nextInt();
				in.nextLine();
				} catch(Exception e) {
					System.out.println("Enter an integer please");
					in.nextLine();
					continue;
				}
				
				if (length >= 0) break; 
				System.out.println("Enter a positive amount of seconds please");
			}
			addMedia(new MediaFile(length, name));
			break;
			
		case 2:
			System.out.print("Enter the name of the media: ");
			name = in.nextLine();
			playMedia(name);
			break;
			
		case 3:
			playAll();
			break;
		
		case 4:
			System.out.println("goodbye!");
			in.close();
			return false;
		default:
			System.out.println("Choose a number between 1 and 4 please");
		}
		
		
		return true;
		
	}

}
