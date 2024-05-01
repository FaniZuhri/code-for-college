package algotwleve;
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class AlgoCh12
{
	public static Scanner userInput = new Scanner(System.in);
	public static Customer[] customers = new Customer[5];
	
	public static void menuDisplayMembersPoints(){
	    System.out.println(
	        "################### MENU TAMPILAN POINT ######################"
	    );
	    for (int idx = 0; idx < 5; idx++){
	        System.out.println("Point Customer " + 
	                        (idx + 1) + ": " + customers[idx].getPoint());
	    }
	    System.out.println(
	        "###########################################################"
	    );
	    System.out.println();
	}
	
	public static void menuAddPoint(){
	    int customerId = 0, customerInputed = 0, customerTransaction = 0;
	    int customerPointBefore = 0;
	    
	    System.out.println(
	        "################### MENU PENAMBAHAN POINT ######################"
	    );
	    
	    System.out.print("Masukkan id customer (1-5): ");
	    customerId = userInput.nextInt() - 1;
	    System.out.println();
	    
	    System.out.print("Masukkan nilai transaksi: ");
	    customerTransaction = userInput.nextInt();
	    System.out.println();
	    
	    customerPointBefore = customers[customerId].getPoint();
	    customers[customerId].addPoint(customerTransaction);
	    
	    System.out.println("Penambahan point: " + 
	    (customers[customerId].getPoint() - customerPointBefore));
	    System.out.println(
	        "###########################################################"
	    );
	    System.out.println();
	}
	
	public static void menuUsePoint(){
	    int customerId = 0, customerInputed = 0, customerPointToBeUsed = 0;
	    int customerPointBefore = 0;
	    
	    System.out.println(
	        "################### MENU PENUKARAN POINT ######################"
	    );
	    
	    System.out.print("Masukkan id customer (1-5): ");
	    customerId = userInput.nextInt() - 1;
	    System.out.println();
	    
	    System.out.print("Masukkan jumlah point yang ingin digunakan: ");
	    customerPointToBeUsed = userInput.nextInt();
	    System.out.println();
	    
	    customerPointBefore = customers[customerId].getPoint();
	    
	    if (customerPointBefore - customerPointToBeUsed < 0) {
	        System.out.println("Jumlah point kurang!");
	       // return;
	    }
	    else{
    	    customers[customerId].usePoint(customerPointToBeUsed);
    	    
    	    System.out.println("Point terpakai: " + 
    	    customerPointToBeUsed);
	    }
	    
	    System.out.println("Sisa point: " + customers[customerId].getPoint());
	    System.out.println(
	        "###########################################################"
	    );
	    System.out.println();
	}
	
	public static void main(String[] args) {
	    customers[0] = new Customer(0);
	    customers[1] = new Customer(0);
	    customers[2] = new Customer(0);
	    customers[3] = new Customer(0);
	    customers[4] = new Customer(0);
	    int userMenuInput = 0;
	    boolean isUserOut = false;
		
		while (!isUserOut){
		    System.out.println("##################### MENU AWAL #################");
		    System.out.println("1. Tampilkan point semua customer");
		    System.out.println("2. Penambahan point customer");
		    System.out.println("3. Penukaran point customer");
		    System.out.println("0. KELUAR MENU");
		    System.out.println("#################################################");
		    
		    System.out.print("Masukkan menu (1-3): ");
		    userMenuInput = userInput.nextInt();
		    System.out.println();
		    
		    switch(userMenuInput){
		        case 0:
		            System.out.println("Keluar dari menu");
		            isUserOut = true;
		            break;
		        case 1:
		            menuDisplayMembersPoints();
		            break;
		        case 2:
		            menuAddPoint();
		            break;
		        case 3:
		            menuUsePoint();
		            break;
		        default:
		            System.out.println("Menu tidak ditemukan");
		            continue;
		    }
		}
		    
	}
}

class Customer {
    private int customerPoint;
    
    public Customer(int initialPoint) {
        customerPoint = initialPoint;
    }
    
    public void addPoint(int customerTransaction){
        if (customerTransaction >= 1_000_000){
            customerPoint += (0.03 * customerTransaction);
        }
    }
    
    public void usePoint(int pointToBeUsed){
        customerPoint -= pointToBeUsed;
    }
    
    public int getPoint(){
        return customerPoint;
    }
}