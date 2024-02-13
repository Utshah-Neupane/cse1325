package store; 

public abstract class Product{

	private static int nextStockNumber = 0;
	private int stockNumber;
	private String name;
	private int price;


	public Product(String name, int price){
		if (price < 0){
			throw new IllegalArgumentException ("Invalid price of " + name + " : " + price);
		}

		this.stockNumber = nextStockNumber++;
		this.name = name;
		this.price = price;
	}


	public int getStockNumber(){
		return stockNumber;
	}

	public int getPrice(){
		return price;
	}


	@Override
	public String toString(){
		int dollar = price / 100;
		int cents = price % 100;

		return String.format("%-30s $ %d.%02d", name, dollar, cents);
	}

}



