public class TestItem{
	public static void main (String[] args){
		int error_count = 0;

		Product product1 = new Product("Mango", 2099);
		Item item1 = new Item(product1, 2);

		Product product2 = new Product("Apple", 1499);
		Item item2 = new Item(product2, 12);
		
		if (!customer1.toString().equals("Nancy(nancy_white@gmail.com)")){
			System.err.println("ERROR: Incorrect string "+ customer1.toString() + " (Nancy(nancy_white@gmail.com) expected)");
			error_count++;
		}



		try {
			Customer customer2 = new Customer("Alicia", "alicia.green-gmail.com");	
			System.err.println ("ERROR: No exception thrown for a missing '@'");
			error_count++;
		}
			catch (Exception e){
			}


		try {
			Customer customer3 = new Customer("Roy", "roy.yellow@gmailcom");	
			System.err.println ("ERROR: No exception thrown for a missing '.' after '@'");
			error_count++;
		}
			catch (Exception e){
			}


		System.exit (error_count);

	}
}
