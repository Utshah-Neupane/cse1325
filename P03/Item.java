public class Item{

	private Product product;
	private int quantity;

	public Item (Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}

	public int getPrice(){
		return (quantity * product.getPrice());

	}

	@Override
	public String toString(){
		int dollar = price / 100;
		int cents = price % 100;

		return String.format("%-30s $ %d.%02d", name, dollar, cents);

	}






}



