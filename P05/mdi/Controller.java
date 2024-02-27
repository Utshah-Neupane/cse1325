package mdi;

import store.Store;
import java.util.Scanner;

//import mdi.View;
//import mdi.Menu;
//import mdi.MenuItem;

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


        mainMenu.addMenuItem(new MenuItem("0] Exit", ()->exit()));
        mainMenu.addMenuItem(new MenuItem("1] Place an Order", ()->placeOrder()));
        mainMenu.addMenuItem(new MenuItem("2] Welcome New Customer", ()->newCustomer()));
        mainMenu.addMenuItem(new MenuItem("3] Define New Tool", ()->newTool()));
        mainMenu.addMenuItem(new MenuItem("4] Define New Plant", ()->newPlant()));
        mainMenu.addMenuItem(new MenuItem("5] Switch View", ()->switchView()));
    }


    public void mdi(){
        while(isRunning) {
            try {
                Integer i = selectFromMenu();
                output = "";
                if(i == null) continue;
                Menu.run(i);
                } 
                catch (Exception e) {
                print("#### Invalid command");
                }
        }
    }



    public void exit(){
        isRunning = false;
    }



    public void placeOrder(){
        System.out.println (store.getCustomerList());
        System.out.println ("Selection of Customer: ");
        int customerIndex = getInt();
        int orderIndex = store.newOrder(customerIndex);
        System.out.println ("Select products(Enter -1 to stop): ")

        while (true){
	        System.out.println (store.getProductList());
	        int productIndex = getInt();
	        if (productIndex == -1) break;
	        int quantity = getInt("Enter the quanity: ");
	    }
	    output = "Order successful!";
	    view = view.orders;
    }



    public void newCustomer(){
    	String name = getString("Enter the new Customer's name: ");
    	String email = getString ("Enter the email address: ");
    	Customer customer = new Customer(name, email);
    	store.addCustomer(customer);
    	output = "Customer successfully added!";
    	view = view.customers;

    }



    public void newTool(){}

    public void newPlant(){
    }

    public void switchView(){}






}





