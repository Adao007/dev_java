package Lab4;

import java.text.DecimalFormat;
import java.util.Random; 

public class lab43 {

	public static void main(String[] args){
	
	DecimalFormat df = new DecimalFormat("0.####");
	Random gen = new Random();
	int r = gen.nextInt(20) + 1;
	int h = gen.nextInt(20) + 1; 
	
	double vol = Math.PI + Math.pow(r, 2) + h; 
	double sur = 2 * Math.PI * r * h; 
	String formattedV = df.format(vol);
	String formattedH = df.format(sur); 
	
	System.out.println("Radius: " + r); 
	System.out.println("Height: " + h); 
	System.out.println("Volume: " + formattedV);
	System.out.println("Surface Area: " + formattedH); 
	}
	
}
