public class TestItem{
	public static void main (String[] args){
		int error_count = 0;

		Product product1 = new Product("Mango", 2099);
		Item item1 = new Item(product1, 2);

		Product product2 = new Product("Apple", 1499);
		Item item2 = new Item(product2, 12);
		
		if (item1.getPrice() != 4198){
			System.err.println("ERROR: Incorrect price "+ item1.getPrice() + " (4198 expected)");
			error_count++;
		}


		if (!item2.toString().equals("12 Apple               $ 179.88")){
			System.err.println("ERROR: Incorrect string, "+  " (12 Apple               $ 179.88) expected");
			error_count++;
		}

		System.exit (error_count);

	}
}
