package store;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;



/**
* Encapsulates a Customer and set of Items thay want to buy.
*
* @author 				Utshah Neupane
* @version 				2.0
* @since 				1.0
* @license.agreement 	GNU GENERAL PUBLIC LICENSE Version 3
*/

public class Order{

	private static int nextOrderNumber = 1;
	private int orderNumber;
	private ArrayList<Item> items;
	private final Customer customer;


/**
* Initializes fields.
*
* @param customer name and email address of the customer
* @since 1.0
*/
	public Order (Customer customer){
		this.orderNumber = nextOrderNumber++;
		this.customer = customer;
		this.items = new ArrayList<>();
	}


	public Order(BufferedReader br) throws IOException{
		this.orderNumber = Integer.parseInt(br.readLine());
		this.customer = new Customer(br);
		int numItems = Integer.parseInt(br.readLine());
		items = new ArrayList<>();
		for (int i = 0; i < numItems; i++){
			items.add(new Item(br));
		}
	}



/**
* Adds new items to the list
*
* @param item new item to be added to the list with name and quantity
* @since 1.0
*/
	public void addItem (Item item){
		items.add(item);
	}



/**
* Calculates sum of price of all items
*
* @return sum of item price as an integer
* @since 1.0
*/
	public int getPrice(){
		int sum = 0;
		for (Item item: items){
			sum += item.getPrice();
		}
		return sum;
	}



/**
* Prints a formatted receipt including items name, price.
* 
* @return  receipt as a string
* @since 1.0
*/
	@Override
	public String toString(){
		StringBuilder receipt = new StringBuilder();
		receipt.append("Order #" + orderNumber + " for " + customer + "\n\n");

		for (Item item: items){
			receipt.append(item).append("\n");
		}

		int dollar = getPrice() / 100;
		int cents = getPrice() % 100;

		receipt.append("\nOrder Total: $").append(dollar).append(".").append(cents);
		return receipt.toString();
	}



	public void save(BufferedWriter bw) throws IOException{
		bw.write(Integer.toString(orderNumber));
		bw.newLine();
		customer.save(bw);
		bw.newLine();
		bw.write(Integer.toString(items.size()));
		bw.newLine();

		for (Item item: items){
			item.save(bw);
		}
	}

}



