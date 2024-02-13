package store;
import java.util.ArrayList;


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


	public Order (Customer customer){
		this.orderNumber = nextOrderNumber++;
		this.customer = customer;
		this.items = new ArrayList<>();
	}


	public void addItem (Item item){
		items.add(item);
	}


	public int getPrice(){
		int sum = 0;
		for (Item item: items){
			sum += item.getPrice();
		}
		return sum;
	}


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






}



