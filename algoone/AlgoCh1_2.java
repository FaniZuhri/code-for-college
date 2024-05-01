package algoone;
import java.util.Scanner;

public class AlgoCh1_2
{
	@SuppressWarnings("resource")
    public static void main(String[] args) {
	    /*
	        create input object
	    */
	    Scanner celciusInputObj = new Scanner(System.in);
	    System.out.println("Enter room temperature in Celcius: ");
	    
	    /*
	        get the input string, and typecast it to float data type
	    */
	    float celciusInputUser = Float.parseFloat(celciusInputObj.nextLine());
	    
	    /*
	        print the float convertion after typecasted to string data type
	    */
	    System.out.println("Room temperature in Farenheit: " + 
	        (((celciusInputUser * 9) / 5) + 32) +
	        " and Kelvin: " +
	        (celciusInputUser + 273)
	    );
	    
	}
}
