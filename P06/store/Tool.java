package store;

import java.io.BufferedReader;
import java.io.IOException;


public class Tool extends Product{
	
	public Tool (String name, int price){
		super (name, price); 		//calling constructor of superclass Product
	}

	public Tool(BufferedReader br) throws IOException{
		super (br);
	}
}

