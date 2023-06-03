package aplications;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		App[] apps = {new Contacts(), new SMS(),new Media()};
		Scanner in = new Scanner(System.in);
		int option, app;
		
		while (true) {
			printApps();
			while (true) {
				System.out.print("Choose an app: ");
				try {
					app = in.nextInt();
					in.nextLine();
				} catch(Exception e) {
					System.out.println("Enter an integer please");
					in.nextLine();
					continue;
				}
				if (app == 5) {
					System.out.println("bye bye!");
					in.close();
					System.exit(0);
				}
				if (app > 4 || app < 1) {
					System.out.println("Choose an app between 1 and 4");
					continue;
				}
				break;
			}
			
			do {
				
				apps[app-1].printOptions();
				while (true) {
					System.out.print("Choose an option: ");
					try {
						option = in.nextInt();
						in.nextLine();
					}
					catch(Exception e) {
						System.out.println("please enter an integer");
						in.nextLine();
						continue;
					}
					break;
				}
				
			} while(apps[app-1].chooseOption(option, (Contacts)apps[0]));
			
			
			
		}		
				
	}
	
	

	private static void printApps() {
		System.out.println("1) Contacts");
		System.out.println("2) SMS");
		System.out.println("3) Calendar");
		System.out.println("4) Media");	
	}

}
