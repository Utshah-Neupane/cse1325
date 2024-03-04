package store;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Customer{

	private String name;
	private String email;


	public Customer (String name, String email){
		if (!email.contains("@") || email.indexOf("@") > email.lastIndexOf(".")){
			throw new IllegalArgumentException ("Invalid Email Address: " + email);
		}

		this.name = name;
		this.email = email;
	}

	public Customer(BufferedReader br) throws IOException{
		this.name = br.readLine();
		this.eamil = br.readLine();
	}




	@Override
	public String toString (){
		return (name + "(" + email + ")");
	}

	public void Save(BufferedWriter bw) throws IOException{
		bw.write(name);
		bw.newLine();
		bw.write(email);
		bw.newLine();
	}



}





