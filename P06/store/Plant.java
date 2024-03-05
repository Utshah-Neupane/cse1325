package store;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class Plant extends Product{

	private Exposure exposure;

	public Plant (String species, int price, Exposure exposure){
		super ("Plant: " + species, price);
		this.exposure = exposure;
	}


	public Plant(BufferedReader br) throws IOException{
		super (br);
		this.exposure = Exposure.valueOf(br.readLine());
	}



	public Exposure getExposure(){
		return exposure;
	}


	@Override
	public void save(BufferedWriter bw) throws IOException{
		super.save(bw);
		bw.write(exposure.name());
		bw.newLine();
	}
}


