public class TestProduct{
	public static void main (String[] args){
		int error_count = 0;


		Product product1 = new Product("Apple", 209);
		Product product2 = new Product ("Orange", 30);
		

		if (product1.getStockNumber() != 0){
			System.err.println("ERROR: Incorrect stock number "+ product1.getStockNumber() + " (0 expected)");
			error_count++;
		}

		if (product2.getStockNumber() != 1){
			System.err.println("ERROR: Incorrect stock number "+ product2.getStockNumber() + " (1 expected)");
			error_count++;
		}


		if (product1.getPrice() != 209){
			System.err.println("ERROR: Incorrect price "+ product1.getPrice() + " (209 expected)");
			error_count++;
		}


		try {
			Product product3 = new Product ("Product3", -23);
			System.err.println ("ERROR: No exception thrown for a negative price.");
			error_count++;
		}
			catch (Exception e){
			}


		System.exit (error_count);

	}
}




