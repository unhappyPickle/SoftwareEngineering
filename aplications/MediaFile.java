package aplications;

public class MediaFile {

	private int seconds;
	private String name;


	public MediaFile(int seconds, String name) {
		this.seconds = seconds;
		this.name = name;
	}

	public double getseconds() {
		return seconds;
	}


	public void setseconds(int seconds) {
		this.seconds = seconds;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void play() {
		System.out.println("\"" + name +"\" is now playing for " + (seconds / 60) + " minutes and " + (seconds%60) + " seconds");
	}
	
	
}
