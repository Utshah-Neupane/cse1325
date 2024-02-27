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



    private void exit(){
        isRunning = false;
    }



    private void placeOrder(){
        System.out.println (store.getCustomerList());
        System.out.println ("Selection of Customer: ");
        int customerIndex = getInt();
        int orderIndex = store.newOrder(customerIndex);
        System.out.println ("Select products(Enter -1 to stop): ");

        while (true){
	        System.out.println (store.getProductList());
	        int productIndex = getInt();
	        if (productIndex == -1) break;
	        int quantity = getInt("Enter the quanity: ");
	    }
	    output = "Order successful!";
	    view = View.orders;
    }



    private void newCustomer(){
    	String name = getString("Enter the new Customer's name: ");
    	String email = getString ("Enter the email address: ");
    	Customer customer = new Customer(name, email);
    	store.addCustomer(customer);
    	output = "Customer successfully added!";
    	view = View.customers;
    }



    private void newTool(){
    	String name = getString("Enter name of the tool: ");
    	int price = getInt("Enter price of the tool: ");
    	Tool tool = new Tool(name, price);
    	store.addProduct(tool);
    	output = "New tool successfully added!";
    	view = View.products;
    }



    private void newPlant(){
    	int count = 0;
    	String name = getString("Enter name of the plant: ");
    	int price = getInt("Enter price of the plant: ");
    	Sytem.out.println("\nOptions for exposure level are:");
    	for (Exposure exposure: Exposure.values()){
    		System.out.println (count + "] " + exposure);
    		count++;
    	}
    	int exposureIndex = getInt("Enter index for exposure: ");
    	Plant plant = new Plant(name,price,Exposure.values()[exposureIndex]);
    	store.addProduct(plant);
    	output = "New plant successfully added!";
    	view = View.products;
    }



    private void switchView(){
    	String[] views = {"customers", "products", "orders"};
    	int userChoice = getInt("Enter view (choose 1,2 or 3):  1(customers) 2(products)  3(orders)");
    	output = "";
    	view = View.(views.values()[userChoice - 1]);
    }




    private String getView(){
    	return "Current view: " + view;
    }


    private Integer selectFromMenu(){
    	System.out.println(store.getName());
    	int selection = getInt(mainMenu.toString() + "\n" + getView() + "\n" + output + "\nSelection:");
    	mainMenu.run(selection);
    }



    private void print(String s){
    	output += s + "\n";
    }



    private void getString(String prompt){
    	Scanner scanner = new Scanner(System.in);
    	while (true){
    		try{
	    		System.out.println (prompt);
	    		String input = scanner.nextLine().trim();
	    		if (input.isEmpty()){
	    			throw new IllegalArgumentException ("Input can't be empty!");
	    		}
	    	} catch(IllegalArgumentException e){
	    			System.err.println("Invalid Input! " + e);
	    		}
    	}
    }



    private Integer getInt(String prompt){}

    private Double getDouble(String prompt){}













}





