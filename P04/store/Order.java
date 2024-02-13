package store;

import java.util.ArrayList;

public class Order{

	private static int nextOrderNumber;
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
		sum = 0;
		for (Item item: items){
			sum += item.getPrice();
		}
		return sum;
	}


	@Override
	public String toString(){
		StringBuilder receipt = new StringBuilder();
		receipt.append("Order #" + orderNumber + "for " + customer);

		for (Item item: items){
			receipt.append(item);
			System.out.println();
		}

		int dollar = getPrice() / 100;
		int cents = getPrice() % 100;

		receipt.append("Order Total: $").append(dollar).append(".").append(cents);
		return receipt.toString();

	}






}



