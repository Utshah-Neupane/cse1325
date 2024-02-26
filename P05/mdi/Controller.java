package mdi;

import store.Store;
import java.util.Scanner;

public class Controller{

	private Store store;
	private View view;
	private Menu mainMenu;
	private String output;
	private boolean isRunning;
	private Scanner in; 


	public Controller(String storeName){
		this.store = new Store(storeName);
		this.view = view;
		this.mainMenu = new Menu();
		this.output = "";
		this.isRunning = true;
		this.in  = new Scanner(System.in);
	}






}





