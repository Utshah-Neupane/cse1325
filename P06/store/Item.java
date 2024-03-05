package store;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class Item{

	private Product product;
	private int quantity;

	public Item (Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}

	public Item (BufferedReader br) throws IOException{
		String subclass = br.readLine();
		if (subclass.equals ("store.Plant")){
			this.product = new Plant(br);
		}
		if (subclass.equals ("store.Tool")){
			this.product = new Tool(br);
		}
		this.quantity = Integer.parseInt(br.readLine());
	}



	public int getPrice(){
		return (quantity * product.getPrice());

	}

	@Override
	public String toString(){
		int dollar = getPrice() / 100;
		int cents = getPrice() % 100;

		return String.format("%-3d %-26s $ %d.%02d", quantity, product, dollar, cents);

	}


	public void save(BufferedWriter bw) throws IOException{
		bw.write(product.getClass().getName());
		bw.newLine();
		product.save(bw);
		bw.write(Integer.toString(quantity));
		bw.newLine();
	}

}



