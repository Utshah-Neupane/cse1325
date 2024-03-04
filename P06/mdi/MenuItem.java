package mdi;

public class MenuItem implements Runnable {
	private Object menuText; // The text displayed to the user
	private Runnable menuResponse; // When selected, call this method via Runnable.run()

	public MenuItem(Object menuText, Runnable menuResponse) {
	this.menuText = menuText;
	this.menuResponse = menuResponse;
	}

	@Override
	public String toString() {
	return menuText.toString();
	}
	
	@Override
	public void run() {
	menuResponse.run();
	}
	
}