package store;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;



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

	public Store (BufferedReader br) throws IOException{
		int numCustomers = Integer.parseInt(br.readLine());
		for (int i = 0; i < numCustomers; i++){
			customers.add(new Customer(br));
		}

		int numProducts = Integer.parseInt(br.readLine());
		for (int i = 0; i < numProducts; i++){
			String typeProduct = br.readLine();
			if (typeProduct.equals("Plant")){
				products.add(new Plant(br));
			}
			if (typeProduct.equals("Tool")){
				products.add(new Tool(br));
			}
		}


		int numOrders = Integer.parseInt(br.readLine());
		orders = new ArraryList<>();
		for (int i = 0; i < numOrders; i++){
			orders.add(new Order(br));
		}
	}



	public String getName(){
		return name;
	}


	public void save(BufferedWriter bw) throws IOException{
		bw.write(Integer.toString(customers.size()));
		bw.newLine();
		for (Customer customer: customers){
			customer.save(bw);
		}

		bw.write(Integer.toString(products.size()));
		bw.newLine();
		for (Product product: products){
			product.save(bw);
		}

		bw.write(Integer.toString(orders.size()));
		bw.newLine();
		for (Order order: orders){
			order.save(bw);
		}
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



