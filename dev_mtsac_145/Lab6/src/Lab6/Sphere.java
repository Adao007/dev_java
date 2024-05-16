package Lab6;

import java.text.DecimalFormat;

public class Sphere {
	
	private double diameter; 
	DecimalFormat df = new DecimalFormat("0.###");
	
	public Sphere (double d)
	{
		diameter = d;
	}
	
	public double getDiameter()
	{
		return diameter; 
	}
	
	public void setDiameter(double d)
	{
		diameter = d;
	}
	
	public String getVolume()
	{
		double r = diameter / 2;
		double vol = ((double)4/3) * Math.PI * Math.pow(r, 3);
		String formattedVol = df.format(vol);
		return formattedVol;
	}
	
	public String getSurfaceArea()
	{
		double r = diameter / 2; 
		double sf = 4 * Math.PI * Math.pow(r, 2); 
		String formattedSF = df.format(sf);
		return formattedSF;
		
	}
	
	public String toString()
	{
		return "Sphere 1 diameter: " + diameter + " volume: " + getVolume() + " Surface Area: " + getSurfaceArea(); 
	}
}

