package Lab9;

import java.util.Scanner;

public class lab91 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a month: ");
		String month = scan.next();
		switch(month) {
		case "December" :
		case "January" :
		case "February" :
			System.out.print(month + " is Winter");
			break; 
		case "March" :
		case "April" :
		case "May" : 
			System.out.print(month + " is Spring");
			break;
		case "June":
		case "July":
		case "August":
			System.out.print(month + " is Summer");
			break;
		case "September" :
		case "October" :
		case "November" :
			System.out.print(month + " is Fall");
			break;
		}
		scan.close();	
	}
}
