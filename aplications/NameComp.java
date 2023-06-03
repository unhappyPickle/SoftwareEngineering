package aplications; // group 9

import java.util.Comparator;

public class NameComp implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		
		for(int i = 0; i < o1.getName().length() && i < o2.getName().length(); i++) {
			if (o1.getName().charAt(i) != o2.getName().charAt(i)) return o1.getName().charAt(i) - o2.getName().charAt(i);
		}
		return o1.getName().length() - o2.getName().length();
	}

}
