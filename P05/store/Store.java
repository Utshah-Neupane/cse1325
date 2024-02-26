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
		for (int i = 0; i < customers.size(), i++){
			menu.append(i).append("]").append(customers.get(i).append("\n"));
		}
		return menu.toString();
	}


	public void addProduct(Product product){
	}


	public String getProductList(){
	}




	public int newOrder(int customerIndex){
	}


	public void addToOrder(int orderIndex, int productIndex, int quantiy){
	}


	public String getOrderList(){
	}





}



