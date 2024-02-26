package store;
import java.util.ArrayList;

public class Store{
	private String name;
	private ArrayList<Customer> customers;
	private ArrayList<Product> products;
	private ArrayList<Order> orders;


	public Store(String name){
		this.name = name;
		this.customers = new ArrayList<>();
		this.products = new ArrayList<>();
		this.orders = new ArrayList<>();
	}

	public String getName(){
		return name;
	}



	public void addCustomer(Customer customer){
		customers.add(customer);
	}

	public String getCustomerList(){	
		StringBuilder menu = new StringBuilder();
		for (int i = 0; i < customers.size(); i++){
			menu.append(i).append("] ").append(customers.get(i)).append("\n");
		}
		return menu.toString();
	}



	public void addProduct(Product product){
		products.add(product);
	}

	public String getProductList(){
		StringBuilder menu = new StringBuilder();
		for (int i = 0; i < products.size(); i++){
			menu.append(i).append("] ").append(products.get(i)).append("\n");
		}
		return menu.toString();
	}




	public int newOrder(int customerIndex){
		Customer customer = customers.get(customerIndex);
		Order order = new Order(customer);
		orders.add(order);
		return orders.indexOf(order);
	}


	public void addToOrder(int orderIndex, int productIndex, int quantity){
		Product product = products.get(productIndex);
		Item item = new Item(product,quantity);
		orders.get(orderIndex).addItem(item);
	}


	public String getOrderList(){
		StringBuilder menu = new StringBuilder();
		for (int i = 0; i < orders.size(); i++){
			menu.append(i).append("] ").append(orders.get(i)).append("\n");
		}
		return menu.toString();
	}
}



