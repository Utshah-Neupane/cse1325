package mdi;

import store.Store;
import store.Customer;
import store.Tool;
import store.Plant;
import store.Exposure;

import java.util.Scanner;


public class Controller{

    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    private Scanner in; 
    private static String clearScreen = "\n".repeat(150);


    public Controller(String storeName){
        this.store = new Store(storeName);
        this.view = view;
        this.mainMenu = new Menu();
        this.output = "";
        this.isRunning = true;
        this.in  = new Scanner(System.in);


        mainMenu.addMenuItem(new MenuItem("Exit", ()->exit()));
        mainMenu.addMenuItem(new MenuItem("Place an Order", ()->placeOrder()));
        mainMenu.addMenuItem(new MenuItem("Welcome New Customer", ()->newCustomer()));
        mainMenu.addMenuItem(new MenuItem("Define New Tool", ()->newTool()));
        mainMenu.addMenuItem(new MenuItem("Define New Plant", ()->newPlant()));
        mainMenu.addMenuItem(new MenuItem("Switch View", ()->switchView()));
    }


    public void mdi(){
        while(isRunning) {
            try {
                Integer i = selectFromMenu();
                output = "";
                if(i == null) continue;
                mainMenu.run(i);
                } 
                catch (Exception e) {
                print("#### Invalid command");
                }
        }
    }



    private void exit(){
        isRunning = false;
    }



    private void placeOrder(){
        System.out.println (store.getCustomerList());
        System.out.print("Selection of Customer: ");
        int customerIndex = getInt("");
        int orderIndex = store.newOrder(customerIndex);
        //System.out.println ("Select products(Enter -1 to stop): ");

        while (true){
	        System.out.println (store.getProductList());
	        System.out.print("\nSelect products(Enter -1 to stop): ");
	        int productIndex = getInt("");
	        if (productIndex == -1) break;
	        int quantity = getInt("Enter the quanity: ");
	    }
	    output = "Order successful!";
	    view = View.ORDERS;
    }



    private void newCustomer(){
    	String name = getString("Enter the new Customer's name: ");
    	String email = getString("Enter the email address: ");
    	Customer customer = new Customer(name, email);
    	store.addCustomer(customer);
    	output = "Customer successfully added!";
    	view = View.CUSTOMERS;
    }



    private void newTool(){
    	String name = getString("Enter name of the tool: ");
    	int price = getInt("Enter price of the tool: ");
    	Tool tool = new Tool(name, price);
    	store.addProduct(tool);
    	output = "New tool successfully added!";
    	view = View.PRODUCTS;
    }



    private void newPlant(){
    	int count = 0;
    	String name = getString("Enter name of the plant: ");
    	int price = getInt("Enter price of the plant: ");
    	System.out.println("\nOptions for exposure level are:");
    	for (Exposure exposure: Exposure.values()){
    		System.out.println (count + "] " + exposure);
    		count++;
    	}
    	int exposureIndex = getInt("Enter index for exposure: ");
    	Plant plant = new Plant(name,price,Exposure.values()[exposureIndex]);
    	store.addProduct(plant);
    	output = "New plant successfully added!";
    	view = View.PRODUCTS;
    }



    private void switchView(){
    	int count = 0;
    	System.out.println("\nOptions for views are:");
    	for (View view: View.values()){
    		System.out.println (count + "] " + view);
    		count++;
    	}
    	int viewIndex = getInt("Enter index for view: ");
    	output = "View selected!";
    	view = View.values()[viewIndex];
    }




    private String getView(){
    	return "Current view: " + view;
    }


    private Integer selectFromMenu(){
    	System.out.println (clearScreen);
    	System.out.println(store.getName());
    	int selection = getInt(mainMenu.toString() + "\n" + getView() + "\n" + output + "\nSelection:");
    	return selection;
    }



    private void print(String s){
    	output += s + "\n";
    }



    private String getString(String prompt){
    	String input = "";
    	Scanner scanner = new Scanner(System.in);

    	while (true){
    		try{
	    		System.out.println (prompt);
	    		input = scanner.nextLine().trim();
	    		if (input.isEmpty()){
	    			throw new IllegalArgumentException ("Input can't be empty!");
	    		}
	    		return input;
	    	} catch(IllegalArgumentException e){
	    			System.err.println("Invalid Input! " + e);
	    		}
    	}
    }



    private Integer getInt(String prompt){
    	while (true){
    		try{
	    		String input = getString(prompt);
	    		return Integer.parseInt(input);
	    		
	    	} catch(IllegalArgumentException e){
	    		System.err.println("Invalid Input! " + e);
	    		}
    	}
    }


    private Double getDouble(String prompt){
    	while (true){
    		try{
	    		String input = getString(prompt);
	    		return Double.parseDouble(input);
	    		
	    	} catch(IllegalArgumentException e){
	    		System.err.println("Invalid Input! " + e);
	    		}
    	}
    }

}





