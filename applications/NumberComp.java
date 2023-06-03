package applications; // group 9

import java.util.Comparator;

public class NumberComp implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		
		for(int i = 0; i < o1.getNumber().length() && i < o2.getNumber().length(); i++) {
			if (o1.getNumber().charAt(i) != o2.getNumber().charAt(i)) return o2.getNumber().charAt(i) - o1.getNumber().charAt(i);
		}
		return o2.getNumber().length() - o1.getNumber().length();
	}

}
