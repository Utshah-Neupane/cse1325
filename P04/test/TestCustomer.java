package test; 
import store.Customer;


public class TestCustomer{
	public static void main (String[] args){
		int error_count = 0;


		Customer customer1 = new Customer("Nancy", "nancy_white@gmail.com");
		
		if (!customer1.toString().equals("Nancy(nancy_white@gmail.com)")){
			System.err.println("ERROR: Incorrect string "+ customer1.toString() + " (Nancy(nancy_white@gmail.com) expected)");
			error_count++;
		}



		try {
			Customer customer2 = new Customer("Alicia", "alicia.green-gmail.com");	
			System.err.println ("ERROR: No exception thrown for a missing '@'");
			error_count++;
		}
		catch (IllegalArgumentException e){

		}
		catch (Exception e){
			System.err.println ("Throws wrong exception for negative price.\n"+ e);
		}



		try {
			Customer customer3 = new Customer("Roy", "roy.yellow@gmailcom");	
			System.err.println ("ERROR: No exception thrown for a missing '.' after '@'");
			error_count++;
		}
		catch (IllegalArgumentException e){

		}
		catch (Exception e){
		}


		System.exit (error_count);

	}
}
