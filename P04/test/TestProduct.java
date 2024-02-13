package test;
import store.Exposure;
import store.Tool;
import store.Plant;


public class TestProduct{
	public static void main (String[] args){
		int error_count = 0;


		Tool tool1 = new Tool("Axe", 159);
		Plant plant1 = new Plant ("Rhododendron", 289, Exposure.PARTSUN);

		

		if (tool1.getStockNumber() != 0){
			System.err.println("ERROR: Incorrect stock number "+ tool1.getStockNumber() + " (0 expected)");
			error_count++;
		}

		if (plant1.getStockNumber() != 1){
			System.err.println("ERROR: Incorrect stock number "+ plant1.getStockNumber() + " (1 expected)");
			error_count++;
		}


		if (tool1.getPrice() != 159){
			System.err.println("ERROR: Incorrect price "+ tool1.getPrice() + " (159 expected)");
			error_count++;
		}


		try {
			Tool tool2 = new Tool ("wedge", -23);
			System.err.println ("ERROR: No exception thrown for a negative price.");
			error_count++;
		}
		catch (IllegalArgumentException e){

		}
		catch (Exception e){
			System.err.println ("Throws wrong exception for negative price.\n"+ e);
		}


		if (!plant1.toString().equals("Plant: Rhododendron            $ 2.89")){
			System.err.println("ERROR: Incorrect string "+ plant1.toString() + " (Plant: Rhododendron            $ 2.89) expected)");
			error_count++;
		}

		System.exit (error_count);

	}
}




