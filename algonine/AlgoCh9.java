package algonine;

import java.util.Scanner;

public class AlgoCh9
{
	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		Customer customer1 = new Customer(10_000_000);
		Customer customer2 = new Customer(750_000);
		Customer customer3 = new Customer(5_000_000);
		
		int customerId, customerPurchase;
		boolean isDone = false;
		
		System.out.println("Point Awal");
		System.out.println("Customer 1: " + customer1.getPoint());
		System.out.println("Customer 2: " + customer2.getPoint());
		System.out.println("Customer 3: " + customer3.getPoint());
		
		while (true){
		    
		    while (true){
		        System.out.println("No ID Customer? (tekan 0 untuk keluar dari menu)");
		        customerId = userInput.nextInt();
		        
		        if (customerId == 0){
		            isDone = true;
		        }
		        else if (customerId > 3 || customerId < 0){
		            System.out.println("Unknown response, try again");
		            continue;
		        }
		        
		        break;
		    }
		    
	        if (isDone){
	            break;
	        }
		    
	        System.out.println("Nominal belanja?");
	        
	        customerPurchase = userInput.nextInt();
	        
	        switch (customerId){
	            case 1 -> customer1.addPoint(customerPurchase);
	            case 2 -> customer2.addPoint(customerPurchase);
	            case 3 -> customer3.addPoint(customerPurchase);
	            default -> {
                        }
	        }
	        
	        System.out.println();
	        System.out.println("Point");
	        System.out.println("Customer 1: " + customer1.getPoint());
    		System.out.println("Customer 2: " + customer2.getPoint());
    		System.out.println("Customer 3: " + customer3.getPoint());
	        
		}
		
        System.out.println();
	    System.out.println("All done");
	}
}

class Customer {
    private int customerPoint;
    
    public Customer(int initialPurchase) {
        if (initialPurchase <= 5_000_000){
            customerPoint = 100;
        }
        else {
            customerPoint = 200;
        }
    }
    
    public void addPoint(int customerPurchase){
        if (customerPurchase <= 1_000_000){
            customerPoint += 5;
        }
        else {
            customerPoint += 50;
        }
    }
    
    public int getPoint(){
        return customerPoint;
    }
}