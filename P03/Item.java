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
		int dollar = getPrice() / 100;
		int cents = getPrice() % 100;

		return String.format("%-3s %-26s $ %d.%02d", quantity, product, dollar, cents);

	}
}



