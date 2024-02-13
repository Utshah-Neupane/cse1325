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
		
	}






}



